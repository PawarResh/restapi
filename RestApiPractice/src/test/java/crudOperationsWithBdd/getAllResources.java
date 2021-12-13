package crudOperationsWithBdd;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class getAllResources {
	@Test
	public void getResources() {
		when()
		.get("http://localhost:8084/projects")
	.then()
		.log().all();
		}
}
