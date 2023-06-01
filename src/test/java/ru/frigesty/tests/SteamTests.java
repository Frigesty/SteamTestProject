package ru.frigesty.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.frigesty.pages.SearchPage;
import ru.frigesty.pages.MainPage;

import static io.qameta.allure.Allure.step;
import static ru.frigesty.tests.TestData.*;
import static ru.frigesty.utils.RandomUtils.*;

@DisplayName("Тесты на сайт https://store.steampowered.com/.")
public class SteamTests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    private final static String BASE_URL = "https://store.steampowered.com/";
    private final static String GAME = getRandomItemFromArray(game);

    @CsvSource({
        "МАГАЗИН, Популярное и рекомендуемое",
        "СООБЩЕСТВО, Активность сообщества",
        "О STEAM, Steam — превосходная платформа для игроков и разработчиков.",
        "ПОДДЕРЖКА, Поддержка Steam"
    })
    @DisplayName("Проверяем работоспособность кнопок в Header.")
    @ParameterizedTest(name = "При нажатии на кнопку {0} в header мы поподаем на страницу на которой есть надпись {1}.")
    public void headerButtonsTest(String buttons, String desiredText){
        step("Открываем страницу", () -> {
            mainPage.openPage(BASE_URL);
        });
        step("Кликаем по кнопке", () -> {
            mainPage.clickOnButton(buttons);
        });
        step("Проверяем что на странице есть надпись", () -> {
            mainPage.checkTextOnPage(desiredText);
        });
    }

    @Test
    @DisplayName("Проверяем что поиск находит искомую игру.")
    public void testSearch(){
        step("Открываем страницу", () -> {
            mainPage.openPage(BASE_URL);
        });
        step("Вводим тескт и нажимем ENTER", () -> {
            mainPage.search(GAME);
        });
        step("Проверяем результат", () -> {
            searchPage.checkResult(GAME);
        });
    }
}
