package testcases.Railway;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Railway.*;

public class TimeTableTest {
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
    public void TC15() throws InterruptedException {
        System.out.println("TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAMETC7, Constant.PASSWORDTC7);
        TimeTablePage timeTablePage = homePage.gotoTimeTable();
        BookTicketPage bookTicketPage = timeTablePage.ChoseTicket();
        String departActual = bookTicketPage.getDepartSelected();
        String arriveActual = bookTicketPage.getArriveSelected();
        Assert.assertEquals(departActual, "Huế", "There was a problem with depart location");
        Assert.assertEquals(arriveActual, "Sài Gòn", "There was a problem with arrive location");

    }
    @Test
    public void TC16() throws InterruptedException {
        System.out.println("TC16 - User can cancel a ticket");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAMETC7, Constant.PASSWORDTC7);
        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();

    }
}
