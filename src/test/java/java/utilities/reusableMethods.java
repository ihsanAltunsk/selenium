package java.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class reusableMethods {
    public static List<String> convertToStringList (List<WebElement> listOfElements) {

        List<String> listOfStrings = new ArrayList<>();
        for (WebElement each :listOfElements) {
            listOfStrings.add(each.getText());
        }
        return listOfStrings;
    }
}
