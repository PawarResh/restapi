package crudOperationsWithBdd;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class deleteResouce {
	@Test
	public void deleteResources() {
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_213")
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}
}
