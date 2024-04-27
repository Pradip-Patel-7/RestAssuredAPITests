package APITests;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostRequestTests extends BaseTest{

	@Test
	public void register_user()
	{
		HashMap map = new HashMap();
		map.put("email", "sydney@fife");
		
		Response res=
			given()
				.contentType("application/json")
				.body(map)
			.when()
				.post(RestAssured.baseURI+"api/register")
			.then()
				.statusCode(400)
				.log().body()
				.extract().response();
		String json = res.asString();
		Assert.assertEquals(json.contains("Missing password"), true);
		
	}
}
