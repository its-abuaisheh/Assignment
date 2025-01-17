# Clustered Data Warehouse

This project is a Spring Boot application to handle FX deals for Bloomberg.

## Requirements

- Java 17
- MySQL
- Docker
- Docker Compose
- Maven

## Running the application

1. Build the project:

    ```bash
    mvn clean install
    ```

2. Run the application using Docker Compose:

    ```bash
    docker-compose up --build
    ```

3. The application will be available at `http://localhost:8080`.

## API Endpoints

- `POST /api/deals`: Create a new deal.

## Sample Request

```json
{
  "dealUniqueId": "Laith-id-123",
  "fromCurrencyIsoCode": "JOD",
  "toCurrencyIsoCode": "USD",
  "dealTimestamp": "2024-06-11T12:00:00",
  "dealAmount": 1000.0
}
#   A s s i g n m e n t  
 