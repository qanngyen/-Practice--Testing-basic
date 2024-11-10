package testcases.Railway;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Railway.ChangePassWordPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

import static java.lang.Thread.sleep;

public class ChangePassWordTest {
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
    public void TC9() {
        System.out.println("TC9 - User can change password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAMETC7, Constant.PASSWORDTC7);

        ChangePassWordPage changePassWordPage = homePage.gotoChangePasswordPage();
        changePassWordPage.changePassWord(Constant.PASSWORDTC7, Constant.NEWPASSWORDTC97);

        String actualMsg = changePassWordPage.getUpdateMessage();
        String expectedMsg = "Your password has been updated";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not display as expected");
    }
}
