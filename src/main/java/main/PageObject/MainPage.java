package main.PageObject;

import com.sun.org.apache.bcel.internal.generic.Select;
import io.qameta.allure.Allure;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static main.Utils.substringInt;

public class MainPage extends AbstractPage{
    public MainPage goTo (String url){
        driver.get(url);
    return this;
    }
    public boolean isMainLoaded(){
        String text =  driver.findElement(By.id ("searchTitleCategory")).getText();
        return text.equalsIgnoreCase("Поиск недвижимости");

    }

    public int getExpectedNumbOfTiles(){
        String stringOfNumber = driver.findElement(By.cssSelector(".el-selected.open")).getText();
        return substringInt(stringOfNumber);
    }

    public int numberOfTheTilesinPage(){
        List<WebElement> tiles = driver.findElements(By.className("wrap_desc"));
        return tiles.size();
    }

    public MainPage dropDown (int nambers) {
        //Select dropdown = new Select(driver.findElement(By.className("el-selected open")));
        //dropdown.selectByValue())
        return this;
    }
}
