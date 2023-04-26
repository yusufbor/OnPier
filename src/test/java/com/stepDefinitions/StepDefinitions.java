package com.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("I am in personal information page")
    public void ıAmInPersonalInformationPage() {
        System.out.println("this is first step");
    }

    @When("I fill out the form with {string} {string} {string} {string} {string} {string}")
    public void ıFillOutTheFormWith(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
    }

    @And("I click on {string} button")
    public void ıClickOnButton(String arg0) {
    }

    @Then("I verify personal information is correct")
    public void ıVerifyPersonalInformationIsCorrect() {
    }

    @When("I get the Account holder name")
    public void ıGetTheAccountHolderName() {
    }

    @Then("I verify Account holder name and person name can be same")
    public void ıVerifyAccountHolderNameAndPersonNameCanBeSame() {
    }

    @When("I try to create with the same email")
    public void ıTryToCreateWithTheSameEmail() {
    }

    @Then("I verified the warning message")
    public void ıVerifiedTheWarningMessage() {
    }

    @Then("I verify account is created with the same IBAN")
    public void ıVerifyAccountIsCreatedWithTheSameIBAN() {
    }
}
