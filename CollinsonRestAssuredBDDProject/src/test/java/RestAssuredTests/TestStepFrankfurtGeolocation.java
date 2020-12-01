package RestAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;

public class TestStepFrankfurtGeolocation {

	@BeforeClass
	public static void createRequestSpecBuilder() {

		new RequestSpecBuilder().setBaseUri("//api.citybik.es/v2").setBasePath("/networks").build();

	}

	// As a user I want to verify that the city Frankfurt is in Germany and return
	// their corresponded latitude and longitude

	@Test
	public void testHttpLogReguest_extractCityfromResponseBody_assertEqualToGermany() {

		given().when().get("http://api.citybik.es/v2/networks").then()
				.body("company.Nextbike Gmbh", equalTo("Frankfurt")).body("location.country", equalTo("DE"));

	}

	@Test
	public void testHttpLogReguest_extractLattitudefromResponseBody() {

		given().when().get("http://api.citybik.es/v2/networks").then().body("name:Visa", equalTo("Frankfurt"))
				.body("location.country", equalTo("DE")).body("latitude", equalTo("50.1072"));

	}

	@Test
	public void testHttpLogReguest_extractLongitudefromResponseBody() {

		given().when().get("http://api.citybik.es/v2/networks").then().body("id:visa-frankfurt", equalTo("Frankfurt"))
				.body("location.country", equalTo("DE")).body("location.longitude", equalTo("8.66375"));
	}

}
