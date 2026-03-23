# Projet Web Services — REST & SOAP (MIAGE L3)

## 👨‍🎓 Contexte

Ce projet a été réalisé dans le cadre du module Web Services.

L'objectif est de mettre en place :

* un service REST (JAX-RS / Jersey)
* un service SOAP (JAX-WS avec EJB)
* un client Java pour tester le SOAP

---

## ⚙️ Technologies utilisées

* Java 1.8 (obligatoire selon consigne) 
* Apache Tomcat (REST + SOAP)
* JAX-RS (Jersey)
* JAX-WS (SOAP)
* Maven
* Eclipse IDE

---

## 📁 Structure du projet

```
CalculatriceWS-REST/
│
├── REST/
│   ├── HelloWorldResource.java
│   ├── TodoResource.java
│
├── SOAP/
│   ├── CalculatriceServiceRemote.java
│   ├── CalculatriceService.java
│
├── ClientWS/
│   ├── ClientMain.java
│
├── web.xml
├── sun-jaxws.xml
├── pom.xml
└── README.md
```

---

## 🌐 Partie 1 — Web Service REST

### 🔹 HelloWorldResource

Endpoints disponibles :

* `GET /rest/hello` → text/plain
* `GET /rest/hello` → text/xml
* `GET /rest/hello` → text/html

✔ Permet de tester les différents types de réponse HTTP

---

### 🔹 TodoResource

Endpoints :

* `GET /rest/todos` → retourne la liste des todos (JSON)
* `GET /rest/todos/{id}` → retourne un todo spécifique (JSON)
* `POST /rest/todos` → ajoute un todo

✔ Gestion simple d'une API REST CRUD

---

### 🔹 Configuration

Dans `web.xml` :

* Jersey activé
* Mapping : `/rest/*`
* Packages scannés :

  * `rest.first`
  * `rest.todo.resource`

---

## 🧮 Partie 2 — Web Service SOAP

### 🎯 Objectif

Créer un service SOAP avec EJB comme demandé dans l'énoncé 

---

### 🔹 Interface : CalculatriceServiceRemote

```java
@Remote
@WebService(name="Calculatrice")
```

Méthodes :

* additionner(double a, double b)
* multiplier(double a, double b)

✔ Conforme aux consignes du prof 

---

### 🔹 Implémentation : CalculatriceService

```java
@Stateless
@WebService(endpointInterface="...")
```

✔ Implémente les opérations SOAP
✔ Utilise @Stateless comme demandé 

---

### 🔹 Endpoint SOAP

```
http://localhost:8080/CalculatriceSOAP/ws/calculatrice
```

WSDL :

```
http://localhost:8080/CalculatriceSOAP/ws/calculatrice?wsdl
```

---

## 🔗 URLs de test (REST + SOAP)

### REST

* `GET http://localhost:8080/CalculatriceREST/rest/hello` (text/plain)
* `GET http://localhost:8080/CalculatriceREST/rest/hello` avec `Accept: text/xml`
* `GET http://localhost:8080/CalculatriceREST/rest/hello` avec `Accept: text/html`
* `GET http://localhost:8080/CalculatriceREST/rest/todos` (JSON)
* `GET http://localhost:8080/CalculatriceREST/rest/todos/1` (JSON)
* `POST http://localhost:8080/CalculatriceREST/rest/todos`

### SOAP

* Endpoint : `http://localhost:8080/CalculatriceSOAP/ws/calculatrice`
* WSDL : `http://localhost:8080/CalculatriceSOAP/ws/calculatrice?wsdl`

---

## ▶️ Explication pour lancer le projet

### 1. Lancer REST

1. Ouvrir un terminal dans le dossier `REST`
2. Compiler et packager : `mvn clean package`
3. Copier `REST/target/CalculatriceREST.war` dans `tomcat/webapps/`
4. Démarrer Tomcat
5. Tester : `http://localhost:8080/CalculatriceREST/rest/hello`

### 2. Lancer SOAP

1. Ouvrir un terminal dans le dossier `SOAP`
2. Compiler et packager : `mvn clean package`
3. Copier `SOAP/target/CalculatriceSOAP.war` dans `tomcat/webapps/`
4. Démarrer Tomcat (ou redémarrer si déjà lancé)
5. Vérifier le WSDL : `http://localhost:8080/CalculatriceSOAP/ws/calculatrice?wsdl`

### 3. Tester le client SOAP

* Lancer la classe `ClientMain` dans le dossier `ClientWS`
* Ou lancer la classe `CalculatriceClient` dans le dossier `SOAP`

---

## 🧪 Test du Web Service SOAP

### ✔ Méthode 1 — Navigateur

* Accès au WSDL
* Vérification des opérations

---

### ✔ Méthode 2 — Web Services Explorer (Eclipse)

Étapes :

1. Lancer Web Services Explorer
2. Charger le WSDL
3. Tester les méthodes
4. Visualiser les SOAP Envelopes

✔ Conforme aux consignes 

---

## 💻 Partie 3 — Client SOAP

### 🔹 Génération des classes

Commande utilisée :

```
wsimport -s . -d ../bin <URL_WSDL>
```

✔ Génère les stubs nécessaires 

---

### 🔹 Classe ClientMain

```java
CalculatriceServiceService service = new CalculatriceServiceService();
Calculatrice calculatrice = service.getCalculatriceServicePort();

System.out.println(calculatrice.add(2,33));
```

✔ Test de la méthode addition 

---

## ✅ Résultat final

✔ Service REST fonctionnel
✔ Service SOAP conforme aux consignes
✔ Client Java fonctionnel
✔ Tests validés (WSDL + client)

---

## ⚠️ Remarques

* Les annotations `@Stateless` et `@Remote` sont présentes pour respecter les consignes, même si Tomcat ne les exploite pas.
* Le projet est entièrement fonctionnel sans serveur WildFly.

---

## 🚀 Conclusion

Ce projet permet de comprendre :

* la différence entre REST et SOAP
* la création d'API web
* l'utilisation des Web Services en Java
* la communication client / serveur

---

## 📌 Auteur

Projet réalisé par :

* Maissara Ferkous
