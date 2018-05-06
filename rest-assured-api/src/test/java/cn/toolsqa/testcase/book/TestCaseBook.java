package cn.toolsqa.testcase.book;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import cn.toolsqa.datafactory.TestCaseDataFactory;
import cn.toolsqa.testcase.TestCase;

public class TestCaseBook{
	  
	  private String baseurl;
	  
	  private TestCase testCase;
	  
	   	@BeforeTest
		public void preConditions() {
			baseurl = TestCaseDataFactory.loadTestSuit().baseurl;
			testCase = TestCaseDataFactory.loadDataByCaseId("rest-assured-book");
		}
	
		@Test
		public void testResponse()
		{   
			// Restful Web 根地址
			RestAssured.baseURI = baseurl;

			// Get the RequestSpecification of the request that you want to sent
			// to the server. The server is specified by the BaseURI that we have
			// specified in the above step.
			RequestSpecification httpRequest = RestAssured.given();
           
			String targeturl = testCase.getPreconditions().get("url")+"/"+testCase.getTestData("id");
			
			Response response = httpRequest.request(Method.GET, targeturl);

			// Now let us print the body of the message to see what response
			// we have recieved from the server
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is =>  " + responseBody);
			
			

		}
		
		
}
