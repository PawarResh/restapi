package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class parametersUsingGithub {
	@Test
	public void validate() {
		given()
		      .pathParam("username","PAWAN0657")
		      .queryParam("sort","created")
		      .queryParam("sort", "updated")
		      
		.when()
		      .get("http://api.github.com/users/{username}/repos")
		 .then()
		      .log().all();
		      }
}
