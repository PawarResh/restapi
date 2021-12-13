package authentication;

import static io.restassured.RestAssured.*;

public class BasicAuth {

	public void basicauth() {
		
		given()
		    .auth().basic("rmgyantra","rmgy@9999")
		.when()
		    .get("http://localhost:8084/login")
		    .then().log().all();
	}
}
