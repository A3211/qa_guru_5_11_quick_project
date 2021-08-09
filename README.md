# Автотесты для сайта https://youtravel.me/
___
## Используемые технологии и инструменты
| GitHub | IntelliJ IDEA | Java | Gradle | Junit5 | Selenide |
|:------:|:----:|:----:|:------:|:------:|:--------:|
| <img src="images/GitHub.svg" width="40" height="40"> | <img src="images/IDEA.svg" width="40" height="40"> | <img src="images/JAVA.svg" width="40" height="40"> | <img src="images/Gradle.svg" width="40" height="40"> | <img src="images/Junit5.svg" width="40" height="40"> | <img src="images/Selenide.svg" width="40" height="40"> |

| Jenkins | Selenoid | Allure Report | Allure TestOps | Telegram |
|:--------:|:-------------:|:---------:|:-------:|:--------:|
| <img src="images/Jenkins.svg" width="40" height="40"> | <img src="images/Selenoid.svg" width="40" height="40"> | <img src="images/Allure Report.svg" width="40" height="40"> | <img src="images/Allure TestOps.svg" width="40" height="40"> | <img src="images/Telegram.svg" width="40" height="40"> |
___

## Список тестов
* 1 Успешный переход на страницу https://youtravel.me/
  * Переходим на https://youtravel.me/
  * Проверяем что есть надпись "GROUP TOURING AS PERSONAL AS NEVER BEFORE"  
* 2 Успешное изменение языка на русский
  * Переходим на https://youtravel.me/
  * Проверяем что есть надпись "GROUP TOURING AS PERSONAL AS NEVER BEFORE"
  * Кликаем на "Language"
  * Кликаем на "Russian (Русский)"  
  * Проверяем что есть надпись "АВТОРСКИЕ ТУРЫ — НОВЫЙ ФОРМАТ НАСЫЩЕННЫХ ПУТЕШЕСТВИЙ"  
* 3 Успешный поиск тура
  * Переходим на https://youtravel.me/
  * Проверяем что есть надпись "GROUP TOURING AS PERSONAL AS NEVER BEFORE"
  * Выбираем "Arizona"
  * Выбираем дату
  * Жмем на поиск
  * Проверяем что страница с турами успешно открылась

---

## Как запускать тесты

Запуск тестов происходит через джобу в Jenkins
https://jenkins.autotests.cloud/job/C07-AlexeyKuslin-12_quick_tests/

![alt "бот в телеграмме"](./images/Jenkins.png "бот в телеграмме")


### Run tests with filled local.properties:

```bash
gradle clean test
```

### Run tests with not filled local.properties:

```bash
gradle clean -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

### Serve allure report:

```bash
allure serve build/allure-results
```

---

## Оповещение о результатах прохождения тестов происходит через бот в телеграм <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Telegram.svg" width="30" height="30"  alt="Telegram"/></a>

После прохождения всех тестов приходит отчет в телегу

![alt "бот в телеграмме"](./images/telegram.png "бот в телеграмме")

---

## Анализ результатов

Более подробно с результатми тестов (шаги, скриншоты, видео прохождения теста, page source и browser console log) можно ознакомиться в:
* Jenkins через Allure Reports 
(перейти по ссылке в отчете телеграм)
* и в Allure TestOps.

## Анализ результатов в Jenkins через Allure Reports
![alt "Allure Reports"](./images/Allure.png "Allure Reports")
## Анализ результатов в Allure TestOps <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Allure_EE.svg" width="40" height="40"  alt="Allure EE"/></a>

![alt "Allure TestOps"](./images/AllureTestOps.png "Allure TestOps")
## Видео прохождения тестов, взятое из среды выполнения (из Selenoid) <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Selenoid.svg" width="40" height="40"  alt="Selenoid"/></a>

![alt "Video from Selenoid"](./images/Selenoid.gif "Video from Selenoid")