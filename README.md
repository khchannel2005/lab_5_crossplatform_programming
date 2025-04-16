# Gym API

## Опис
Цей REST API дозволяє управляти учасниками спортзалу.

## Ендпоінти

### GET /api/members
- Опис: Отримати всіх учасників
- Параметри:
  - `type` (optional): фільтрація за типом підписки
- Headers:
  - `X-Client-Name` (optional): ім’я клієнта, який робить запит

### POST /api/members
- Опис: Додати нового учасника
- Body (JSON):
```json
{
  "id": 1,
  "name": "Ivan Petrov",
  "email": "ivan@gym.com",
  "membershipType": "Gold"
}
