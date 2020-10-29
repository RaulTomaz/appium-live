package stepsDefinition;

import DriverFactory.DriverFactory;
import io.appium.java_client.MobileBy;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps extends DriverFactory {
    WebDriverWait wait;

    @Before
    public void instantiateDriver(){
        initDriver();
        wait = new WebDriverWait(pegaDriver(), 10);
    }

    @Dado("que eu clico em registrar novo usuario")
    public void que_eu_clico_em_registrar_novo_usuario() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("textViewLinkRegister"))).click();
//        pegaDriver().findElement(MobileBy.id("textViewLinkRegister")).click();
    }

    @Quando("eu registro um usuario")
    public void eu_registro_um_usuario() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("textInputEditTextName"))).sendKeys("Raul Tomaz");
//        pegaDriver().findElement(MobileBy.id("textInputEditTextName")).sendKeys("Raul Tomaz");
        pegaDriver().findElement(MobileBy.id("textInputEditTextEmail")).sendKeys("raul@teste.com");
        pegaDriver().findElement(MobileBy.id("textInputEditTextPassword")).sendKeys("123456");
        pegaDriver().findElement(MobileBy.id("textInputEditTextConfirmPassword")).sendKeys("123456");
        pegaDriver().findElement(MobileBy.id("appCompatButtonRegister")).click();
        pegaDriver().navigate().back();
    }

    @Quando("realizo o login com este novo usuario")
    public void realizo_o_login_com_este_novo_usuario() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("textInputEditTextEmail"))).sendKeys("raul@teste.com");
//        pegaDriver().findElement(MobileBy.id("textInputEditTextEmail")).sendKeys("raul@teste.com");
        pegaDriver().findElement(MobileBy.id("textInputEditTextPassword")).sendKeys("123456");
        pegaDriver().findElement(MobileBy.id("appCompatButtonLogin")).click();
    }

    @Entao("sou redirecionado a tela principal do aplicativo")
    public void sou_redirecionado_a_tela_principal_do_aplicativo() {
        Assert.assertEquals("Android NewLine Learning",
                wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("" +
                        "//android.support.v7.widget.LinearLayoutCompat/android.widget.TextView"))).getText());
//       Assert.assertEquals("Android NewLine Learning", pegaDriver().findElement(MobileBy.xpath("//" +
//               "android.support.v7.widget.LinearLayoutCompat/android.widget.TextView")).getText());
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

}
