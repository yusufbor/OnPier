package com.onPier.pages;

import com.onPier.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    public FormPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='space-y-1 text-center'])[1]")
    public WebElement fahrzeugscheinVorderseite ;

    @FindBy(xpath = "(//div[@class='space-y-1 text-center'])[2]")
    public WebElement fahrzeugscheinRückseite;

    @FindBy(xpath = "//input[@id='mat-radio-2-input']")
    public WebElement privatPerson;

    @FindBy(xpath = "//input[@id='mat-radio-3-input']")
    public WebElement unternehmen;

    @FindBy(id = "mat-select-value-1")
    public WebElement selectAnrede;

    @FindBy(xpath = "//mat-option[@id='mat-option-0']")
    public WebElement selectHerr;

    @FindBy(xpath = "//mat-option[@id='mat-option-1']")
    public WebElement selectFrau;

    @FindBy(xpath = "//mat-option[@id='mat-option-2']")
    public WebElement selectDivers;

    @FindBy(xpath = "//input[@placeholder='Max']")
    public WebElement inputVorname;

    @FindBy(xpath = "//input[@placeholder='Mustermann']")
    public WebElement inputNachname;

    @FindBy(xpath = "//input[@placeholder='max.mustermann@muster.de']")
    public WebElement inputEMailAdresse;

    @FindBy(xpath = "//input[@placeholder='Max Mustermann']")
    public WebElement inputKontoinhaber;

    @FindBy(xpath = "//input[@placeholder='z.B. DE45 7890 8965 5643 3454 00']")
    public WebElement inputIBAN;

    @FindBy(linkText = "Weiter")
    public WebElement weiterButton;


    public void login(String vorname, String nachname, String email, String kontainhaber, String iban) {
        selectAnrede.click();
        inputVorname.sendKeys(vorname);
        inputNachname.sendKeys(nachname);
        inputEMailAdresse.sendKeys(email);
        inputKontoinhaber.sendKeys(kontainhaber);
        inputIBAN.sendKeys(iban);
    }

    public void sleep(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
