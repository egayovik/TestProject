package test;


import main.PageObject.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    protected MainPage mainPage=new MainPage();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void intMainPageLoaded() {
        mainPage.goTo("https://dom.ria.com/ru/search/");
        Assert.assertTrue(mainPage.isMainLoaded(), "Check is Main Page Loaded");
    }

    @Test
    public void numberOfTheTilesinPage() {
        mainPage.goTo("https://dom.ria.com/ru/search/");
        int expected=mainPage.getExpectedNumbOfTiles();
        int actual=mainPage.numberOfTheTilesinPage();
        Assert.assertEquals(expected,actual,"20 elements");
    }
}


//package Yevhen;
        import Yevhen.PageObjects.AbstractPage;
        import Yevhen.PageObjects.MainPage;
        import io.qameta.allure.Allure;
        import io.qameta.allure.testng.AllureTestNg;
        import org.aspectj.lang.annotation.Before;
        import org.testng.Assert;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;
        import org.testng.util.Strings;
        import org.xml.sax.Locator;

        import java.io.IOException;
        import java.util.List;
        import java.util.Locale;

        import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
//public class AppTest
//{
/**
 * Rigorous Test :-)
 */

public class AppTest{
    MainPage mainPage;

    @BeforeMethod
    public void before(){
        mainPage = new MainPage("https://dom.ria.com/ru/search/");
    }

    @Test
    public void isMainPageLoaded (){
        Assert.assertTrue(mainPage.isMainPageLoaded(),"Wrong page or main page should be loaded");
    }

    @Test
    public void comparingFilterResults() {
        int expected = mainPage.expectedResultOfTiles();
        int actual = mainPage.numberOfTiles();
        Assert.assertEquals(expected, actual, "comparing actual quantity of tiles and search");
    }

    @Test
    public void comparingChangedValues () throws InterruptedException {
        List<String> titels= mainPage.getTileHeaders();
        for(String title:titels){
            Assert.assertTrue(!title.toLowerCase().contains("винница"), "message");
        }
        for(String title:titels){
            Assert.assertTrue(!title.toLowerCase().contains("вишенка"), "message");
        }
        mainPage.setQuantityTiles(50);
        Thread.sleep(5000);
        int expected = mainPage.expectedResultOfTiles();
        int actual = mainPage.numberOfTiles();
        Assert.assertEquals(expected, actual, "comparing actual quantity of tiles and search");
    }




}