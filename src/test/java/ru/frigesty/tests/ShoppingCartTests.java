package ru.frigesty.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.frigesty.pages.CartPage;
import ru.frigesty.pages.MainPage;
import ru.frigesty.pages.SearchPage;

import static io.qameta.allure.Allure.step;
import static ru.frigesty.tests.TestData.game;
import static ru.frigesty.utils.RandomUtils.getRandomItemFromArray;

@Owner("Frigesty")
@Tag("SMOKE")
@DisplayName("Тесты на корзину покупок сайта.")
public class ShoppingCartTests extends TestBase {

    private final static String GAME = getRandomItemFromArray(game);

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    CartPage cartPage = new CartPage();

    @Test
    @DisplayName("Добавляем игру в корзину.")
    public void addGameInShoppingCart(){
        step("Открываем страницу.", () -> {
            mainPage.openMainPage();
        });
        step("Вводим тескт в строку поиска и нажимем ENTER.", () -> {
            mainPage.search(GAME);
        });
        step("Кликаем по результату.", () -> {
            searchPage.clickOnResult(GAME);
        });
        step("Кликаем по кнопке В корзину.", () -> {
            searchPage.clickOnButtonInCart();
        });
        step("Проверяем что игра добавилась в корзину.", () -> {
            cartPage.contentVerifyCheckGameOnCart(GAME);
        });
    }

    @Test
    @DisplayName("Удаляем игру из корзины.")
    public void delGameFromShoppingCart(){
        step("Открываем страницу.", () -> {
            mainPage.openMainPage();
        });
        step("Вводим тескт в строку поиска и нажимем ENTER.", () -> {
            mainPage.search(GAME);
        });
        step("Кликаем по результату.", () -> {
            searchPage.clickOnResult(GAME);
        });
        step("Кликаем по кнопке В корзину.", () -> {
            searchPage.clickOnButtonInCart();
        });
        step("Удаляем игру из корзины.", () -> {
            cartPage.delGameOnCart();
        });
        step("Проверяем что игра удалилась из корзины.", () -> {
            cartPage.contentVerifyCheckDelGameOnCart();
        });
    }
}
