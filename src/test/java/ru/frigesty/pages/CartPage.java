package ru.frigesty.pages;

import ru.frigesty.pages.components.ContentVerifyModal;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    ContentVerifyModal contentVerifyModal = new ContentVerifyModal();

    public CartPage contentVerifyCheckGameOnCart(String game){
        contentVerifyModal.checkGameOnCart(game);
        return this;
    }

    public CartPage delGameOnCart(){
        $(".remove_link").click();
        return this;
    }

    public CartPage contentVerifyCheckDelGameOnCart(){
        contentVerifyModal.checkDelGameOnCart();
        return this;
    }
}
