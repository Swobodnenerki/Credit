# CreditApp
Pobranie i uruchomienie kontenerów:__
W katalogu głównym projektu znajduje się plik docker-compose.yml
Należy wydać polecenie docker-compose build, a następnie docker-compose up.
Baza działa na domyślnym porcie 5432.
Na porcie 2211 działa Adminer, który pozwala na podgląd i edycję bazy przez przeglądarkę.
Na porcie 8074 działa aplikacja.
Przykładowe endpointy:
GET http://localhost:8074/credit/
POST http://localhost:8074/credit/
{
        "firstName": "Jan",
        "lastName": "Kowalski",
        "pesel": "75042007150",
        "creditName": "kredyt",
        "value": 30000.0
}
GET http://localhost:8074/customer/search/
POST http://localhost:8074/customer/
{
        "firstName": "Jan",
        "lastName": "Kowalski",
        "pesel": "75042007150"
}
W folderze db znajduje się plik sql z modelem bazy danych.
