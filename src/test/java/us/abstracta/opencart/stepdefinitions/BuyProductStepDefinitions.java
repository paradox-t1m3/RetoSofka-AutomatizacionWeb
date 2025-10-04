package us.abstracta.opencart.stepdefinitions;

import com.codoid.products.exception.FilloException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import us.abstracta.opencart.questions.TheEmptyCartMessageIsShown;
import us.abstracta.opencart.questions.VerifySuccessMesageQuestion;
import us.abstracta.opencart.tasks.AddItemsToShoopingCartTask;
import us.abstracta.opencart.tasks.CheckoutProcessTask;
import us.abstracta.opencart.tasks.OpenEmptyShoopingCart;
import us.abstracta.opencart.utils.Constants;
import us.abstracta.opencart.utils.Driver;
import us.abstracta.opencart.utils.ReadExcel;

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

    @When("the user selects the shopping cart without adding any products")
    public void theUserSelectsTheShoppingCartWithoutAddingAnyProducts(){
        OnStage.theActorInTheSpotlight().attemptsTo(OpenEmptyShoopingCart.fromHomePage());
    }

    @Then("they should verify that the message {string} is displayed")
    public void theyShouldVerifyThatTheMessageIsDisplayed(String message) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerifySuccessMesageQuestion.displayed(message)));
    }


    @Then("the user should verify that the correct message is displayed")
    public void theUserShouldVerifyThatTheCorrectMessageIsDisplayed(DataTable data) throws FilloException {
        List<String> info = data.values();
        List<String> rowExcel = ReadExcel.readRow(info.get(0),info.get(1),info.get(2));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheEmptyCartMessageIsShown.fromPageHome(rowExcel)));
    }
}
