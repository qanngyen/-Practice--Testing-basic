package pageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import common.Constant;

// Thực hiện lấy các phần tử cần có ở trang chung, cung cấp hoạt ộng kiểm thử

public class GeneralPage {
    // Locators
    // Chuẩn bị Xpath để tìm kiếm
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabBookTicket = By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[6]/a");
    private final By tabMyTicket = By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[7]/a");
    private final By tabChangePassword = By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[8]/a");
    private final By tabRegister = By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[7]/a");
    private final By registerSuccess = By.xpath("/html/body/div[1]/div[2]/p");
    private final By tabTimeTable = By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[4]/a");

    // Elements
    // Các phương thức dưa trên trình duyệt để tìm element thông qua Xpath
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWWelcomeMessage);
    }
    protected WebElement getRegisterSuccess() {
        return Constant.WEBDRIVER.findElement(registerSuccess);
    }
    protected  WebElement getBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }
    protected  WebElement getMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }
    protected  WebElement getChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }
    protected WebElement getRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }
    protected WebElement getTabTimeTable() {
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }
    // Methods
    // sau khi lấy dudocj wphaanf tử thì trả  về text đó
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }
    public String getRegisterSuccessMessage() {
        return this.getRegisterSuccess().getText();
    }
    // Phương thức mở login page, sau khi laays ược element thfi thực hiện click, lúc này nó trả về 1 instance của login page mới
    public LoginPage gotoLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }
    public BookTicketPage gotoBookTicketPage() {
        this.getBookTicket().click();
        return new BookTicketPage();
    }
    public MyTicketPage gotoMyTicketPage() {
        this.getMyTicket().click();
        return new MyTicketPage();
    }
    public ChangePassWordPage gotoChangePasswordPage() {
        this.getChangePassword().click();
        return new ChangePassWordPage();
    }
    public RegisterPage gotoRegisterPage() {
        this.getRegister().click();
        return new RegisterPage();
    }
    public TimeTablePage gotoTimeTable() {
        this.getTabTimeTable().click();
        return new TimeTablePage();
    }
}
