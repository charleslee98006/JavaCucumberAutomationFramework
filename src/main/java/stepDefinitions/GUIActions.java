package stepDefinitions;

import org.openqa.selenium.By;

/**
 * This class is a helper class that for repeating gui actions.
 */
public class GUIActions {

    String[] cssSelectorTagsAndPrefix = {"html", "#", ".", "input", ":", "::", "a", "div", "select"};
    public GUIActions(){
    }

    /**
     * This method sorts out id, cssSelector or xpath to use based on string syntax.
     * @return By
     */
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
    /**
     * This method checks the string to see if it is using any CSS Selector.
     * @return boolean - whether or not the element is a CSS Selector.
     */
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
