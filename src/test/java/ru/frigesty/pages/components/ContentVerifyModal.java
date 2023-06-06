package ru.frigesty.pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ContentVerifyModal {

    public void checkGameOnCart(String game){
        $(".pageheader").shouldHave(text("ВАША КОРЗИНА"));
        $(".cart_status_message").shouldHave(text("Ваш товар был добавлен!"));
        $(".cart_row").shouldHave(text(game));
    }

    public void checkDelGameOnCart(){
        $(".cart_status_message").shouldHave(text("Ваш товар был удалён!"));
        $(".cart_totals_area").shouldHave(text("0 pуб."));
    }

    public void checkTextOnPage(String desiredText){
        $(".responsive_page").shouldHave(text(desiredText));
    }

    public void checkResult(String searchGame){
        $("div[id=search_result_container]").shouldHave(text(searchGame));
    }

    public void checkResultGamers(String GAMERS){
        $("#search_results").shouldHave(text(GAMERS));
    }

    public void checkSearchFieldVisible(){
        $("#help_search_support_input").shouldBe(Condition.visible);
    }

    public void checkTextAfterSwitchingLanguage(String installButton){
        $(".header_installsteam_btn_content").shouldHave(text(installButton));
    }
}
