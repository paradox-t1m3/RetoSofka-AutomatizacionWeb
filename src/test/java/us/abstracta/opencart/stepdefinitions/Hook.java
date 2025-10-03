package us.abstracta.opencart.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import us.abstracta.opencart.utils.Constants;
import us.abstracta.opencart.utils.Driver;

import java.util.List;

public class Hook {
    @Before
    public void inicializeActor() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor("El usuario");
    }

    @Given("the user opens the browser")
    public void theUserOpensTheBrowser(DataTable data) {
        List<String> info = data.values();
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(Driver.onUrl(Constants.URL,info.get(0))));
    }
}
