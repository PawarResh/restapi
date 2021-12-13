package CrudOperationsWithoutBdd;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class updateTheResource {
	@SuppressWarnings("unchecked")
	@Test
	public void updateateResources() {
		Random randomnum=new Random();
		int randomNo = randomnum.nextInt(1115);
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","Pawan kr"+randomNo);
		jobj.put("projectName","Vkite"+randomNo);
		jobj.put("status","completed");
		jobj.put("teamSize",7);
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.body(jobj);
		reqSpec.contentType("application/json");
		Response response = reqSpec.put("http://localhost:8084/projects/TY_PROJ_001");	
		ValidatableResponse validateResponse = response.then();
		validateResponse.assertThat().contentType(ContentType.JSON);
		validateResponse.assertThat().statusCode(200);

		validateResponse.log().all();
}		
}
