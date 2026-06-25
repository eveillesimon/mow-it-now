# Mow It Now

Java implementation of the MowItNow mower kata by Simon Eveillé.

## Requirements

- Java 21 or later
- Maven 3

## Build

From the project root:

```bash
mvn clean install
```

## Run tests

From the project root:

```bash
mvn test
```


## Run the application
```bash
java -jar target/mow-it-now-1.0-SNAPSHOT.jar ./samples/input.txt
```

## Input example
```text
5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA
```
## Expected output
```text
1 3 N 5 1 E
```