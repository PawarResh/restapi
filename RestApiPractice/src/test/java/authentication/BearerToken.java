package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {

	@Test
	public void bearerToken() {
		
		given()
	    .auth().oauth2("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")
	.when()
	    .get("https://www.api.github.com/user/repos")
	    .then().log().all();
	}
}
