package CrudOperationsWithoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class deleteOneResource {
	@Test
	public void deleteResources() {
	Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_214");
	ValidatableResponse validateResponse = response.then();
	validateResponse.assertThat().statusCode(204);
	validateResponse.log().all();
	}
}
