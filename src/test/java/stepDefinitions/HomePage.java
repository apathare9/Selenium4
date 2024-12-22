package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.BrowserDriver;

public class HomePage extends BrowserDriver {

    @Given("User navigates to the Online products page")
    public void user_navigates_to_the_online_products_page() {
        String website = "https://www.amazon.in";
        openWebsite(website);
        System.out.println("Works...");
    }
    @When("User clicks on Formal Shoes drop down")
    public void user_clicks_on_formal_shoes_drop_down() {
        System.out.println("Works2...");
    }
    @Then("User should be able to view the Products")
    public void user_should_be_able_to_view_the_products() {
        System.out.println("Works3...");
    }


}
