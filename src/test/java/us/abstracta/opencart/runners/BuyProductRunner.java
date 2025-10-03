package us.abstracta.opencart.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/us.abstracta.opencart/features/buyproduct.feature",
        glue = "us.abstracta.opencart.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class BuyProductRunner {
}
