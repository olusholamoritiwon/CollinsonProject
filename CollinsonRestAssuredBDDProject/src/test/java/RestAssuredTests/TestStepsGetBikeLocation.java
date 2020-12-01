package RestAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class TestStepsGetBikeLocation {

	private RequestSpecification request;

	@BeforeClass
	public static void createRequestSpecBuilder() {

		new RequestSpecBuilder().setBaseUri("http://api.citybik.es/v2/networks").setBasePath("/v2/networks").build();

	}

	// @BeforeTest
	public void getNetworkRequest() throws InterruptedException {

		given().when().get("http://api.citybik.es/v2/networks").then().contentType(ContentType.JSON).extract()
				.response();

	}

	// Scenario1: As a user (biker), I will like to know the exact location of city
	// bikes around the world

	// @Given("^I want to execute getBikeLocationList endpoint$")
	@Test
	public void goToCityBikeSite() throws Throwable {

		given().when().get("http://api.citybik.es/v2/networks").then().body("company", equalTo("PBSC"));
	}

	// @And("^Check for a list of bike locations$")

	@Test
	public void checkCityBikeSite() throws Throwable {

		given().when().get("http://api.citybik.es/v2/networks").then().log().body();
	}

	// @Then("I should also get 200 success status code$")

	@Test
	public void verify_status_code() {

		RestAssured.given().spec(request).when().get("http://api.citybik.es/v2/networks")

				.then().assertThat().statusCode(200);

	}

// @And("^verify response includes a nominated location from response body$")

	@Test
	public void checkNamedLocationFromBodyOfResponse() {

		given().when().get("http://api.citybik.es/v2/networks").then().body("location.city", equalTo("Monza"));

	}

}