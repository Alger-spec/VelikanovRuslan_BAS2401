# Задание 1 — подготовка репозитория

Java 21, Spring Boot 3.5.5, Maven.
Для завершения настройки требуется добавить `src/main/resources/application.yml` со свойством `spring.application.name`, равным номеру студенческого билета.

## Запуск

Установите JDK 21 и задайте JAVA_HOME как путь к папке JDK. В Windows:
```powershell
.\mvnw.cmd clean verify
.\mvnw.cmd spring-boot:run
```

В Linux/macOS:
```sh
sh mvnw clean verify
sh mvnw spring-boot:run
```

Maven Wrapper скачает Maven при первом запуске; нужен доступ в интернет.
Если Maven уже установлен, можно использовать `mvn` вместо wrapper.

## GET-эндпоинты

| Запрос | Ответ |
|---|---|
| http://localhost:8080/api/hello?name=Ivan | Текст: Привет, Ivan! |
| http://localhost:8080/api/hello | Текст: Привет, мир! |
| http://localhost:8080/api/sum?a=2&b=3 | JSON-число: 5 |

`/api/sum` складывает два десятичных числа. Оба параметра обязательны.
Отсутствующий или некорректный параметр приводит к HTTP 400.

## Проверка

`clean verify` собирает проект и запускает тесты HTTP-эндпоинтов и конфигурации.
GitHub Actions выполняет эту проверку при отправке изменений и создании pull request.

## Ссылка для ЛМС

https://github.com/Alger-spec/VelikanovRuslan_BAS2401
