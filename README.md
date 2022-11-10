# Helmes 2022 Backend Java Exercise

## Author: Mathias Are


### Deployment instructions

**Build frontend:**
Run: `npm run build --prefix ./frontend`

**Build backend:**
Run following commands:

1. `cd backend/SectorPicker`

2. `./gradlew bootJar`

3. `cd ../../`

**Run Docker Compose:**

Run: `docker-compose up --build`


**Insert sector's to database from sql file (first time only):**

Run: `cat data.sql | docker exec -i database psql -U postgres`

**Go to [localhost port 80](http://localhost/)**


**To stop applications**

Run: `docker-compose down`