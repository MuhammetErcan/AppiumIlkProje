package gun03;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.App;
import utils.Device;

import java.util.List;

import static utils.Utils.openApp;

public class CalculatorSteps {

    @Given("user on start page")
    public void userOnStartPage() {
        openApp(Device.Samsung, App.CALCULATOR);
    }

    @When("user sum the following numbers")
    public void userSumTheFollowingNumbers(DataTable table) {
        List<Integer> list=table.asList(Integer.class);
        System.out.println(list);

    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int result) {
        System.out.println(result);

    }
}
