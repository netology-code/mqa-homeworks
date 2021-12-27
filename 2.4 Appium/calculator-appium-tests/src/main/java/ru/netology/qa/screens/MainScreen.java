package ru.netology.qa.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class MainScreen {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'digit')]")
    private List<MobileElement> digitButtons;

    @AndroidFindBy(id = "digit_2")
    @iOSXCUITFindBy(accessibility = "2")
    public MobileElement digitTwoButton;

    @AndroidFindBy(accessibility = "plus")
    @iOSXCUITFindBy(accessibility = "+")
    public MobileElement plusSignButton;

    @AndroidFindBy(accessibility = "equals")
    @iOSXCUITFindBy(accessibility = "=")
    public MobileElement equalsSignButton;

    @AndroidFindBy(id = "result_final")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"C\"]/preceding::XCUIElementTypeStaticText)[last()]")
    public MobileElement resultField;

    private AppiumDriver driver;

    public MainScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
}


