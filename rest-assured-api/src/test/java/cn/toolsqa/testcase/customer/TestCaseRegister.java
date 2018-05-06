package cn.toolsqa.testcase.customer;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import cn.toolsqa.datafactory.TestCaseDataFactory;
import cn.toolsqa.model.RegistrationFailureResponse;
import cn.toolsqa.model.RegistrationSuccessResponse;
import cn.toolsqa.testcase.TestCase;

public class TestCaseRegister {

	private String baseurl;
	  
	private TestCase testCase;

	@BeforeTest
	public void preConditions() {
		baseurl = TestCaseDataFactory.loadTestSuit().baseurl;
		testCase = TestCaseDataFactory.loadDataByCaseId("rest-assured-customer");
	}
	   
	@Test
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
	 
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "rest"); // Cast
		requestParams.put("LastName", "asserued");
		requestParams.put("UserName", "xiaoaojianghu2018");
		requestParams.put("Password", "password1");
	 
		requestParams.put("Email",  "yaoli@gmail.com");
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");
	 
		String statusCode = String.valueOf(response.getStatusCode());
		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}
	
	@Test
	public void RegistrationSuccessfulDeserialization()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
	 
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "63userf2d3d2011");
		requestParams.put("Password", "password1");	
		requestParams.put("Email",  "ed26dff39@gmail.com");
	 
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");
	 
		ResponseBody body = response.getBody();
	 
		// Deserialize the Response body into RegistrationSuccessResponse
		RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);
	 
		// Use the RegistrationSuccessResponse class instance to Assert the values of 
		// Response.
		Assert.assertEquals("OPERATION_SUCCESS", responseBody.getSuccessCode());
		Assert.assertEquals("Operation completed successfully", responseBody.getMessage());
	}
	

	@Test
	public void RegistrationSuccessfulOrFailure()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
	 
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "63userf2d3d2011");
		requestParams.put("Password", "password1");	
		requestParams.put("Email",  "ed26dff39@gmail.com");
	 
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");
	 
		ResponseBody body = response.getBody();
		System.out.println(response.body().asString());
	 
		if(response.statusCode() == 200)
		{
			// Deserialize the Response body into RegistrationFailureResponse
			RegistrationFailureResponse responseBody = body.as(RegistrationFailureResponse.class);
	 
			// Use the RegistrationFailureResponse class instance to Assert the values of 
			// Response.
			//"FaultId": "FAULT_USER_INVALID_USER_PASSWORD",
		    //"fault": "Invalid username or password"
			Assert.assertEquals("User already exists", responseBody.getFault());
			Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody.getFaultId());	
		}
		else if (response.statusCode() == 201)
		{
			// Deserialize the Response body into RegistrationSuccessResponse
			RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);
			// Use the RegistrationSuccessResponse class instance to Assert the values of 
			// Response.
			Assert.assertEquals("OPERATION_SUCCESS", responseBody.getSuccessCode());
			Assert.assertEquals("Operation completed successfully", responseBody.getMessage());	
		}	
	}
}
