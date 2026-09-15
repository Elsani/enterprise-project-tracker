# Enterprise Project Tracker 🚀

A modern, full-stack enterprise project tracking platform featuring a decoupled architecture with high-performance backend APIs and a reactive dashboard UI.

---

## 🛠 Tech Stack

**Backend:**
* Java 17 & Spring Boot 3
* Spring Data JPA (Hibernate)
* PostgreSQL (Neon Serverless DB)
* RESTful API Architecture
* Docker Containerization

**Frontend:**
* Nuxt 3 & Vue 3
* Vuetify 3 (Material Design System)
* Pinia (State Management)
* TypeScript & Axios

---

## 📂 Project Structure

    enterprise-project-tracker/
    ├── backend-demo/         # Spring Boot 3 REST API & Neon DB configuration
    ├── frontend-demo/        # Nuxt 3 + Vuetify Enterprise UI Dashboard
    ├── docker-compose.yml    # Multi-container orchestration
    └── .gitignore

---

## 🚀 Getting Started

### 1. Prerequisites
* Java 17+ & Maven
* Node.js 18+ & npm
* Docker & Docker Compose (optional)

### 2. Backend Setup
    cd backend-demo
    ./mvnw clean spring-boot:run

API endpoint: **http://localhost:8080/api/projects**

### 3. Frontend Setup
    cd frontend-demo
    npm install
    npm run dev

Client dashboard: **http://localhost:3000**

---

## 🐳 Docker Deployment
Run both services in containerized mode:

    docker-compose up --build
