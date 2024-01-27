# Dokumentacja API

## Auth API

### `POST /api/v1/auth/register`

Rejestracja nowego użytkownika.

**Zapytanie:**
```json
{
  "firstname": "John",
  "lastname": "Doe",
  "email": "john.doe@example.com",
  "password": "password123"
}
```
**Odpowiedź:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c",
  "user": {
    "userId": "123e4567-e89b-12d3-a456-426614174001",
    "firstname": "John",
    "lastname": "Doe",
    "email": "john.doe@example.com"
  }
}
```

### `POST /api/v1/auth/authenticate`

Autentykacja użytkownika.

**Zapytanie:**
```json
{
  "email": "john.doe@example.com",
  "password": "password123"
}
```
**Odpowiedź:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c",
  "user": {
    "userId": "123e4567-e89b-12d3-a456-426614174001",
    "firstname": "John",
    "lastname": "Doe",
    "email": "john.doe@example.com"
  }
}
```

## Budget API

### `GET /api/v1/auth/getBudget/{budgetId}`

Pobierz informacje o budżecie na podstawie jego identyfikatora.

**Parametry ścieżki:**

* `budgetId` (UUID) - Identyfikator budżetu.

**Odpowiedź:**

```json
{
  "budgetId": "123e4567-e89b-12d3-a456-426614174001",
  "name": "Budget 2022",
  "description": "Budget for the year 2022",
  "budgetEntitiesIds": ["234e5678-e89b-12d3-a456-426614174002", "345e6789-e89b-12d3-a456-426614174003"],
  "budgetUsersIds": ["456e7890-e89b-12d3-a456-426614174004"],
  "isPrimary": true
}
```

## Budget Entity API

### `POST /api/v1/auth/getBudgetEntities`

Pobierz listę wpisów budżetowych.

**Zapytanie:**
```json
{
  "budgetEntitiesIds": ["234e5678-e89b-12d3-a456-426614174002", "345e6789-e89b-12d3-a456-426614174003"]
}
```
**Odpowiedź:**
```json
{
  "budgetEntitiesList": [
    {
      "entityId": "234e5678-e89b-12d3-a456-426614174002",
      "amount": 150.0,
      "type": "Expense",
      "category": "Food",
      "date": "2022-01-15",
      "budgetId": "123e4567-e89b-12d3-a456-426614174001"
    },
    {
      "entityId": "345e6789-e89b-12d3-a456-426614174003",
      "amount": 200.0,
      "type": "Income",
      "category": "Salary",
      "date": "2022-01-20",
      "budgetId": "123e4567-e89b-12d3-a456-426614174001"
    }
  ]
}
```

### `POST /api/v1/auth/addBudgetEntity`

Dodaj nowy wpis budżetowy.

**Zapytanie:**
```json
{
  "budgetId": "123e4567-e89b-12d3-a456-426614174001",
  "amount": 150.0,
  "type": "Expense",
  "category": "Food",
  "date": "2022-01-15"
}
```
**Odpowiedź:**
```json
{
  "entityId": "456e7890-e89b-12d3-a456-426614174004",
  "amount": 150.0,
  "type": "Expense",
  "category": "Food",
  "date": "2022-01-15",
  "budgetId": "123e4567-e89b-12d3-a456-426614174001"
}
```

### `DELETE /api/v1/auth/deleteBudgetEntity/{budgetEntityId}`

Usuń wpis budżetowy na podstawie jego identyfikatora.

**Parametry ścieżki:**

* `budgetEntityId` (UUID) - Identyfikator wpisu budżetowego.

**Odpowiedź:**

```json
Entry deleted successfully
```

## User API

### `GET /api/v1/auth/getUser/{userId}`

Pobierz informacje o użytkowniku na podstawie jego identyfikatora.

**Parametry ścieżki:**

* `userId` (UUID) - Identyfikator użytkownika.

**Odpowiedź:**

```json
{
  "userId": "123e4567-e89b-12d3-a456-426614174001",
  "firstname": "John",
  "lastname": "Doe",
  "email": "john.doe@example.com",
  "usersBudgetsIds": ["234e5678-e89b-12d3-a456-426614174002"],
  "role": "USER"
}
```