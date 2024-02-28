package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/features/OnyxMeta.feature",
		"src/test/java/features/OnyxMetaCreateCampaign.feature", "src/test/java/features/OnyxMetaSettings.feature",
		"src/test/java/features/OnyxMetaProductList.feature",
		"src/test/java/features/OnyxMetaHelp_FAQ.feature" }, plugin = { "pretty",
				"json:target/jsonReports/cucumber-reports.json",
				"html:target/cucumber-report/cucumber.html" }, glue = { "stepDefinition" }, tags = "")
public class TestRunner {

}