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


//package Yevhen.PageObjects;

        import Yevhen.Utils;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.interactions.Locatable;
        import org.openqa.selenium.support.ui.Select;

        import java.util.ArrayList;
        import java.util.List;

        import static Yevhen.Utils.scrollDownToElement;
        import static Yevhen.Utils.scrollToBottom;

public class MainPage extends AbstractPage {

    List<WebElement> TileBoxes;
    WebElement dropdownQuantity;
    WebElement title;

    public  MainPage(String URL) {
        driver.get(URL);
        TileBoxes = driver.findElements(By.xpath("//*[contains(@id,'search-realt')]"));
        dropdownQuantity = driver.findElement(By.cssSelector(".el-selected.open"));
        title=driver.findElement(By.cssSelector("#searchTitleCategory"));
        //additionalDataClick = driver.findElement();
    }

    public boolean isMainPageLoaded (){
        return title.getText().equals("Поиск недвижимости");
    }

    public MainPage setQuantityTiles (int numbers) {
        scrollToBottom();
        dropdownQuantity.click();
        WebElement listItem = driver.findElement(By.cssSelector("[data-value='" + numbers+ "']"));
        listItem.click();
        return this;
    }
    public int expectedResultOfTiles() {

        String stringValues = dropdownQuantity.getText();
        return Utils.substringInt(stringValues);
    }

    public int numberOfTiles() {

        List<WebElement> arrayTiles = driver.findElements(By.className("wrap_desc"));
        return arrayTiles.size();
    }

    public List<WebElement> getTiles() {
        return driver.findElements(By.className("wrap_desc"));
    }

    public List<String> getTileHeaders() {
        List<String> forReturn = new ArrayList<>();

        for(WebElement tile:getTiles()){
            forReturn.add(tile.findElement(By.className("blue")).getText());
        }
        return forReturn;
    }/*
    public MainPage setAdditioanlDataSelection (){
        WebElement.
    }
*/

}
