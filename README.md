# 📊 Data Meter Report

## 📘 Project Overview

**Data Meter Final** is a Java 21 + Maven-based application that processes telecom usage data from `.txt` files. It reads all files in a given input directory, aggregates data usage per user (4G, 5G, Roaming), and computes billing costs using configurable rules. The output is displayed directly in the terminal.

---

## ✨ Features

- 📂 Parses multiple `.txt` files from a directory
- 📊 Aggregates 4G, 5G, and roaming usage by user
- 💰 Calculates billing cost based on configurable rates and thresholds
- ⚙️ Uses an easily editable `config.properties` file
- 🖥️ Displays results directly in the command line (no CSV output)
- ✅ Simple, Maven-based build with no external dependencies

---

## 🗂️ Directory Structure

![image](https://github.com/user-attachments/assets/cb3b3a8b-ecc3-4610-9f3a-e83aa172e107)


---

## ✅ Prerequisites

- **Java 21 (JDK 21)**
- **Apache Maven 3.9+**

Verify setup:

- bash
- java -version
- mvn -v

⚙️ Configuration
- threshold=100000
- rate.4g=0.05
- rate.5g=0.10
- rate.4g.roaming=0.055
- rate.5g.roaming=0.115
- threshold.surcharge=0.05


🛠️ Build and Run
1. Compile the Project
- bash

- mvn clean compile

2. Run the Application
- bash

- mvn exec:java -Dexec.mainClass="com.datameter.Main" -Dexec.args="data"
- data is the folder containing input .txt files.

Output will be shown in your terminal.

📥 Sample Input (.txt format)

- 9000600600|InAir1234|0|13456|No
- 9000600601|InAir125|1345|0|Yes

📤 Sample Output (Terminal)

- Mobile: 9000600600 | 4G: 0KB | 5G: 13456KB | Roaming: No | Cost: 1346
- Mobile: 9000600601 | 4G: 1345KB | 5G: 0KB | Roaming: Yes | Cost: 74

🔚 Summary

- Install Java 21 and Maven
- Configure your billing rules in config.properties
- Place usage data files in the data/ folder
- Run the program using Maven

References:

- Java 21 Downloads
- Apache Maven Downloads
- Maven Exec Plugin Docs


👨‍🏫 Mentor Instructions
To review this project:

-  Clone the repository
📂 Place your .txt usage files inside the data/ folder.
🖥️ Output will be printed to your terminal.
- Run the command:
- bash

# 1. Clone the repo
git clone https://github.com/anishhsingh/data-meter.git
cd data-meter

# 2. Compile
mvn clean compile

# 3. Run the program
mvn exec:java -Dexec.mainClass="com.datameter.Main" -Dexec.args="data"

