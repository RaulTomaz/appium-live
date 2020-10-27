package stepsDefinition;

import DriverFactory.DriverFactory;
import io.appium.java_client.MobileBy;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class LoginSteps extends DriverFactory {

    @Before
    public void instantiateDriver(){
        initDriver();
    }

    @Dado("que eu clico em registrar novo usuario")
    public void que_eu_clico_em_registrar_novo_usuario() {
        getDriver().findElement(MobileBy.id("textViewLinkRegister")).click();
    }

    @Quando("eu registro um usuario")
    public void eu_registro_um_usuario() throws InterruptedException{
        Thread.sleep(1000);
        getDriver().findElement(MobileBy.id("textInputEditTextName")).sendKeys("Raul Tomaz");
        getDriver().findElement(MobileBy.id("textInputEditTextEmail")).sendKeys("raul@teste.com");
        getDriver().findElement(MobileBy.id("textInputEditTextPassword")).sendKeys("123456");
        getDriver().findElement(MobileBy.id("textInputEditTextConfirmPassword")).sendKeys("123456");
        getDriver().findElement(MobileBy.id("appCompatButtonRegister")).click();

    }

    @Quando("realizo o login com este novo usuario")
    public void realizo_o_login_com_este_novo_usuario() throws InterruptedException{
        Thread.sleep(1000);
        getDriver().navigate().back();
        getDriver().findElement(MobileBy.id("textInputEditTextEmail")).sendKeys("raul@teste.com");
        getDriver().findElement(MobileBy.id("textInputEditTextPassword")).sendKeys("123456");
        getDriver().findElement(MobileBy.id("appCompatButtonLogin")).click();
    }

    @Entao("sou redirecionado a tela principal do aplicativo")
    public void sou_redirecionado_a_tela_principal_do_aplicativo() throws InterruptedException{
        Thread.sleep(1000);
       Assert.assertEquals("Android NewLine Learning", getDriver().findElement(MobileBy.xpath("//" +
               "android.support.v7.widget.LinearLayoutCompat/android.widget.TextView")).getText());
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

}
