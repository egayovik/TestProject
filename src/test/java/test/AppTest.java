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
