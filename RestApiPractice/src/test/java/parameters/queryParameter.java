package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class queryParameter {
	@Test
	public void parameters() {
	  given()
	       .queryParam("page","2")
	        .when()
	              .get("https://reqres.in/api/users")
	              
	        .then()
	              .log().all();
	}
}
