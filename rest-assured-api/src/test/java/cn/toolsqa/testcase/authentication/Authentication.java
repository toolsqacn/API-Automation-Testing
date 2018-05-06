package cn.toolsqa.testcase.authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.config.SessionConfig.sessionConfig;

public class Authentication {
	
	@Test
	public void AuthenticationBasics()
	{
		RestAssured.baseURI = "http://toolsqa.cn/demon/api";
		RequestSpecification request = RestAssured.given();

		request.auth().preemptive().basic("toolsqa","123456").get("/authorization/basic").then()
				.statusCode(201);

	}

}
