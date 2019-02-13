package main.PageObject;

import org.openqa.selenium.By;

public class MainPage extends AbstractPage{
    public MainPage goTo (String url){
        driver.get(url);
    return this;
    }
    public boolean isMainLoaded(){
        String text =  driver.findElement(By.id ("searchTitleCategory")).getText();
        return text.equalsIgnoreCase("Поиск недвижимости");


    };

}
