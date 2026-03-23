# Projet Web Services — REST & SOAP

## Introduction

Ce projet est decoupage en deux parties independantes, chacune dans son propre dossier Maven :

| Dossier | Type | Technologie | Serveur |
|---------|------|-------------|---------|
| `REST/` | Services REST | Jersey (JAX-RS) | Tomcat |
| `SOAP/` | Services SOAP | JAX-WS RI (Metro) | Tomcat |

---

## Structure du projet

~~~text
/
├── REST/                        <- Projet Maven REST (Jersey)
│   ├── pom.xml
│   └── src/main/
│       ├── java/
│       │   ├── rest/first/
│       │   │   ├── HelloWorldResource.java
│       │   │   └── client/Test.java
│       │   └── rest/todo/
│       │       ├── model/Todo.java
│       │       ├── dao/TodoDao.java
│       │       └── resource/TodoResource.java
│       └── webapp/WEB-INF/
│           ├── web.xml
│           └── jboss-web.xml
│
└── SOAP/                        <- Projet Maven SOAP (JAX-WS)
    ├── pom.xml
    └── src/main/
        ├── java/
        │   ├── org/nanterreU/fr/ws/
        │   │   ├── ICalculatrice.java      <- interface SEI
        │   │   └── CalculatriceImpl.java   <- implementation
        │   └── org/nanterreU/fr/client/
        │       └── CalculatriceClient.java <- client de test
        └── webapp/WEB-INF/
            ├── web.xml
            └── sun-jaxws.xml
~~~

---

## Partie REST — CalculatriceREST

### Technologies
- Java 8
- Jersey 2.35 (JAX-RS)
- Jackson (JSON)
- Apache Tomcat

### Architecture
- **Model** : `Todo` (données métier)
- **DAO** : `TodoDao` (stockage en mémoire)
- **Resource** : `HelloWorldResource`, `TodoResource`

### Endpoints REST
- `GET  http://localhost:8080/CalculatriceREST/rest/hello`
- `GET  http://localhost:8080/CalculatriceREST/rest/todos`
- `GET  http://localhost:8080/CalculatriceREST/rest/todos/{id}`
- `POST http://localhost:8080/CalculatriceREST/rest/todos`

### Réponses
- `/hello` (text/plain) → `Hello Jersey!!!`
- `/hello` (text/xml) → `<?xml version="1.0"?><hello>Hello Jersey!!</hello>`
- `/todos` (JSON) → liste de todos
- `/todos/1` (JSON) → `{"id":1,"title":"Learn REST","done":false}`

### Tests avec curl
~~~bash
curl -H "Accept: text/plain" http://localhost:8080/CalculatriceREST/rest/hello
curl -H "Accept: application/json" http://localhost:8080/CalculatriceREST/rest/todos
curl -H "Accept: application/json" http://localhost:8080/CalculatriceREST/rest/todos/1
~~~

### Lancer le projet REST
1. Aller dans le dossier `REST/`
2. Compiler : `mvn clean package`
3. Copier `target/CalculatriceREST.war` dans le dossier `webapps/` de Tomcat
4. Démarrer Tomcat
5. Tester : `http://localhost:8080/CalculatriceREST/rest/hello`

---

## Partie SOAP — CalculatriceSOAP

### Technologies
- Java 8
- JAX-WS RI (Metro) 2.3.5
- Apache Tomcat

### Architecture
- **ICalculatrice.java** — interface SEI (Service Endpoint Interface) : déclare les opérations
- **CalculatriceImpl.java** — implémentation du service
- **sun-jaxws.xml** — lie l'implémentation à une URL (lue par Tomcat au démarrage)
- **CalculatriceClient.java** — client Java de test

### Opérations disponibles
| Méthode | Description |
|---------|-------------|
| `additionner(a, b)` | Retourne a + b |
| `multiplier(a, b)` | Retourne a * b |
| `soustraire(a, b)` | Retourne a - b |
| `diviser(a, b)` | Retourne a / b (erreur si b = 0) |

### WSDL généré automatiquement
Une fois déployé sur Tomcat :
`http://localhost:8080/CalculatriceSOAP/ws/calculatrice?wsdl`

Le WSDL est généré automatiquement par JAX-WS RI à partir des annotations `@WebService`.

### Lancer le projet SOAP
1. Aller dans le dossier `SOAP/`
2. Compiler : `mvn clean package`
3. Copier `target/CalculatriceSOAP.war` dans le dossier `webapps/` de Tomcat
4. Démarrer Tomcat
5. Vérifier le WSDL : `http://localhost:8080/CalculatriceSOAP/ws/calculatrice?wsdl`
6. Lancer `CalculatriceClient.java` (Run As > Java Application dans Eclipse)

### Test avec le client Java
~~~
=== Test du service SOAP Calculatrice ===
10 + 5   = 15.0
10 * 5   = 50.0
10 - 5   = 5.0
10 / 5   = 2.0
7.5 + 2.5 = 10.0
~~~

---

## Captures d'ecran
![Hello Browser](images/hello-browser.png)
![Hello Curl](images/hello-curl.png)
![Todos List](images/todos.png)
![Todo By Id](images/todo1.png)

---

## Conclusion

On a deux projets Maven autonomes :
- **REST/** : services REST avec Jersey, réponses en JSON/XML/HTML
- **SOAP/** : service SOAP avec JAX-WS RI, WSDL généré automatiquement

Les deux se déploient sur Tomcat avec un simple `mvn clean package` puis copie du `.war`.
