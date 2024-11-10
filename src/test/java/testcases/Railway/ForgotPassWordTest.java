package testcases.Railway;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Railway.ForgotPassWordPage;
import pageObjects.Railway.HomePage;

public class   ForgotPassWordTest {
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
    public void TC12() {
        System.out.println("TC12 - Errors display when password reset token is blank");
        // Tạo mô đối tượng homepage  kế thừa các thuộc tính của General Page (những thu chung chung nhat)
        // General chi la thu dung de ke thua, ke thua lai cac phan tu ma site nao cung co
        HomePage homePage = new HomePage();
        // Thuc hien phuong thuc opoen de tra ve chinh no, chinh la web mà ta them url vao
        homePage.open();
        ForgotPassWordPage forgotPassWordPage = homePage.gotoLoginPage().goToForgotPassWordPage();
        forgotPassWordPage.forGotPassWord(Constant.PASSWORDTC7);
        String actualFormMsg = "Example message because of no email service";
        String expectedFormMsg = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
        Assert.assertEquals(actualFormMsg, expectedFormMsg, "Form error message is not displayed as expected");
    }
    @Test
    public void TC13() {
        System.out.println("TC13 - Errors display if password and confirm password don't match when resetting password");
        // Tạo mô đối tượng homepage  kế thừa các thuộc tính của General Page (những thu chung chung nhat)
        // General chi la thu dung de ke thua, ke thua lai cac phan tu ma site nao cung co
        HomePage homePage = new HomePage();
        // Thuc hien phuong thuc opoen de tra ve chinh no, chinh la web mà ta them url vao
        homePage.open();
        ForgotPassWordPage forgotPassWordPage = homePage.gotoLoginPage().goToForgotPassWordPage();
        forgotPassWordPage.forGotPassWord(Constant.PASSWORDTC7);
        String actualFormMsg = "Example message because of no email service";
        String expectedFormMsg = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
        Assert.assertEquals(actualFormMsg, expectedFormMsg, "Form error message is not displayed as expected");
    }
}
