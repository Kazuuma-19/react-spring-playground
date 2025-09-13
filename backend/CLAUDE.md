# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is the backend component of react-spring-playground, a Spring Boot application using Java 21 with JOOQ for database access and PostgreSQL as the database.

## Common Development Commands

### Building and Running
- `make back-ready` - Clean backend build artifacts
- `make build` - Build backend (skips tests)
- `make back` - Start backend with Docker Compose (includes database)
- `make down` - Stop Docker services
- `make down-v` - Stop Docker services and remove volumes

### Database Operations
- `make psql` - Connect to PostgreSQL database via Docker
- Database migrations run automatically on application startup via Flyway

### Gradle Commands
- `./gradlew bootJar` - Build executable JAR
- `./gradlew build -x test` - Build without running tests
- `./gradlew test` - Run tests (JUnit 5)
- `./gradlew clean` - Clean build artifacts

## Architecture

### Tech Stack
- **Spring Boot 3.5.5** with Java 21
- **JOOQ** for type-safe database queries (not JPA/Hibernate)
- **Flyway 11.12.0** for database migrations
- **PostgreSQL 17** database
- **Docker** multi-stage builds for containerization

### Key Directories
- `src/main/java/com/example/backend/` - Main application code
- `src/main/resources/db/migration/` - Flyway database migration files
- `src/main/resources/application.yml` - Spring configuration
- `gradle/flyway.gradle` - Flyway-specific dependencies

### Database Configuration
- Connection URL: `jdbc:postgresql://db:5432/react_spring_playground`
- Docker port mapping: `5434:5432` (avoids local PostgreSQL conflicts)
- Flyway migrations enabled by default in `application.yml`
- Current schema includes users table with id, name, mail_address, password

### Docker Setup
- Multi-stage Dockerfile with separate build and runtime stages
- Docker Compose includes app and database services
- App depends on database service startup
- Persistent volume for database data

### Development Workflow
- Currently on `feature/settings` branch
- Japanese PR and Issue templates in `.github/`
- Main application entry point: `BackendApplication.java`
- Simple test endpoint available at `/api/test`

## Important Notes

### Database Migrations
- Migration files must be in `src/main/resources/db/migration/`
- Follow naming convention: `V{version}__{description}.sql`
- Migrations run automatically on application startup

### JOOQ Integration
- Uses JOOQ instead of JPA for database access
- Type-safe SQL queries
- Code generation may be required for schema changes

### Testing
- JUnit 5 platform configured
- Test directory structure exists but no tests implemented yet