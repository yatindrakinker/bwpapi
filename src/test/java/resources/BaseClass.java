package resources;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass {
	
	public RequestSpecification requestSpec;
	public ResponseSpecification responseSpec;
	public Response response;
	public static String token = "";
	public static String onboardToken ;
}