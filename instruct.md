# Smart Employee Asset & Access Management System (SEAAMS)

## Overview
SEAAMS is a Java console application for managing employee records, hardware asset inventory, and IT support requests in a single system. The project uses object-oriented design and Java collection classes to model real-world office operations such as employee registration, asset allocation, and FIFO ticket processing.

## Completed Features
The project has been implemented and is working with the current `MainApp` entry point.

### 1. Employee Management
- Register employees with ID, name, email, salary, and department
- Prevent duplicate employee IDs and duplicate email addresses
- Search for an employee by ID
- Display all employees
- Sort employees alphabetically by name

### 2. Asset Inventory Management
- Product inventory for `Laptop` and `Mobile` assets
- Asset tagging and cost tracking
- Allocation and deallocation logic
- Inventory overview display
- Prevention of double allocations

### 3. Service Request Queue
- Raise service tickets for employees
- Store ticket details in a queue using FIFO processing
- Process the next pending request
- View all queued tickets
- Ticket status updated to `OPEN` and then `CLOSED`

### 4. Advanced Java Collection Demonstrations
- `TreeSet` bounds navigation (`lower`, `higher`, `floor`, `ceiling`)
- `TreeMap` sorted key operations (`higherKey`, `lowerKey`, `firstKey`, `lastKey`)
- `subMap()` backed collection view demonstration

### 5. Validation and Utilities
- Input parsing for employee ID and salary
- Centralized validation helper class

## How to Run the Project

From the project root folder (`SEAAMS`):

### PowerShell

```powershell
cd "c:/Users/Asus/IdeaProjects/java 2026 batch/SEAAMS"
javac -d out $(Get-ChildItem -Recurse -Filter *.java -Path src | ForEach-Object { $_.FullName })
java -cp out com.company.seaams.main.MainApp
```

### Or with the same command sequence used in this project

```powershell
cd "c:/Users/Asus/IdeaProjects/java 2026 batch/SEAAMS"
$files = Get-ChildItem -Recurse -Filter *.java -Path src | ForEach-Object { $_.FullName }
javac -d out $files
java -cp out com.company.seaams.main.MainApp
```

Once launched, the app presents a menu with options from 1 to 12. Choose the required action and follow the prompts.