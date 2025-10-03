package us.abstracta.opencart.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import us.abstracta.opencart.questions.VerifySuccessMesageQuestion;
import us.abstracta.opencart.tasks.AddItemsToShoopingCartTask;
import us.abstracta.opencart.tasks.CheckoutProcessTask;

import java.util.List;

public class BuyProductStepDefinitions {
    @When("the user selects the product to purchase")
    public void theUserSelectsTheProductToPurchase() {
        OnStage.theActorInTheSpotlight().attemptsTo(AddItemsToShoopingCartTask.fromPage());
    }

    @When("the user completes the checkout")
    public void theUserCompletesTheCheckout(DataTable data) {
        List<String> info = data.values();
        OnStage.theActorInTheSpotlight().attemptsTo(CheckoutProcessTask.execute(info));
    }

    @Then("they should verify that the message {string} is displayed")
    public void theyShouldVerifyThatTheMessageIsDisplayed(String message) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerifySuccessMesageQuestion.displayed(message)));
    }
}
