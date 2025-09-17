# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a full-stack application called react-spring-playground featuring:
- **Frontend**: React + TypeScript with Vite, TailwindCSS, and Intent UI components
- **Backend**: Spring Boot application using Java 21 with JOOQ for database access and PostgreSQL as the database

## Common Development Commands

### Project Setup
- `make ready` - Setup both frontend and backend (install dependencies + clean backend)
- `make front-ready` - Install frontend dependencies (npm install in root and frontend)
- `make back-ready` - Clean backend build artifacts

### Frontend Development
- `make front` - Start frontend dev server (Vite)
- `cd frontend && npm run dev` - Alternative way to start frontend
- `cd frontend && npm run build` - Build frontend for production
- `cd frontend && npm run lint` - Run ESLint on frontend code

### Backend Development
- `make build` - Build backend (skips tests)
- `make back` - Start backend with Docker Compose (includes database)
- `make down` - Stop Docker services
- `make down-v` - Stop Docker services and remove volumes

### Database Operations
- `make psql` - Connect to PostgreSQL database via Docker
- Database migrations run automatically on application startup via Flyway

### Code Quality
- Lefthook configured for pre-commit hooks
- Frontend code is auto-formatted and linted with Biome on commit
- Run `npx @biomejs/biome format --write` to format frontend code manually
- Run `npx @biomejs/biome lint` to lint frontend code manually

## Architecture

### Frontend Tech Stack
- **React 19.1.1** with TypeScript
- **Vite 7.1.2** for build tooling
- **TailwindCSS 4.1.13** for styling
- **Intent UI** components (react-aria-components based)
- **Biome 2.2.4** for formatting and linting
- **ESLint 9.33.0** for additional linting

### Backend Tech Stack
- **Spring Boot 3.5.5** with Java 21
- **JOOQ** for type-safe database queries (not JPA/Hibernate)
- **Flyway 11.12.0** for database migrations
- **PostgreSQL 17** database
- **Docker** multi-stage builds for containerization

### Project Structure
```
├── frontend/                 # React frontend application
│   ├── src/
│   │   ├── components/ui/   # Intent UI components
│   │   ├── lib/            # Utility functions
│   │   └── assets/         # Static assets
│   ├── package.json        # Frontend dependencies
│   └── vite.config.ts      # Vite configuration
├── backend/                 # Spring Boot backend
│   ├── src/main/java/      # Java source code
│   ├── src/main/resources/ # Configuration and migrations
│   └── build.gradle        # Backend dependencies
├── Makefile                # Project commands
├── lefthook.yml            # Pre-commit hooks
└── pnpm-workspace.yaml     # PNPM workspace configuration
```

### Key Directories
**Frontend:**
- `frontend/src/components/ui/` - Reusable UI components
- `frontend/src/lib/utils.ts` - Utility functions
- `frontend/src/App.tsx` - Main React component

**Backend:**
- `backend/src/main/java/com/example/backend/` - Main application code
- `backend/src/main/resources/db/migration/` - Flyway database migration files
- `backend/src/main/resources/application.yml` - Spring configuration

### Database Configuration
- Connection URL: `jdbc:postgresql://db:5432/react_spring_playground`
- Docker port mapping: `5434:5432` (avoids local PostgreSQL conflicts)
- Flyway migrations enabled by default in `application.yml`
- Current schema includes users table with id, name, mail_address, password

### Development Workflow
- Uses PNPM workspace for monorepo management
- Lefthook runs frontend formatting and linting on pre-commit
- Frontend uses Biome for fast formatting and linting
- Backend uses Docker Compose for local development
- Main application entry point: `BackendApplication.java`
- Simple test endpoint available at `/api/test`

## Important Notes

### Frontend Development
- Uses Intent UI for component library (based on react-aria-components)
- TailwindCSS 4.x with new configuration format
- TypeScript configured with strict mode
- Biome handles both formatting and linting (replaces Prettier + ESLint partially)

### Backend Development
- Uses JOOQ instead of JPA for database access
- Type-safe SQL queries
- Code generation may be required for schema changes
- JUnit 5 platform configured for testing

### Database Migrations
- Migration files must be in `backend/src/main/resources/db/migration/`
- Follow naming convention: `V{version}__{description}.sql`
- Migrations run automatically on application startup

### Code Quality & Git Hooks
- Lefthook automatically formats and lints frontend code on commit
- Pre-commit hooks ensure code quality before commits
- All staged frontend files are processed through Biome