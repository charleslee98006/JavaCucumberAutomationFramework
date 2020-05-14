package stepDefinitions;

import org.openqa.selenium.By;

public class GUIActions {

    String[] cssSelectorTagsAndPrefix = {"html", "#", ".", "input", ":", "::", "a", "div", "select"};
    public GUIActions(){
    }

    public By getElement(String element){
        if(("/").equals(element.substring(1)) || ("//").equals(element.substring(0,2)) || (".//").equals(element.substring(0,3))
        || ("(").equals(element.substring(1))){
            return By.xpath(element);
        }
        else if (checkForHTMLTagsCSSSelectors(element)){
            return By.cssSelector(element);
        }
        else{
            return By.id(element);
        }
    }

    public boolean checkForHTMLTagsCSSSelectors(String element){
        for(String tagsPrefix: cssSelectorTagsAndPrefix){
            int prefixCount = tagsPrefix.length();
            if((element.substring(0,prefixCount)).equalsIgnoreCase(tagsPrefix)){
                return true;
            }
        }
        return false;
    }
}
