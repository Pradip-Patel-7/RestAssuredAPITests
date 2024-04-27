package APITests;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import baseClass.BaseTest;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

public class GetRequestTests extends BaseTest {
	@Test
	public void get_single_user()
	{
		given()
		.when()
			.get(RestAssured.baseURI+"api/users/2")
		.then()
			.statusCode(200)
			.log().body()
			.body("data.email", equalTo("janet.weaver@reqres.in"))
			.body("data.last_name", equalTo("Weaver"))
			.body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"))
			;
	}
}
