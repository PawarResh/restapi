package crudOperationsWithBdd;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class updateTheResource {
	@SuppressWarnings("unchecked")
	@Test
	public void updateResources() {
		Random randomnum=new Random();
		int randomNo = randomnum.nextInt(11177);
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","Pawan kr"+randomNo);
		jobj.put("projectName","Vkite"+randomNo);
		jobj.put("status","completed");
		jobj.put("teamSize",7);
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		 
		.when()
		 .put("http://localhost:8084/projects/TY_PROJ_213")
		 
		 .then()
         .assertThat().contentType(ContentType.JSON)
		 .and()
		 .statusCode(200)
         .log().all();
}
}