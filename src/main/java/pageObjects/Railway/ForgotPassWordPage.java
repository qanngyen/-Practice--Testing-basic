package pageObjects.Railway;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPassWordPage {
    private final By _inputEmail = By.xpath("/html/body/div[1]/div[2]/form/fieldset/ol/li/input");
    private final By _sendBtn = By.xpath("/html/body/div[1]/div[2]/form/fieldset/p[2]/input");

    protected WebElement getInputEmail() {
        return Constant.WEBDRIVER.findElement(_inputEmail);
    }
    protected WebElement getSendBtn() {
        return Constant.WEBDRIVER.findElement(_sendBtn);
    }
    public void forGotPassWord(String email) {
        this.getInputEmail().sendKeys(email);
        this.getSendBtn().click();
    }
}
