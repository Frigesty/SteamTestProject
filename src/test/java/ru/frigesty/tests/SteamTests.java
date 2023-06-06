package ru.frigesty.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.frigesty.pages.SearchPage;
import ru.frigesty.pages.MainPage;

import static io.qameta.allure.Allure.step;
import static ru.frigesty.tests.TestData.*;
import static ru.frigesty.utils.RandomUtils.*;

@Owner("Frigesty")
@Tag("SMOKE")
@DisplayName("Тесты на главную страницу сайта.")
public class SteamTests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    Faker faker = new Faker();
    private final String GAME = getRandomItemFromArray(game);
    private final String GAMERS = faker.name().firstName();

    @CsvSource({
        "МАГАЗИН, Популярное и рекомендуемое",
        "СООБЩЕСТВО, Активность сообщества",
        "О STEAM, Steam — превосходная платформа для игроков и разработчиков.",
        "ПОДДЕРЖКА, Поддержка Steam"
    })
    @DisplayName("Проверяем работоспособность кнопок в Header.")
    @ParameterizedTest(name = "При нажатии на кнопку {0} в header мы поподаем на страницу на которой есть надпись {1}.")
    public void headerButtonsTest(String buttons, String desiredText){
        step("Открываем страницу.", () -> {
            mainPage.openMainPage();
        });
        step("Кликаем по кнопке.", () -> {
            mainPage.clickOnButton(buttons);
        });
        step("Проверяем что на странице есть надпись.", () -> {
            mainPage.contentVerifyCheckTextOnPage(desiredText);
        });
    }

    @Test
    @DisplayName("Проверяем что поиск находит искомую игру.")
    public void testSearch(){
        step("Открываем страницу.", () -> {
            mainPage.openMainPage();
        });
        step("Вводим тескт в строку поиска и нажимем ENTER.", () -> {
            mainPage.search(GAME);
        });
        step("Проверяем результат.", () -> {
            searchPage.contentVerifyCheckResult(GAME);
        });
    }

    @Test
    @DisplayName("Проверяем результаты поиска по игрокам.")
    public void searchGamersTest(){
        step("Открываем страницу.", () -> {
            mainPage.openMainPage();
        });

        step("Кликаем по кнопке СООБЩЕТВО в header.", () -> {
            mainPage.clickOnButtonCommunity();
        });

        step("Вводим никнейм игрока в строку поиска людей и нажимем ENTER.", () -> {
            mainPage.searchCommunity(GAMERS);
        });

        step("Проверяем результат.", () -> {
            searchPage.contentVerifyCheckResultGamers(GAMERS);
        });
    }

    @Test
    @DisplayName("Проверка наличия поля поиска при выборе категории Игры, программы и т.д в меню ПОДДЕРЖКА.")
    public void thePresenceOfASearchField(){
        step("Открываем страницу.", () -> {
            mainPage.openMainPage();
        });

        step("Кликаем по кнопке ПОДДЕРЖКА в header.", () -> {
            mainPage.clickOnButtonSupport();
        });

        step("Кликаем по пункту Игры, программы и т. д.", () -> {
            mainPage.clickOnButtonGamesAndPrograms();
        });

        step("Проверяем наличие поля поиска.", () -> {
            mainPage.contentVerifySearchFieldVisible();
        });
    }

    @DisplayName("Проверка корректного отображения текста при смене языка.")
    @CsvSource(value = {
            "Italiano, Installa Steam",
            "Deutsch, Steam installieren",
            "Русский, Установить Steam"
    })
    @ParameterizedTest(name = "При нажатии выборе языка {0} корректно отображается надпись {1}.")
    public void checkCorrectTextWhenChangingTheLanguage(String language, String installButton){
        step("Открываем страницу.", () -> {
            mainPage.openMainPage();
        });

        step("Кликаем по кнопке выбора языка в header.", () -> {
            mainPage.clickOnButtonLanguage();
        });

        step("Выбираем язык.", () -> {
            mainPage.chooseLanguage(language);
        });

        step("Проверяем коректность отображения надписи.", () -> {
            mainPage.contentVerifyCheckTextAfterSwitchingLanguage(installButton);
        });
    }
}
