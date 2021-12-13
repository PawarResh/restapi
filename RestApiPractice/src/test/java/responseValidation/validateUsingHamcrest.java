package responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class validateUsingHamcrest {
	@Test
	public void validate() {
		when()
		     .get("http://localhost:8084/projects")
		.then()
		     //validation for response time using hamcrest matchers
		     .assertThat().time(Matchers.lessThan(1111l),TimeUnit.MILLISECONDS)
		     .and()
		     //validate a string value from response body using hamcrest matchers
		     .body("[0].projectName",Matchers.equalTo("Vkite586"))
		     .log().all();
		     }
}
