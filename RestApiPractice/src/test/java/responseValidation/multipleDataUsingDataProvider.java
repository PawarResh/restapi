package responseValidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generics.pojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class multipleDataUsingDataProvider {
	@Test(dataProvider="get_data")
	public void getResources(String createdBy,String projectName,String status,String teamSize) {
		
		pojoLibrary pojoObject=new pojoLibrary(createdBy,projectName,status,teamSize);
		given()
		      .body(pojoObject)
		      .contentType(ContentType.JSON)
		      
		.when()
		     .post("http://localhost:8084/addProject")
		     .then()
		     .assertThat()
		     .contentType(ContentType.JSON)
		     .statusCode(201)
		     .log().all();
	}
	@DataProvider
	public Object[][] get_data(){
		Object[][] obj=new Object[2][4];
		obj[0][0]="prithvi";
		obj[0][1]="vkite11";
		obj[0][2]="ongoing";
		obj[0][3]="45";
		
		obj[1][0]="akash";
		obj[1][1]="vkite19";
		obj[1][2]="completed";
		obj[1][3]="99";
		return obj;
	}
}