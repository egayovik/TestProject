package main.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static main.Utils.substringInt;
import static main.Utils.scrollDownToElement;
import static main.Utils.scrollToBottom;





public class MainPage extends AbstractPage{

    List<WebElement> TileBoxes;
    WebElement dropdownQuantity;
    WebElement title;

    public MainPage goTo (String url){
        driver.get(url);
        TileBoxes = driver.findElements(By.xpath("//*[contains(@id,'search-realt')]"));
        dropdownQuantity = driver.findElement(By.cssSelector(".el-selected.open"));
        title=driver.findElement(By.cssSelector("#searchTitleCategory"));
        //additionalDataClick = driver.findElement();
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
    }

}
