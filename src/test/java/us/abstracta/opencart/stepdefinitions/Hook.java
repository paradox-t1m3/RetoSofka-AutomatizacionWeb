package us.abstracta.opencart.stepdefinitions;

import com.codoid.products.exception.FilloException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import us.abstracta.opencart.utils.Constants;
import us.abstracta.opencart.utils.Driver;
import us.abstracta.opencart.utils.ReadExcel;

import java.util.List;

public class Hook {
    @Before
    public void inicializeActor() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor("El usuario");
    }

    @Given("the user opens the browser")
    public void theUserOpensTheBrowser(DataTable data) throws FilloException {
        List<String> info = data.values();
        List<String> rowExcel = ReadExcel.readRow(info.get(0),info.get(1),info.get(2));
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(Driver.onUrl(Constants.URL,rowExcel.get(0))));
    }
}
