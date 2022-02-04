# CreditApp
Pobranie i uruchomienie kontenerów:<br />
W katalogu głównym projektu znajduje się plik docker-compose.yml<br />
Należy wydać polecenie docker-compose build, a następnie docker-compose up.<br />
Baza działa na domyślnym porcie 5432.<br />
Na porcie 2211 działa Adminer, który pozwala na podgląd i edycję bazy przez przeglądarkę.<br />
Na porcie 8074 działa aplikacja.<br />
Przykładowe endpointy:<br />
GET http://localhost:8074/credit/<br />
POST http://localhost:8074/credit/<br />
{<br />
        "firstName": "Jan",<br />
        "lastName": "Kowalski",<br />
        "pesel": "75042007150",<br />
        "creditName": "kredyt",<br />
        "value": 30000.0<br />
}<br />
GET http://localhost:8074/customer/search/<br />
POST http://localhost:8074/customer/<br />
{<br />
        "firstName": "Jan",<br />
        "lastName": "Kowalski",<br />
        "pesel": "75042007150"<br />
}<br />
W folderze db znajduje się plik sql z modelem bazy danych.<br />
