package pageObjects.Railway;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v121.network.model.SubresourceWebBundleMetadataError;

public class ChangePassWordPage extends GeneralPage {
    // located

    private final By currentPassWord = By.xpath("/html/body/div[1]/div[2]/form/fieldset/ol/li[1]/input");
    private final By newPassWord = By.xpath("/html/body/div[1]/div[2]/form/fieldset/ol/li[2]/input");
    private final By confirmPassWord = By.xpath("/html/body/div[1]/div[2]/form/fieldset/ol/li[3]/input");
    private final By changePassWordBtn = By.xpath("/html/body/div[1]/div[2]/form/fieldset/p/input");
    private final By updateMsg = By.xpath("/html/body/div[1]/div[2]/form/fieldset/p[1]");
    // elements
    protected WebElement getCurrentPassWord() {
        return Constant.WEBDRIVER.findElement(currentPassWord);
    }
    protected WebElement getNewPassWord() {
        return Constant.WEBDRIVER.findElement(newPassWord);
    }
    protected WebElement getConfirmPassWord() {
        return Constant.WEBDRIVER.findElement(confirmPassWord);
    }
    protected WebElement getChangePasswordBtn() {
        return Constant.WEBDRIVER.findElement(changePassWordBtn);
    }
    protected WebElement getUpdateMsg() {
        return Constant.WEBDRIVER.findElement(updateMsg);
    }

    public String getUpdateMessage() {
        return this.getUpdateMsg().getText();
    }
    public void changePassWord(String oldPass, String newPass) {
        this.getCurrentPassWord().sendKeys(oldPass);
        this.getNewPassWord().sendKeys(newPass);
        this.getConfirmPassWord().sendKeys(newPass);
        this.getChangePasswordBtn().click();
    }


}
