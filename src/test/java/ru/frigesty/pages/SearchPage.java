package ru.frigesty.pages;

import ru.frigesty.pages.components.ContentVerifyModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    ContentVerifyModal contentVerifyModal = new ContentVerifyModal();

    public SearchPage contentVerifyCheckResult(String searchGame){
        contentVerifyModal.checkResult(searchGame);
        return this;
    }

    public SearchPage clickOnResult(String searchGame){
        $$("#search_resultsRows a").findBy(text(searchGame)).click();
        return this;
    }

    public SearchPage clickOnButtonInCart(){
        $("div .btn_addtocart").click();
        return this;
    }

    public SearchPage contentVerifyCheckResultGamers(String GAMERS){
        contentVerifyModal.checkResultGamers(GAMERS);
        return this;
    }
}
