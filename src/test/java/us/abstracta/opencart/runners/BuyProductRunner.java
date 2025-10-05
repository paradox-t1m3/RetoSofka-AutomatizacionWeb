package us.abstracta.opencart.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Test runner for executing the buy product feature with Serenity and Cucumber.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/buyproduct.feature",
        glue = "us.abstracta.opencart.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class BuyProductRunner {
}
