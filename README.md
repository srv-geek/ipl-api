# IPL API 🏏

A Spring Boot-based RESTful API for managing IPL-style cricket tournament data, including Matches, Teams, and Players. This API supports creating, retrieving, and managing information in a structured and scalable way.

---

## 📁 Project Structure

- `com.tka.controller`
  - `MatchController`
  - `TeamController`
  - `PlayerController`
- `com.tka.entity`
  - `Matches`
  - `Team`
  - `Player`
- `com.tka.service`
- `com.tka.dao`
- `com.tka.dto` – For clean API responses and to prevent lazy loading issues

---

## 🚀 Features

### Player Management
- Add a new player to a team
- Get player by ID
- View all players

### Team Management
- Register a new team
- View all teams
- Get team details by ID

### Match Scheduling
- Schedule a match between two teams
- View match schedule
- Get match by ID

---

## 🧪 Technologies Used

- **Java 17+**
- **Spring Boot**
- **Hibernate / JPA**
- **MySQL**
- **Postman** for API testing
- **Maven** for dependency management

---

## 📦 Endpoints

### 🎮 Player Endpoints
| Method | Endpoint               | Description               |
|--------|------------------------|---------------------------|
| POST   | `/players/playerRegist` | Register a new player     |
| GET    | `/players/{id}`         | Get player by ID          |
| GET    | `/players/getPlayer`    | Get all players           |

---

### 🏏 Team Endpoints
| Method | Endpoint               | Description               |
|--------|------------------------|---------------------------|
| POST   | `/teams/teamRegist`     | Register a new team       |
| GET    | `/teams/getAllTeams`    | Get all teams             |
| GET    | `/teams/{id}`           | Get team by ID            |

---

### 📅 Match Endpoints
| Method | Endpoint                 | Description                 |
|--------|--------------------------|-----------------------------|
| POST   | `/matches/matchSchedule` | Create a new match          |
| POST   | `/matches/addMatch`      | Add match with DTO response |
| GET    | `/matches/getSchedule`   | Get all matches             |
| GET    | `/matches/getSingleMatch/{id}` | Get match by ID     |
| GET    | `/matches/getAllMatches` | Get all matches (DTO)       |

---

## 🛠 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/yourusername/ipl-api.git
Import into Eclipse or IntelliJ as a Maven project.

Update application.properties with your MySQL config:

spring.datasource.url=jdbc:mysql://localhost:3306/ipl_db
spring.datasource.username=root
spring.datasource.password=yourpassword


Run the project using your IDE or:
mvn spring-boot:run

⚠️ Notes
Make sure MySQL is running before you start the app.

DTOs are used to avoid LazyInitializationException.

You can test the APIs using Postman or Swagger (if integrated).

🧑‍💻 Author
Shubham Raj Verma

📄 License
This project is licensed under the MIT License.
