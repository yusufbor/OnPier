package com.onPier.pages;

import com.onPier.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    public LandingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//label[@class='h-auto md:w-full'])[1]")
    public WebElement klasseM1;

    @FindBy(xpath = "(//label[@class='h-auto md:w-full'])[2]")
    public WebElement fahrzeugshein;

    @FindBy(xpath = "(//label[@class='h-auto md:w-full'])[3]")
    public WebElement klasseN1;

    @FindBy(xpath = "(//span[.=' Prämie beantragen '])[1]")
    public WebElement flexPramieBentragen;

    @FindBy(xpath = "(//span[.=' Prämie beantragen '])[2]")
    public WebElement sofortPramieBentragen;
}
