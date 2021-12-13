package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class pathParameter {
	@Test
	public void parameters() {
		String projectid="TY_PROJ_002";
	  given()
	        .pathParam("projectID",projectid)
	       
	        .when()
	              .delete("http://localhost:8084/projects/{projectID}")
	         .then()
	              .assertThat().statusCode(204) 
	              .log().all();
	              }
}