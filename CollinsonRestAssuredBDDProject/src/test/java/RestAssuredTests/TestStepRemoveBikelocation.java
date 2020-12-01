package RestAssuredTests;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestStepRemoveBikelocation {

	@BeforeClass
	public static void createRequestSpecBuilder() {

		new RequestSpecBuilder().setBaseUri("https://api.citybik.es/v2/networks").setBasePath("/networks").build();

	}

	// @BeforeTest
	public void getNetworkRequest() throws InterruptedException {

		given().when().get("https://api.citybik.es/v2/networks").then().contentType(ContentType.JSON).extract()
				.response();

	}

	// Scenario3: As a user (biker), I will remove a bike location

	// @When("^I remove a new bike location$")

	@Test
	public void removeNewBikeLocation() throws Throwable {

		int empid = 55499;

		RestAssured.baseURI = "http://api.citybik.es/v2/networks";

		RequestSpecification request = RestAssured.given().header("Content-Type", "application/json");

		// Delete the request and check the response
		Response response = request.delete("/delete/" + empid);

		int statusCode = response.getStatusCode();

		System.out.println(response.asString());

		Assert.assertEquals(statusCode, 200);

	}

	// @Then("^User should not see removed bike location$")

	@Test
	public void checkBikeLocationRemoved() throws Throwable {

		int empid = 55499;

		RestAssured.baseURI = "/api.citybik.es/v2/networks";

		RequestSpecification request = RestAssured.given().header("Content-Type", "application/json");

		// Delete the request and check the response
		Response response = request.delete("/delete/" + empid);

		String jsonString = response.asString();

		Assert.assertEquals(jsonString.contains("successfully! deleted Records"), true);
	}

}