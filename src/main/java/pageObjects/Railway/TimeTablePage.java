package pageObjects.Railway;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class TimeTablePage {
    private final By BookTicketBtn = By.xpath("/html/body/div[1]/div[2]/div/div/table/tbody/tr[17]/td[7]/a");
    protected WebElement getBookTicketBtn() {
        return Constant.WEBDRIVER.findElement(BookTicketBtn);
    }
    public BookTicketPage ChoseTicket() throws InterruptedException {
        WebElement bookButton = getBookTicketBtn();
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", bookButton);
        sleep(5000);
        getBookTicketBtn().click();
        return new BookTicketPage();
    }
}
