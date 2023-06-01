package ru.frigesty.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    public SearchPage checkResult(String searchGame){
        $("div[id=search_resultsRows]").shouldHave(text(searchGame));
        return this;
    }

}
