# Stock Watchlist Alert System 📈

A Spring Boot web application for tracking stocks, managing watchlists, and setting up price alerts.

## 🚀 Quick Start

### Prerequisites
- Java 21 or higher
- MySQL database (or use provided Aiven Cloud configuration)
- Maven (optional - wrapper included)

### Setup & Run

1. Clone the project
   ```bash
   git clone https://github.com/ManojTarakaRamaraoGunuru/StockWatchListAlertSystem.git
   cd StockWatchlistAlertSystem

2. Configure environment variables by creating a .env file at root dir
    ```bash
   # Copy the environment template
    DB_URL=""
    DB_USERNAME=""
    DB_PASSWORD=""
    ALPHA_VANTAGE_API=""  # needed for collecting stock data
3. Run your application
   ```bash
   # Using Make (recommended)
   make run 
   ```
   or
    ``` bash
    ./mvnw spring-boot:run