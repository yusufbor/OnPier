package com.onPier.pages;

import com.onPier.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    public FormPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "")
    public WebElement selectAnrede;

    @FindBy(name = "")
    public WebElement inputVorname;

    @FindBy(name = "")
    public WebElement inputNachname;

    @FindBy(name = "")
    public WebElement inputEMailAdresse;

    @FindBy(name = "")
    public WebElement inputKontoinhaber;

    @FindBy(name = "")
    public WebElement inputIBAN;

    @FindBy(xpath = "")
    public WebElement loginButton;

    public void login(String vorname, String nachname, String email, String kontainhaber, String iban){
        selectAnrede.click();
        inputVorname.sendKeys(vorname);
        inputNachname.sendKeys(nachname);
        inputEMailAdresse.sendKeys(email);
        inputKontoinhaber.sendKeys(kontainhaber);
        inputIBAN.sendKeys(iban);
        loginButton.click();
    }

}
