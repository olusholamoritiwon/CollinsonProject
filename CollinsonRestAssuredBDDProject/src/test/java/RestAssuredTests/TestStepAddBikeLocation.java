package RestAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class TestStepAddBikeLocation {

	private static String payload = "{\n" + "  \"Company\": \"Some Company\",\n" + "  \"href\": \"some href\",\n"
			+ "  \"id\": \"some id\"\n" + "  \"location\": \"some location\",\n" + "  \"City\": \"some city\",\n"
			+ "  \"Country\": \"some country\",\n" + "  \"Longitude\": \"Some longitude\",\n"
			+ "  \"Latitude\": \"Some latitude\"\n " + "}";

	@BeforeClass
	public static void createRequestSpecBuilder() {

		new RequestSpecBuilder().setBaseUri("http://api.citybik.es/v2").setBasePath("/networks").build();

	}

	// Scenario2: As a user (biker), i will like to add a new bike loccation

	// @Given("^ A bike location is added as a post request$")

	@Test
	public static void AddNewBikeLocationPayload() {

		given().contentType(ContentType.JSON).body(payload).post("http://api.citybik.es/v2/networks").then()
				.statusCode(200).extract().response();

	}

//	@Then("^Should return a response status code of 201$")

	@Test
	public void returnResponseStatusCode() throws Throwable {

		given().header("Accept", ContentType.JSON.getAcceptHeader())

				.post("http://api.citybik.es/v2/networks").then()

				.statusCode(200);
	}

	// @And("^response includes a nominated location from result$")

	@Test
	public void checkALocationToVerifyResponseBody() {

		given().when().get("http://api.citybik.es/v2/networks").then().body("location.city", equalTo("Frankfurt"));

	}
}
