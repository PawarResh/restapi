package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class VeifyProName {

	@Test
	public void verify() throws SQLException
	{
		Response response = when().get("http://localhost:8084/projects");
		String proName = response.jsonPath().get("[0].projectName");
		System.out.println(proName);
		
		Connection con=null;
		String projectname=null;
		try {	
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			
			
			Statement stat = con.createStatement();
			
			
			ResultSet set = stat.executeQuery("select project_name from project where project_id ='TY_PROJ_001'");
			
			while(set.next()) {
				 projectname=set.getString(1);
				System.out.println(projectname);
			}
		}
	
			catch(Exception e) {

			}
			finally {
			
			con.close();
		}
		Assert.assertEquals(proName, projectname);
		Reporter.log("Project name is matching",true);
	}
	
}
