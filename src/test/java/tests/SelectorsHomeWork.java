package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SelectorsHomeWork {

    @Test
    public void SelectorsCSS() throws InterruptedException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Implicit Waits - конфигурируют экземпляр WebDriver делать
        // многократные попытки найти элемент (элементы) на странице в течении
        // заданного периода времени, если элемент не найден сразу. Tолько по истечении
        // этого времени WebDriver бросит ElementNotFoundException.

        //----------------------------------------------------------------------------------------
        //поиск по id
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        //поиск по name
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        //поиск по classname
        WebElement loginButton = driver.findElement(By.className("submit-button"));
        loginButton.click();

        //по TagName
        WebElement byTagName = driver.findElement(By.tagName("footer"));

        //нажимаем на кнопку, чтобы открылся список (меню)
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();

        //по LinkText
        WebElement byLinkText = driver.findElement(By.linkText("ALL ITEMS"));
        byLinkText.click();

        //по partialLinkText
        WebElement bypartialLinkText = driver.findElement(By.partialLinkText("LOG"));
        bypartialLinkText.click();

        WebElement userName2 = driver.findElement(By.id("user-name"));
        userName2.sendKeys("problem_user");
        WebElement password2 = driver.findElement(By.name("password"));
        password2.sendKeys("secret_sauce");
        WebElement loginButton2 = driver.findElement(By.className("submit-button"));
        loginButton2.click();

        //-------------------------------------CSS-------------------------------------------------

        //по .class
        WebElement byClass = driver.findElement(By.cssSelector(".shopping_cart_link"));
        byClass.click();

        //по .class1.class2
        WebElement byClasses = driver.findElement(By.cssSelector(".btn.btn_secondary"));
        byClasses.click();

        //по id, классу
        WebElement byIdClass = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack.btn"));
        byIdClass.click();

        //по tagname.class + атрибут
        WebElement byTagClassAttribute = driver.findElement(By.cssSelector("img.inventory_item_img[alt ='Sauce Labs Bolt T-Shirt']"));
        byTagClassAttribute.click();

        //по .class1. class2
        WebElement byClassesDesc = driver.findElement(By.cssSelector(".inventory_details_desc_container .btn"));
        byClassesDesc.click();

        //#id
        WebElement byID = driver.findElement(By.cssSelector("#back-to-products"));
        byID.click();

        //по tagname
        WebElement byTagNameCss = driver.findElement(By.cssSelector("footer"));

        //по tagname.class см.выше

        //[attribute=value]
        WebElement byAttributeWithValue = driver.findElement(By.cssSelector("[data-test='product_sort_container']"));
        byAttributeWithValue.click();

        //[attribute~=value]
        WebElement byAttributeWithValueWord = driver.findElement(By.cssSelector("[value='az']"));
        byAttributeWithValueWord.click();

        //[attribute|=value]Selects all elements with a lang attribute value starting with "en"
        WebElement byAttributeWithValueStartWord = driver.findElement(By.cssSelector("[data-test |= 'add-to-cart-sauce-labs-bike']"));
        byAttributeWithValueWord.click();

        //a[href^="https"] [attribute^=value]Selects every <a> element whose href attribute value begins with "https"
        WebElement byStartPartWord = driver.findElement(By.cssSelector("button[id^='rea']"));
        byStartPartWord.click();

        //[attribute$=value]Selects every <a> element whose href attribute value ends with ".pdf"
        WebElement byEndPartWord = driver.findElement(By.cssSelector("a[id$='ry_sidebar_link']"));
        byEndPartWord.click();

        //[attribute*=value]Selects every <a> element whose href attribute value contains the substring "w3schools"
        WebElement bySubstringWord = driver.findElement(By.cssSelector("button[id*='burger-cr']"));
        bySubstringWord.click();

        driver.quit();
    }

    //-------------------------------------XPath-------------------------------------------------

    @Test
    public void XPathSelectors() throws InterruptedException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Поиск по атрибуту, например By.xpath("//tag[@attribute='value']");
        WebElement ByAttribute = driver.findElement(By.xpath("//input[@data-test='username']"));
        ByAttribute.sendKeys("performance_glitch_user");

        //Поиск по частичному совпадению атрибута, например By.xpath("//tag[contains(@attribute,'text')]");
        WebElement ByPartAttribute = driver.findElement(By.xpath("//input[contains(@data-test, 'pas')] "));
        ByPartAttribute.sendKeys("secret_sauce");

        //descendant
        WebElement getChildByN = driver.findElement(By.xpath("//div[contains(@class, 'box')]//descendant::input[3]"));
        getChildByN.click();

        //Поиск по тексту, например By.xpath("//tag[text()='text']");
        WebElement byText = driver.findElement(By.xpath("//*[text() = 'Sauce Labs Backpack']"));
        byText.click();

        //Поиск по частичному совпадению текста, например By.xpath("//tag[contains(text(),'text')]");
        WebElement byPartText = driver.findElement(By.xpath("//button[contains(text(), 'Ad')]"));
        byPartText.click();

        //ancestor, например //*[text()='Enterprise Testing']//ancestor::div
        WebElement getParentByN = driver.findElement(By.xpath("//button[contains(@class,'back_button')]//ancestor::div[1]"));//первый родитель кнопки back-to-products

        //preceding
        WebElement getALlElementsBeforeCurrent = driver.findElement(By.xpath("//*[text() = 'Back to products']/preceding::button[contains(@id, 'menu')]"));
        getALlElementsBeforeCurrent.click();

        //following
        WebElement getALlElementsAfterCurrent = driver.findElement(By.xpath("//*[@class = 'header_label']//following::a[@class = 'shopping_cart_link']"));
        getALlElementsAfterCurrent.click();

        //parent
        WebElement getParentBy = driver.findElement(By.xpath("//*[@class = 'primary_header']//parent::div[@class = 'header_container']"));

        //*поиск элемента с условием AND, например //input[@class='_2zrpKA _1dBPDZ' and @type='text']
        WebElement byAND = driver.findElement(By.xpath("//button[@data-test='checkout' and @name='checkout']"));
        byAND.click();

        driver.quit();
    }

}
