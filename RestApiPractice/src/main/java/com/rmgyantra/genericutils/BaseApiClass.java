package com.rmgyantra.genericutils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseApiClass {

public DataBaseUtility dbLib=new DataBaseUtility();
	
	@BeforeSuite
	public void configBS() {
		System.out.println("---->start----->");
		baseURI ="http://localhost";
		port=8084;
		dbLib.connectToDB();
		System.out.println("database connection is established");
	}
	
	@AfterSuite
	public void configAS() throws Throwable {
		dbLib.closeDb();
		System.out.println("database is closed");
	}
}
