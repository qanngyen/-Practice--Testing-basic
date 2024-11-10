package pageObjects.Railway;

import common.Constant;
import org.openqa.selenium.*;

import static java.lang.Thread.sleep;

public class MyTicketPage  {
    private final By cancelBtn = By.xpath("/html/body/div[1]/div[2]/form/div/div/table/tbody/tr[2]/td[11]/input");
    protected WebElement getCancelBtn() {
        return Constant.WEBDRIVER.findElement(cancelBtn);
    }
    public void clickCancelBtn() throws InterruptedException {
        WebElement bookButton = getCancelBtn();
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", bookButton);
        sleep(5000);
        getCancelBtn().click();
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();
    }
    public boolean isTicketCanceledDisplayed() {
        try {
            WebElement canceledMessageElement = Constant.WEBDRIVER.findElement(cancelBtn);
            return canceledMessageElement.isDisplayed();  // Trả về true nếu phần tử hiển thị
        } catch (NoSuchElementException e) {
            return false;  // Trả về false nếu phần tử không tồn tại
        }
    }
}
