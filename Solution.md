# SPRINGCRUD BANK



## INSTALLATION & EXECUTION

With maven installed and from the terminal/console, move to de project directory and type:

- For installing maven in a Mac: https://mkyong.com/maven/install-maven-on-mac-osx/
- For installing maven in Windows: https://mkyong.com/maven/how-to-install-maven-in-windows/

```bash
$ mvn spring-boot:run
```

For testing (I've used postman), install:

- Postman (https://www.postman.com/) or
- SOAPUI (https://www.soapui.org/downloads/soapui/)



## Operations

The context path is: http://localhost:8080/springcrudbank/api

|                |                                          |
| -------------- | ---------------------------------------- |
| /welcome       | Being polite is a must !                 |
| /createAccount | Create an account in springcrud bank      |
| /deposit       | Deposit money                            |
| /withdraw      | Withdraw money                           |
| /\{accountId\} | Display movements from the given account |



### 1. Being polite is a must

http://localhost:8080/springcrudbank/api/welcome

### 2. Open an account to operate

http://localhost:8080/springcrudbank/api/createAccount

```json
{
	"bancAccountHolder" : "SpringBank",
	"initAmount": 700.00
}
```

### 3. Deposit money

http://localhost:8080/springcrudbank/api/deposit

```json
{
	"accountId" : 1,
  "amount": 200
}
```

### 4. Withdraw money

http://localhost:8080/springcrudbank/api/withdraw

```
{
	"accountId" : 1,
	"amount": 500
}
```

### 5. Show me the money

http://localhost:8080/springcrudbank/api/{the account id}

```
http://localhost:8080/springcrudbank/api/1
```



## Database

It's a h2 in memory database.

You can access the console by running the application and typing in your browser:
```
http://localhost:8080/springcrudbank/h2-console
```
This is the jdbc connection:
```
jdbc:h2:mem:springcrudbank
```
