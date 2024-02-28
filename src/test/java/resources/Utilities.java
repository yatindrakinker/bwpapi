package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utilities {
	


	
	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {
		if (req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
//			Request --> set
			req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addHeader("Content-Type", "application/json")
					.addHeader("apptag", "bwp_meta")
					.addHeader("appcode", "eyJvbnl4IjoiYndwIiwiZmFjZWJvb2siOiJtZXRhIn0==")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			return req;
		}
		return req;
	}
	
//	public boolean validateHeader(String key, String expectedValue) {
//		if(baseClassObj.response.header("Content-Type").equals(expectedValue)) {
//			return true;
//		}
//		return false;
//	}

	public String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		String propertiesPath = System.getProperty("user.dir") + "/src/test/java/resources/global.properties";
		FileInputStream fis = new FileInputStream(propertiesPath);
		prop.load(fis);

		return prop.getProperty(key);
	}
	
	public String getJsonPath(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}
	
	public void holdScript(int seconds) {
		
		try {
			Thread.sleep(seconds *= 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
