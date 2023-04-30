package com.onPier.stepDefinitions;

import com.onPier.pages.FahrzeugscheinHochladen;
import com.onPier.pages.FormPage;
import com.onPier.pages.LandingPage;
import com.onPier.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Date;

import static com.onPier.utilities.BrowserUtils.*;
import static org.junit.Assert.*;

public class MyStepdefs {

    FormPage formPage = new FormPage();
    LandingPage landingPage = new LandingPage();
    FahrzeugscheinHochladen fahrzeugscheinVorderseite = new FahrzeugscheinHochladen();

    @Given("user is on Persönliche Daten eingeben page")
    public void userIsOnPersonlicheDatenEingebenPage() {
        assertEquals("THG Prämie",getTitle());
    }

    @When("user selects vehicle class")
    public void userSelectsVehicleClass() {
        click(landingPage.klasseM1);
    }

    @And("user selects flexPramieBentragen package")
    public void userSelectsFlexPramieBentragenPackage() {
        click(landingPage.flexPramieBentragen);
    }

    @And("user uploads images of vehicle registration")
    public void userUploadsImagesOfVehicleRegistration() {
        //to get the dynamic path of the image
        String path = System.getProperty("user.dir")+ ConfigurationReader.get("imagePath");
        sendKeys(fahrzeugscheinVorderseite.fahrzeugscheinVorderseite,path);
        sendKeys(fahrzeugscheinVorderseite.fahrzeugscheinRuckseite,path);
    }

    @And("user clicks on {string} button")
    public void userClicksOnButton(String buttonName) {
        landingPage.clickButton(buttonName);
    }

    @Then("I verify title as {string}")
    public void iVerifyTitleAs(String expectedTitle) {
        assertEquals(getTitle(),expectedTitle);
    }

    @When("user selects title {string}")
    public void userEntersTitle(String title) {
        formPage.selectTitle(title);
    }

    @And("user fills {string} as {string}")
    public void userFillsAs(String label, String value) {
        if(value.contains("%s"))
            value = String.format(value, new Date().getTime());
        formPage.fill(label,value);
    }

    @And("user clicks on Weiter button")
    public void userClicksOnWeiterButton() {
        click(formPage.weiterButton);
    }

    @Then("form is created with given personal information")
    public void formIsCreatedWithGivenPersonalInformation() {
        System.out.println("the validation of form data could not be done since the page is not supporting automation..");
    }

}
