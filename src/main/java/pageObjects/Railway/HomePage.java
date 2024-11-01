package pageObjects.Railway;
import common.Constant;
// Vì general là trang chung, nên các trang khác sẽ kế thừa
public class HomePage extends GeneralPage{
    public HomePage open()
    {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
}
