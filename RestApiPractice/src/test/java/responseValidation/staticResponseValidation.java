package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class staticResponseValidation {
	@Test
	public void validation() {
		 String expectedProjName = "Vkite586";
		Response response = when()
		 .get("http://localhost:8084/projects");
		 
		 String actualProjName = response.jsonPath().get("[0].projectName");
		 
		 response.then().statusCode(200).and().contentType(ContentType.JSON)
		 .log().all();
		 
		 Assert.assertEquals(actualProjName, expectedProjName);
		 }
}
