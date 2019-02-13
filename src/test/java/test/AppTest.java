package test;


import main.PageObject.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue(){
        MainPage mainPage = new MainPage();
        mainPage.goTo("https://dom.ria.com/ru/search/");


    }
}
