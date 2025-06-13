# task-tracker-api

## 🧩 GROUP 2 – Task Tracker System

### 📁 Recommended Repository Name:

`task-tracker-api`

### 🎯 Product Requirements

Aplikasi ini bertujuan membantu pengguna dalam:

- Menyusun dan mengatur daftar tugas
- Mengelompokkan tugas berdasarkan status (TO_DO, IN_PROGRESS, DONE)
- Melacak kemajuan tugas berdasarkan status
- Menampilkan ringkasan progres user

---

### 📡 API Specification

**Base URL**: `/api/v1`

#### 👤 User API

| Method | Endpoint                   | Description                          |
| ------ | -------------------------- | ------------------------------------ |
| POST   | `/users`                   | Register new user                    |
| GET    | `/users`                   | List all users                       |
| GET    | `/users/{id}/task-summary` | Show summary of task count by status |


**User Schema (snake_case)**

```json
{
  "name": "bob",
  "email": "bob@example.com"
}
```

---

#### ✅ Task API

| Method | Endpoint      | Description                                      |
| ------ | ------------- | ------------------------------------------------ |
| POST   | `/tasks`      | Create a new task                                |
| GET    | `/tasks`      | List tasks (filter by user_id, status, due_date) |
| GET    | `/tasks/{id}` | Get task detail                                  |
| PUT    | `/tasks/{id}` | Update a task                                    |
| DELETE | `/tasks/{id}` | Delete a task                                    |

**Task Schema (snake_case)**

```json
{
  "title": "submit_report",
  "description": "send_pdf_to_manager",
  "status": "to_do",
  "due_date": "2025-06-15",
  "user_id": 2
}
```

---
