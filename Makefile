front-ready:
	npm install && cd frontend && npm install

back-ready:
	cd backend && ./gradlew clean

ready:
	make front-ready
	make back-ready

front:
	cd frontend && npm run dev 

build:
	cd backend && ./gradlew build -x test

back:
	cd backend && docker compose up --build

down:
	cd backend && docker compose down

down-v:
	cd backend && docker compose down -v

psql:
	cd backend && docker compose exec db psql -U postgres -d react_spring_playground