package differentWaysToPostRequest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Random;

public class PostOperationsUsingHasmap {
	@SuppressWarnings("unchecked")
	@Test
	public void create() {
		Random randomnum=new Random();
		int randomNo = randomnum.nextInt(111);
HashMap hashmap=new HashMap();
hashmap.put("createdBy","Pawan kr"+randomNo);
hashmap.put("projectName","Vkite"+randomNo);
hashmap.put("status","ongoing");
hashmap.put("teamSize",11);
		
given()
      .body(hashmap)
      .contentType(ContentType.JSON)

.when()
	.post("http://localhost:8084/addProject")
	.then()
    .assertThat()
    .statusCode(201)
    .contentType(ContentType.JSON)
	.log().all();
		}
	}
