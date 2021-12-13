package CrudOperationsWithoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllResources {
@Test
public void getResources() {
	Response response = RestAssured.get("http://localhost:8084/projects");
	///System.out.println(response.prettyPeek());
	///System.out.println(response.prettyPrint());
	///System.out.println(response.asString());
	
	System.out.println(response.getContentType());
	System.out.println(response.getTime());
	System.out.println(response.getStatusCode());
	System.out.println(response.getHeaders());
	System.out.println(response.getSessionId());
	
	ValidatableResponse validateResponse = response.then();
	validateResponse.log().all();
	}
}
