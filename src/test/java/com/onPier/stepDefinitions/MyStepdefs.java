package com.onPier.stepDefinitions;

import com.onPier.pages.FormPage;
import com.onPier.pages.LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {

    FormPage formPage = new FormPage();
    LandingPage landingPage = new LandingPage();

    @Given("user is on Persönliche Daten eingeben page")
    public void userIsOnPersönlicheDatenEingebenPage() {
        System.out.println("this is first step");
        landingPage.klasseM1.click();
        formPage.sleep();
        landingPage.flexPramieBentragen.click();
        formPage.sleep();
        formPage.fahrzeugscheinVorderseite.sendKeys("ss1.png");
        formPage.sleep();
        formPage.fahrzeugscheinRückseite.sendKeys("ss1.png");
        formPage.sleep();


    }

    @Given("user is on Privatperson form")
    public void userIsOnPrivatpersonForm() {

    }

    @When("user enters title {string}")
    public void userEntersTitle(String arg0) {
    }

    @And("user enters first name {string}")
    public void userEntersFirstName(String arg0) {
    }

    @And("user enters surname {string}")
    public void userEntersSurname(String arg0) {
    }

    @And("user enters email adress {string}")
    public void userEntersEmailAdress(String arg0) {
    }

    @And("user enters account holder {string}")
    public void userEntersAccountHolder(String arg0) {
    }

    @And("user enters iban no {string}")
    public void userEntersIbanNo(String arg0) {
    }

    @And("user clicks on Weiter button")
    public void userClicksOnWeiterButton() {
    }

    @Then("form is created with given personal information")
    public void formIsCreatedWithGivenPersonalInformation() {
    }

    @When("user enters a letter as a name")
    public void userEntersALetterAsAName() {
    }

    @Then("error message appears under the Vorname field")
    public void errorMessageAppearsUnderTheVornameField() {
    }

    @When("user enters a letter as a surname")
    public void userEntersALetterAsASurname() {
    }

    @Then("error message appears under the Nachname field")
    public void errorMessageAppearsUnderTheNachnameField() {
    }

    @When("user enters a different account holder name")
    public void userEntersADifferentAccountHolderName() {
    }

    @Then("user verifies account holder name and person name can be different")
    public void userVerifiesAccountHolderNameAndPersonNameCanBeDifferent() {
    }

    @When("user enters the Account holder name")
    public void userEntersTheAccountHolderName() {
    }

    @Then("user verifies Account holder name and person name can be same")
    public void userVerifiesAccountHolderNameAndPersonNameCanBeSame() {
    }

    @When("user enters invalid email")
    public void userEntersInvalidEmail() {
    }

    @Then("the form is created with invalid email")
    public void theFormIsCreatedWithInvalidEmail() {
    }

    @When("user enters  the same email")
    public void userEntersTheSameEmail() {
    }

    @Then("new user is created with the same email")
    public void newUserIsCreatedWithTheSameEmail() {
    }

    @When("user enters the {string} number in the IBAN box")
    public void userEntersTheNumberInTheIBANBox(String arg0) {
    }

    @Then("account is created")
    public void accountIsCreated() {
    }

    @When("user enters the invalid {string} number in the IBAN box")
    public void userEntersTheInvalidNumberInTheIBANBox(String arg0) {
    }

    @Then("warning message is on screen, under the IBAN box")
    public void warningMessageIsOnScreenUnderTheIBANBox() {
    }
}
