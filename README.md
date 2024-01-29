# Budget Buddy Api

## Opis
Budget Buddy Api to backendowa część aplikacji służącej do zarządzania budżetem. Aplikacja umożliwia użytkownikom tworzenie budżetów, śledzenie wydatków, zarządzanie kategoriami i więcej.

* Klient do aplikacji znajduje się w osobnym repozyrotium pod linkiem https://github.com/marcinkida97/budget-buddy

## Wymagania wstępne
1. Java 17 lub nowsza
2. Docker

## Instalacja
1. Sklonuj repozytorium:

    ```bash
    git clone https://github.com/marcinkida97/budget-buddy-api.git
    ```

2. Ustaw połączenie do bazy danych w pliku `src/main/resources/application.properties`.

3. Uruchom Dockera:

    ```bash
    docker-compose up
    ```

4. Uruchom aplikację:

    ```bash
    ./mvnw spring-boot:run
    ```

## Konfiguracja

W pliku `application.properties` możesz dostosować ustawienia aplikacji, takie jak połączenie do bazy danych, port, itp.

Przykład:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/budgetbuddy
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
```

## Struktura projektu

src/main/java/com/budgetbuddy/budget_buddy - główny pakiet aplikacji  
controllers - kontrolery obsługujące zapytania HTTP  
models - encje i modele danych  
repositories - interfejsy repozytoriów do interakcji z bazą danych  
services - logika biznesowa  
src/main/resources - zasoby, takie jak pliki konfiguracyjne  

## Dokumentacja API

Dokumentacja API znajduje się w katalogu głównym w pliku ApiDocumentation.md

## Autorzy

Marcin Kida