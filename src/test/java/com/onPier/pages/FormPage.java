package com.onPier.pages;

import com.onPier.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    public FormPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//input[@id='mat-radio-2-input']")
    public static WebElement PrivatPerson;

    public void PrivatPerson(){
        this.PrivatPerson.click();
    }

    @FindBy( xpath= "//input[@id='mat-radio-3-input']")
    public static WebElement Unternehmen;

    public void Unternehmen(){
        this.Unternehmen.click();
    }

    @FindBy(className = "mdc-list-item__primary-text")
    public static WebElement selectAnrede;

    @FindBy(xpath = "//input[@class='rounded w-full pl-4 ng-valid ng-star-inserted ng-dirty ng-touched']")
    public static WebElement inputVorname;

    @FindBy(xpath = "//input[@placeholder='Mustermann']")
    public static WebElement inputNachname;

    @FindBy(xpath = "(//input[@class='rounded w-full pl-4 ng-valid ng-star-inserted ng-dirty ng-touched'])[3]")
    public static WebElement inputEMailAdresse;

    @FindBy(xpath = "(//input[@class='rounded w-full pl-4 ng-valid ng-star-inserted ng-dirty ng-touched'])[4]")
    public static WebElement inputKontoinhaber;

    @FindBy(xpath = "//input[@class='rounded w-full pl-4 ng-star-inserted ng-dirty ng-touched ng-valid']")
    public static WebElement inputIBAN;

    @FindBy(linkText = "Weiter")
    public static WebElement weiterButton;




    public void login(String vorname, String nachname, String email, String kontainhaber, String iban){
        selectAnrede.click();
        inputVorname.sendKeys(vorname);
        inputNachname.sendKeys(nachname);
        inputEMailAdresse.sendKeys(email);
        inputKontoinhaber.sendKeys(kontainhaber);
        inputIBAN.sendKeys(iban);
    }

}
