## REST Web Service avec Jersey - Projet CalculatriceWS

## Introduction
Ce projet a pour objectif de mettre en place un service REST en Java avec Jersey, deploye sur Tomcat.
Le service retourne des reponses dans plusieurs formats (text/plain, text/xml, text/html) et expose aussi une ressource TODO en JSON.

## Technologies utilisees
- Java
- Jersey (JAX-RS)
- Apache Tomcat
- Maven

## Architecture du projet
- Model : `Todo` (donnees metier)
- DAO : `TodoDao` (stockage en memoire)
- Resource : `HelloWorldResource`, `TodoResource`

Organisation logique :

~~~text
rest.first
  ├── HelloWorldResource
  └── client/Test

rest.todo
  ├── model/Todo
  ├── dao/TodoDao
  └── resource/TodoResource
~~~

## Endpoints REST
- http://localhost:8080/CalculatriceWS/rest/hello
- http://localhost:8080/CalculatriceWS/rest/todos
- http://localhost:8080/CalculatriceWS/rest/todos/1

## Tests et resultats
### Hello
- text/plain -> `Hello Jersey!!!`
- text/xml -> `<hello>Hello Jersey!!</hello>`
- text/html -> page HTML contenant Hello Jersey

Exemples de reponse :

~~~xml
<?xml version="1.0"?><hello>Hello Jersey!!</hello>
~~~

~~~html
<html><title>Hello Jersey</title><body><h1>Hello Jersey!!</h1></body></html>
~~~

### Todos
- /todos ->

~~~json
[
  {"id":1,"title":"Learn REST","done":false},
  {"id":2,"title":"Do TD","done":true}
]
~~~

- /todos/1 ->

~~~json
{"id":1,"title":"Learn REST","done":false}
~~~

## Tests avec curl
~~~bash
curl -H "Accept: text/plain" http://localhost:8080/CalculatriceWS/rest/hello
curl -H "Accept: text/xml" http://localhost:8080/CalculatriceWS/rest/hello
curl -H "Accept: text/html" http://localhost:8080/CalculatriceWS/rest/hello
~~~

## Captures d'ecran
![Hello Browser](images/hello-browser.png)
![Hello Curl](images/hello-curl.png)
![Todos List](images/todos.png)
![Todo By Id](images/todo1.png)

## Conclusion
Le service REST fonctionne correctement.
Les differents formats de reponse sont supportes.
L'architecture REST (Model / DAO / Resource) est respectee avec Jersey.
Les tests (navigateur, curl, client Java) ont ete valides.
