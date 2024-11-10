package testcases.Railway;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Railway.BookTicketPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

public class BookTicketTest {
    @BeforeMethod
    // Đánh dấu phương thức này sẽ chạy trước mỗi phương thức test trong class này.
    public void beforeMethod() {
        // In ra "Pre-condition" để thông báo đang thiết lập điều kiện trước khi chạy test.
        System.out.println("Pre-condition");

        // Thiết lập vị trí của ChromeDriver (driver điều khiển trình duyệt Chrome),
        // dùng phương thức `getProjectPath()` để lấy đường dẫn của thư mục chứa project,
        // rồi ghép với đường dẫn của file chromedriver.exe.
        System.setProperty("Webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");


        // Khởi tạo đối tượng ChromeDriver và gán vào biến WEBDRIVER trong lớp Constant.
        Constant.WEBDRIVER = new ChromeDriver();
        // Mở trình duyệt ở chế độ toàn màn hình.
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC14() {
        System.out.println("TC14 - User can book 1 ticket at a time");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAMETC7, Constant.PASSWORDTC7);
        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        bookTicketPage.BookTicket("5","3", "3", "1");
        Assert.assertEquals(bookTicketPage.getBookMsg(), "Ticket booked successfully!", "Message \"Ticket booked successfully!\" displays.");
    }
}
