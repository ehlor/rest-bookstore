# RESTful Web Service - Book Store

Web serviso paleidimas Docker aplinkoje:
1. Klonuojam git repozitoriją
```
git clone https://github.com/theelo/rest-bookstore.git web
```
2. Kuriam image failą
```
docker build -t bookstore web
```
3. Paleidžiam konteinerį su web servisu
```
docker run -d -p 5000:5000 bookstore
```
Funkcijos:

**GET**

Gauti visas knygas ```/books```

Gauti knygą pagal id ```/books/{id}```

**POST**

Patalpinti knygą ```/books?id=...&name=...&author=...&genre=...```

**PUT**

Redaguoti knygą ```/books?oid=SENAS_ID&id=...&name=...&author=...&genre=...```

**DELETE**

Ištrinti knygą ```/books/{id}```
