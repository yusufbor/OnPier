package com.onPier.stepDefinitions;

import com.onPier.pages.FahrzeugscheinHochladen;
import com.onPier.pages.FormPage;
import com.onPier.pages.LandingPage;
import com.onPier.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.onPier.utilities.BrowserUtils.*;
import static com.onPier.utilities.Log.*;
import static org.junit.Assert.*;

public class MyStepdefs {

    FormPage formPage = new FormPage();
    LandingPage landingPage = new LandingPage();
    FahrzeugscheinHochladen fahrzeugscheinVorderseite = new FahrzeugscheinHochladen();

    @Given("user is on Persönliche Daten eingeben page")
    public void userIsOnPersonlicheDatenEingebenPage() {
        assertEquals("THG Prämie", getTitle());
    }

    @When("user selects vehicle class")
    public void userSelectsVehicleClass() {
        click(landingPage.getKlasseM1());
    }

    @And("user selects flexPramieBentragen package")
    public void userSelectsFlexPramieBentragenPackage() {
        click(landingPage.getFlexPramieBentragen());
    }

    @And("user uploads images of vehicle registration")
    public void userUploadsImagesOfVehicleRegistration() {
        //to get the dynamic path of the image
        String path = System.getProperty("user.dir") + ConfigurationReader.get("imagePath");
        sendKeys(fahrzeugscheinVorderseite.getFahrzeugscheinVorderseite(), path);
        sendKeys(fahrzeugscheinVorderseite.getFahrzeugscheinRuckseite(), path);
    }

    @And("user clicks on {string} button")
    public void userClicksOnButton(String buttonName) {
        landingPage.clickButton(buttonName);
    }

    @Then("user verifies title as {string}")
    public void userVerifiesTitleAs(String expectedTitle) {
        log("Verifying title as "+ expectedTitle);
        assertEquals(getTitle(), expectedTitle);
    }

    @When("user selects title {string}")
    public void userEntersTitle(String title) {
        log("Selecting title as "+ title);
        formPage.selectTitle(title);
    }

    @And("user fills {string} as {string}")
    public void userFillsAs(String label, String value) {
        if (value.contains("%s"))
            value = String.format(value, new Date().getTime());
        formPage.fill(label, value + Keys.ENTER);
    }

    @And("user clicks on Weiter button")
    public void userClicksOnWeiterButton() {
        click(formPage.getWeiterButton());
    }

    @Then("form is created with given personal information")
    public void formIsCreatedWithGivenPersonalInformation(List<String> list) {
        for (String each : list) {
            formPage.checkInfo(each);
        }
        log("the validation of form data is done");
    }

    @When("user enters a letter as nachname {string}")
    public void userEntersALetterAsNachname(String nachnameLetter) {
        formPage.getInputNachname().sendKeys(nachnameLetter);
    }

    @When("user clicks on Zurück button")
    public void userClicksOnZurückButton() {
        formPage.getZurückButton().click();
    }

    @Then("user lands on previous page")
    public void userLandsOnPreviousPage() {
        assertEquals("THG Prämie", getTitle());
    }

    @Then("user validates the validation messages")
    public void userValidatesTheValidationMessages(List<Map<String, String>> data) {
        for (Map<String, String> datum : data) {
            String label = datum.get("label");
            String value = datum.get("value") == null ? "" : datum.get("value");
            String expectedMessage = datum.get("expectedMessage");
            log(String.format("validating %s field against %s", label, value));
            formPage.fill(label, value);
            String actualMessage = formPage.getValidationMessageByFieldName(label);
            assertEquals(expectedMessage, actualMessage);
        }
    }
}

