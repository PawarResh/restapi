package testCasesProject;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class addDuplicateProject {
	@SuppressWarnings("unchecked")
	@Test
	public void create(){
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Pawan");
		jobj.put("createdOn","string");
		jobj.put("projectId","string");
		jobj.put("projectName","deepak_pro-1");
		jobj.put("status","completed");
		jobj.put("teamSize","7");
				
			given()
			      .body(jobj)
			      .contentType(ContentType.JSON)
			.when()
			       .post("http://localhost:8084/addProject")
			       
			 .then()
			       .assertThat().statusCode(201)
			       .assertThat().contentType(ContentType.JSON)
			       
			 .log().all();
			}
}
