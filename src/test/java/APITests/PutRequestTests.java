package APITests;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import util.HelperMethods;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class PutRequestTests extends BaseTest{
	String uri = RestAssured.baseURI;
	@Test
	public void create_user()
	{
		HashMap map = new HashMap();
		map.put("name", "morpheus");
		map.put("job", "zion resident");
		
			Response res = given()
				.contentType("application/json")
				.body(map)
			.when()
				.put(RestAssured.baseURI+"api/users/2")
			.then()
				.statusCode(200)
				.log().body()
				.extract().response();
				Assert.assertEquals(res.jsonPath().getString("name"), "morpheus");
				Assert.assertEquals(res.jsonPath().getString("job"), "zion resident");	
				Assert.assertEquals(res.jsonPath().getString("updatedAt").substring(0, 10), HelperMethods.getTodayDate("yyyy-MM-dd"));	

	}
}
