package ru.frigesty.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
//    private final SelenideElement textBoxInput = $x("//input[@class='form-field-control js-search-field']");
//    private final SelenideElement textBoxButton = $x("//button[@data-toggler-scroll='true']");

    public MainPage openPage(String url){
        open(url);
        return this;
    }

    public MainPage clickOnButton(String buttons){
        $$("div .supernav_container a").findBy(text(buttons)).click();
        return this;
    }

    public MainPage checkTextOnPage(String desiredText){
        $(".responsive_page").shouldHave(text(desiredText));
        return this;
    }

    public MainPage search(String searchGame){
        $("input[id=store_nav_search_term]").setValue(searchGame).pressEnter();
        return this;
    }
}



