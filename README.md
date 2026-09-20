Markdown
# Enterprise Project Tracker

A scalable, full-stack enterprise project management dashboard built with **Java Spring Boot**, **Nuxt 3 (Vue 3)**, **Vuetify**, and **PostgreSQL**. The platform provides streamlined tracking of multi-phase enterprise projects, milestone monitoring, and role-based tracking metrics.

---

## Architecture Overview

```text
enterprise-project-tracker/
├── backend-demo/          # Spring Boot 3 REST API (Java 17/21)
│   ├── src/main/java/     # Layered architecture (Controller, Service, Repository, DTO, Model)
│   ├── Dockerfile         # Multi-stage JDK build
│   └── pom.xml            # Maven configuration
└── frontend-demo/         # Nuxt 3 + Vuetify Client Application
├── app/               # Vue 3 reactive pages, layouts, and Pinia stores
├── Dockerfile         # Containerized production build
└── nuxt.config.ts     # TypeScript & Vuetify plugin configurations


---

## Tech Stack

- **Backend:** Java 17+, Spring Boot 3, Spring Data JPA, Hibernate, PostgreSQL.
- **Frontend:** Nuxt 3, Vue 3, TypeScript, Pinia (State Management), Vuetify 3.
- **DevOps & Tooling:** Docker, Docker Compose, Git, Maven.

---

## Key Features

- **Decoupled Architecture:** Clean separation of concerns using Data Transfer Objects (DTOs) and service layers.
- **Global Error Handling:** Centralized exception handling via `@RestControllerAdvice` returning standardized HTTP response structures.
- **Reactive State Management:** Pinia stores managing client-side project states, caching, and reactive updates.
- **Containerized Orchestration:** Production-ready multi-stage Docker builds for rapid deployment.

---

## API Endpoints (Core)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/v1/projects` | Fetch paginated list of enterprise projects |
| `GET` | `/api/v1/projects/{id}` | Retrieve detailed project status by ID |
| `POST` | `/api/v1/projects` | Create a new project record |
| `PUT` | `/api/v1/projects/{id}` | Update existing project attributes |
| `DELETE` | `/api/v1/projects/{id}` | Remove project record |

---

## Getting Started

### Prerequisites
- Docker & Docker Compose installed
- *Or* Java 17+ SDK and Node.js (v18+) for local bare-metal run

### Running with Docker Compose

bash

Clone the repository
git clone https://github.com/Elsani/enterprise-project-tracker.git
cd enterprise-project-tracker

Launch both backend and frontend services
docker compose -f backend-demo/docker-compose.yml up -d


### Manual Local Development

**Backend:**
bash
cd backend-demo
./mvnw spring-boot:run


**Frontend:**
bash
cd frontend-demo
npm install
npm run dev


---

## License
MIT License
