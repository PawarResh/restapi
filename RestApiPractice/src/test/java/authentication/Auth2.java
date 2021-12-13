package authentication;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class Auth2 {

	public void oAuth2()
	{
		Response response = given()
		.formParam("client_id", "rj")
		.formParam("client_secret", "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")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://www.example.com")
		  
		  .when().post("http://coop.apps.symfonycasts.com/token");

		String token = response.jsonPath().get("access_token");
		System.out.println(token);	
		
		given()
		  .auth().oauth2(token)
		  .pathParam("USER_ID", 2555)
		  .when()
		  .post("http://coop.apps.symfonycasts.com/api/USER_ID/eggs-count")
		  .then().log().all();
	}
}
