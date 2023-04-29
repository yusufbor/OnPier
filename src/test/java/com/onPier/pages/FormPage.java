package com.onPier.pages;

import com.onPier.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    public FormPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@id='mat-radio-2-input']")
    public static WebElement PrivatPerson;

    @FindBy(xpath = "//input[@id='mat-radio-3-input']")
    public static WebElement Unternehmen;

    @FindBy(id = "mat-select-value-1")
    public static WebElement selectAnrede;

    @FindBy(xpath = "//mat-option[@id='mat-option-0']")
    public static WebElement selectHerr;

    @FindBy(xpath = "//mat-option[@id='mat-option-1']")
    public static WebElement selectFrau;

    @FindBy(xpath = "//mat-option[@id='mat-option-2']")
    public static WebElement selectDivers;

    @FindBy(xpath = "//input[@placeholder='Max']")
    public static WebElement inputVorname;

    @FindBy(xpath = "//input[@placeholder='Mustermann']")
    public static WebElement inputNachname;

    @FindBy(xpath = "//input[@placeholder='max.mustermann@muster.de']")
    public static WebElement inputEMailAdresse;

    @FindBy(xpath = "//input[@placeholder='Max Mustermann']")
    public static WebElement inputKontoinhaber;

    @FindBy(xpath = "//input[@placeholder='z.B. DE45 7890 8965 5643 3454 00']")
    public static WebElement inputIBAN;

    @FindBy(linkText = "Weiter")
    public static WebElement weiterButton;


    public void login(String vorname, String nachname, String email, String kontainhaber, String iban) {
        selectAnrede.click();
        inputVorname.sendKeys(vorname);
        inputNachname.sendKeys(nachname);
        inputEMailAdresse.sendKeys(email);
        inputKontoinhaber.sendKeys(kontainhaber);
        inputIBAN.sendKeys(iban);
    }

}
