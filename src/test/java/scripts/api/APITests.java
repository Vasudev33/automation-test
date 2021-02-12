package scripts.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import utils.AllConstants;
import utils.Utility;

public class APITests implements AllConstants {

	@BeforeClass
	public void setup() throws InterruptedException {
		RestAssured.baseURI = Utility.getPropertyValue(CONFIG_PATH, "BASE_URI");
	}

	@Test()
	public void TestValidStatusCode() {
		try {
			given()
				.when()
				.get("latest")
				.then()
				.assertThat().statusCode(200).and()
				.contentType(containsString("application/json"));
		} catch (AssertionError e) {
			Assert.fail("Test failed,some error occurred" + e.getMessage());
		}
	}

	@Test()
	public void TestResponseForInvalidURI() {
		try {
			RestAssured.baseURI = "https://api.spacexdata.com/v4/test";
			given()
				.when()
				.get("latest")
				.then()
				.assertThat().statusCode(404).and()
				.contentType(containsString("text/plain"));
		} catch (AssertionError e) {
			Assert.fail("Test failed,some error occurred" + e.getMessage());
		}
		finally {
			RestAssured.baseURI = Utility.getPropertyValue(CONFIG_PATH, "BASE_URI");
		}
	}

	@Test()
	public void TestMandatoryFieldsInResponse() {
		try {
			JSONParser jsonParser = new JSONParser();
			InputStream response = given()
										.when()
										.get("latest")
										.getBody().asInputStream();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(response));
			
			Assert.assertEquals(jsonObject.get("launchpad"), "5e9e4501f509094ba4566f84");
			Assert.assertEquals(jsonObject.get("rocket"), "5e9d0d95eda69973a809d1ec");
			Assert.assertEquals(Integer.parseInt(jsonObject.get("flight_number").toString()), 116);
			Assert.assertEquals(jsonObject.get("id"), "5ff6554f9257f579ee3a6c5f");
			Assert.assertEquals(jsonObject.get("success"), true);
			
			JSONArray cores = (JSONArray) jsonObject.get("cores");
			JSONObject values = (JSONObject) cores.get(0);
			
			Assert.assertEquals(values.get("core"), "5ef670f10059c33cee4a826c");
			Assert.assertEquals(Integer.parseInt(values.get("flight").toString()), 5);
			Assert.assertEquals(values.get("gridfins"), true);
			Assert.assertEquals(values.get("landing_attempt"), true);
			Assert.assertEquals(values.get("legs"), true);
			Assert.assertEquals(values.get("landpad"), "5e9e3032383ecb6bb234e7ca");
			Assert.assertEquals(values.get("reused"), true);
			Assert.assertEquals(values.get("landing_success"), true);
		} catch (IOException | ParseException e) {
			Assert.fail("Test failed,some error occurred" + e.getMessage());
		}
	}
}
