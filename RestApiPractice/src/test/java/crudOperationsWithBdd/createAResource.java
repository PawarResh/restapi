package crudOperationsWithBdd;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class createAResource {
	@SuppressWarnings("unchecked")
	@Test
	public void craeteResources() {
		Random randomnum=new Random();
		int randomNo = randomnum.nextInt(11177);
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","Pawan kr"+randomNo);
		jobj.put("projectName","Vkite"+randomNo);
		jobj.put("status","completed");
		jobj.put("teamSize",7);
		
		given()
		.body(jobj)
		.and()
		.contentType(ContentType.JSON)
		 .when()
		 .post("http://localhost:8084/addProject")
		 .then()
		 .assertThat().statusCode(201)
		 .and()
		 .contentType(ContentType.JSON)
		 .log().all();
		}
}
