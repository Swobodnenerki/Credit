# CreditApp
Pobranie i uruchomienie kontenerów:<br />
W katalogu głównym projektu znajduje się plik docker-compose.yml<br />
Należy wydać polecenie docker-compose up.<br />
Baza działa na domyślnym porcie 5432.<br />
Na porcie 2211 działa Adminer, który pozwala na podgląd i edycję bazy przez przeglądarkę.<br />
Na porcie 8074 działa aplikacja.<br />
Jeżeli wystąpi błąd podczas uruchamiania aplikacji należy usunąć zawartość folderu data wykonać polecenie docker-compose build, a następnie docker-compose up. <br />
W kolejnym kroku należy połączyć się z aplikacją Adminer, i uzupełnić pola w następujący sposób: <br />
![image](https://user-images.githubusercontent.com/61480793/152613625-cf083a27-353a-4191-9fca-7e1bca29a37c.png)<br />
,gdzie hasło to postgres <br />
Następnie w zakładce Zapytanie SQL należy wkleić zawartość pliku DatabaseModel.sql, który znajduje się w folderze db.<br />
![image](https://user-images.githubusercontent.com/61480793/152613871-248a239a-55eb-4114-8a79-94036b2be38a.png) <br />
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

