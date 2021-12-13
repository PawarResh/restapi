package responseValidation;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class dynamicResponseValidation {
	@Test
	public void validation() {
		boolean flag = false; 
		String expectedProjId = "TY_PROJ_001";
		Response response = when()
		 .get("http://localhost:8084/projects");
		 
		 List<String> actualProjId = response.jsonPath().get("projectId");
		 
		 response.then().statusCode(200).and().contentType(ContentType.JSON)
		 .log().all();
		 
		 for (String projid :actualProjId ) {
			 if (projid.equals(expectedProjId)) {
				 flag=true;
				}
			}
		 Assert.assertEquals(flag,true);
		 }
}
