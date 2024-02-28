package stepDefinition;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import resources.BaseClass;
import resources.TestDataBuild;
import resources.Utilities;

public class StepDefinitionOnboarding extends Utilities {
	TestDataBuild testDataBuild = new TestDataBuild();

	WebDriver driver;
	String url = "";
	
	BaseClass baseClassObj;

	public StepDefinitionOnboarding(BaseClass baseClassObj) {
		this.baseClassObj = baseClassObj;
	}
	
	
	@Given("Onboarding url")
	public void onboarding_url() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("disable-gpu");
		driver = new ChromeDriver(chromeOptions);
//		driver = new ChromeDriver();
	}
	
	@When("User hits the url the access token is generated in new url")
	public void user_hits_the_url_the_access_token_is_generated_in_new_url() {
	  driver.get("https://testing-api-backend.bwpapps.com/apiconnect/request/auth/?sAppId=1");
	  url = driver.getCurrentUrl();
	}
	
	@Then("User after extracting token from url used it to register himself.")
	public void user_after_extracting_token_from_url_used_it_to_register_himself() {
		BaseClass.onboardToken = StringUtils.substringAfter(url, "=");
		BaseClass.onboardToken= StringUtils.substringBefore(BaseClass.onboardToken, "&");
		System.out.println("onboardToken = " + BaseClass.onboardToken);
	}



	


}
