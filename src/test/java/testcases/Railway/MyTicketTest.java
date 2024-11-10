package testcases.Railway;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;
import pageObjects.Railway.MyTicketPage;

public class MyTicketTest {
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
    public void TC16() throws InterruptedException {
        System.out.println("TC16 - User can cancel a ticket");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAMETC7, Constant.PASSWORDTC7);
        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
        myTicketPage.clickCancelBtn();
        // Kiểm tra xem vé đã được hủy thành công chưa
        boolean isCanceled = myTicketPage.isTicketCanceledDisplayed();

        // In kết quả kiểm thử
        if (isCanceled) {
            System.out.println("TC16 passed: Ticket canceled successfully.");
        } else {
            System.out.println("TC16 failed: Ticket cancelation unsuccessful.");
        }

        // Trả về kết quả kiểm thử
    }
}
