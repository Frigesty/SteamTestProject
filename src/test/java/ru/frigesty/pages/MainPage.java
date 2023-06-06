package ru.frigesty.pages;

import ru.frigesty.pages.components.ContentVerifyModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

private final static String BASE_URL = "https://store.steampowered.com/";

    ContentVerifyModal contentVerifyModal = new ContentVerifyModal();

    public MainPage openMainPage(){
        open(BASE_URL);
        return this;
    }

    public MainPage clickOnButton(String buttons){
        $$("div .supernav_container a").findBy(text(buttons)).click();
        return this;
    }

    public MainPage clickOnButtonCommunity(){
        $$("div .supernav_container a").findBy(text("СООБЩЕСТВО")).click();
        return this;
    }

    public MainPage clickOnButtonSupport(){
        $$("div .supernav_container a").findBy(text("ПОДДЕРЖКА")).click();
        return this;
    }
    public MainPage clickOnButtonGamesAndPrograms(){
        $$("#help_home_block .help_wizard_button").findBy(text("Игры, программы и т. д.")).click();
        return this;
    }

    public MainPage contentVerifySearchFieldVisible(){
        contentVerifyModal.checkSearchFieldVisible();
        return this;
    }

    public MainPage contentVerifyCheckTextOnPage(String desiredText){
        contentVerifyModal.checkTextOnPage(desiredText);
        return this;
    }

    public MainPage search(String searchGame){
        $("input[id=store_nav_search_term]").setValue(searchGame).pressEnter();
        return this;
    }

    public MainPage searchCommunity(String searchGamers){
        $("input[id=SearchPlayers]").setValue(searchGamers).pressEnter();
        return this;
    }

    public MainPage clickOnButtonLanguage(){
        $("#language_pulldown").click();
        return this;
    }
    
    public MainPage chooseLanguage(String language){
        $$(".popup_body.popup_menu .popup_menu_item.tight").findBy(text(language)).click();
        return this;
    }

    public MainPage contentVerifyCheckTextAfterSwitchingLanguage(String installButton){
        contentVerifyModal.checkTextAfterSwitchingLanguage(installButton);
        return this;
    }
}



