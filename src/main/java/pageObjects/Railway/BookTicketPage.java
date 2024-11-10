package pageObjects.Railway;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage {
    private final By selectDepart = By.name("DepartStation");
    private final By selectArrive = By.name("ArriveStation");
    private final By selectSeatType = By.name("SeatType");
    private final By selectAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By bookSuccess = By.xpath("/html/body/div/div[2]/h1");

    protected WebElement getSelectDepart() {
        return Constant.WEBDRIVER.findElement(selectDepart);
    }
    protected WebElement getSelectArrive() {
        return Constant.WEBDRIVER.findElement(selectArrive);
    }
    protected WebElement getSelectSeatType() {
        return Constant.WEBDRIVER.findElement(selectSeatType);
    }
    protected WebElement getBookSuccess() {
        return Constant.WEBDRIVER.findElement(bookSuccess);
    }
    protected  WebElement getTicketAmount() {
        return Constant.WEBDRIVER.findElement(selectAmount);
    }
    protected  WebElement getBookTicketBtn() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }
    public String getDepartSelected () {
        Select departSelected = new Select(this.getSelectDepart());
        return departSelected.getFirstSelectedOption().getText();
    }
    public String getArriveSelected () {
        Select arriveSelected = new Select(this.getSelectArrive());
        return arriveSelected.getFirstSelectedOption().getText();

    }
    public void BookTicket(String depart, String arrive, String seatType, String amount) {
        Select selectDepart = new Select(this.getSelectDepart());
        selectDepart.selectByValue(depart);
        Select selectArrive = new Select(this.getSelectArrive());
        selectArrive.selectByValue(arrive);
        Select selectSeatType = new Select(this.getSelectSeatType());
        selectSeatType.selectByValue(seatType);
        Select selectTicketAmount = new Select(this.getTicketAmount());
        selectTicketAmount.selectByValue(amount);
        this.getBookTicketBtn().click();
    }
    public String getBookMsg() {
        return getBookSuccess().getText();
    }

}
