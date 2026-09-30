## Smart Employee Asset & Access Management System (SEAAMS)

1. Objective and Overview
   The Smart Employee Asset & Access Management System (SEAAMS) is a robust, console-based enterprise management solution engineered in Java. It handles core human resource records, controls physical hardware inventory tracking (laptops and mobile devices), governs asset allocation workflows, and maintains an internal IT support ticketing pipeline using advanced Object-Oriented Programming (OOP) principles and Java Collections Frameworks.

2. Functional Modules & RequirementsModule A: Personnel & Directory Management (Person, Employee, EmployeeService)Entity Hierarchy: A base class Person encapsulates fundamental attributes (id, name). The Employee class extends Person, introducing attributes for email, salary, department, status (defaulted to "ACTIVE"), and country (defaulted to "INDIA").Duplicate Prevention & Indexing: EmployeeService maintains multiple collections (List for sequence tracking, HashSet for case-insensitive unique email checks, and HashMap for $O(1)$ fast lookups by employee ID). Adding an employee checks both email and ID constraints to reject duplicates.Sorting: Supports sorting directory personnel alphabetically by full name using custom Comparator implementations.

Module B: Hardware Asset Inventory Management (Asset, Laptop, Mobile, AssetService)
Polymorphic Asset Hierarchy: Asset is an abstract base class containing common properties (assetTag, assetName, assetCost, assignedEmployeeId, isAllocated) and an abstract method displayAsset(). Concrete subclasses Laptop and Mobile implement custom display formatting.

Allocation Engine: AssetService manages a central inventory list. It handles tracking, validation checks to prevent double allocations, direct allocations linking assets to employee IDs, and deallocation / return routines.

Module C: Service Request Ticketing Pipeline (ServiceRequest, RequestService)
FIFO Queue Mechanics: Employees can raise IT support requests (ServiceRequest), which are logged with unique request IDs, associated employee IDs, ticket types, and status flags ("OPEN" / "CLOSED").

Queue Processing: Maintained via a Queue (LinkedList), ensuring service tickets are queued, listed, and processed on a First-In-First-Out basis.

Module D: Advanced Collection Navigation Demos (MainApp)
Navigable Set (TreeSet): Demonstrates bounds navigation methods including .lower(), .higher(), .floor(), and .ceiling().

Navigable Map (TreeMap): Illustrates sorted hierarchical key-value mapping with .higherKey(), .lowerKey(), .firstKey(), and .lastKey().

Backed Collection Views (SubMap): Demonstrates live-view sub-window mapping (subMap()) where structural mutations made to the sub-view dynamically reflect on the master report map.


+-----------------------------------------------------------------------------+
| INHERITANCE |
+-----------------------------------------------------------------------------+

       +-------------------+                     +---------------------+
       |      Person       |                     |        Asset        |
       +-------------------+                     +---------------------+
       | # id: int         |                     | # assetTag: String  |
       | # name: String    |                     | # assetName: String |
       +-------------------+                     | # assetCost: double |
                 ^                               | # assignedEmpId: int|
                 | (extends)                     | # isAllocated: bool |
       +-------------------+                     +---------------------+
       |     Employee      |                                ^
       +-------------------+        +-----------------------+-----------------------+
       | - email: String   |        | (extends)                                     | (extends)
       | - salary: double  |        +---------------------+         +---------------------+
       | - department: Str |        |       Laptop        |         |       Mobile        |
       | - status: String  |        +---------------------+         +---------------------+
       | - country: String |        | + displayAsset()    |         | + displayAsset()    |
       +-------------------+        +---------------------+         +---------------------+

+-----------------------------------------------------------------------------+
| SERVICE LAYERS |
+-----------------------------------------------------------------------------+

+--------------------------------+ +----------------------------------+
| EmployeeService | | AssetService |
+--------------------------------+ +----------------------------------+
| - employees: List<Employee> | | - assetInventory: List<Asset> |
| - uniqueEmails: Set<String> | +----------------------------------+
| - employeeMap: Map<Int, Emp> | | + registerInventoryAsset(Asset) |
+--------------------------------+ | + allocateAsset(Tag, EmpId) |
| + addEmployee(Employee): bool | | + deallocateAsset(Tag): bool |
| + displayEmployees() | | + displayAllAssets() |
| + searchEmployee(id): Employee | +----------------------------------+
+--------------------------------> ^
| |
| manages | manages
v v
[ Employee Data ] [ Asset Inventory ]

+--------------------------------+ +----------------------------------+
| RequestService | | MainApp |
+--------------------------------+ +----------------------------------+
| - executionQueue: Queue<Req> | | - requestSequenceCounter: int |
+--------------------------------+ +----------------------------------+
| + raiseRequest(ServiceRequest) | | + main(String[] args) |
| + processNextRequest() | | - executeAdvancedNavigationDemos()|
| + listPendingRequests() | +----------------------------------+
+--------------------------------+
|
v manages
[ Service Tickets ]

+-----------------------------------------------------------------------------+
| UTILITIES & PAYLOADS |
+-----------------------------------------------------------------------------+

+--------------------------------+ +----------------------------------+
| ServiceRequest | | ValidationUtil |
+--------------------------------+ +----------------------------------+
| - requestId: int | | + parseEmployeeId(val): Integer |
| - employeeId: int | | + parseSalary(val): Double |
| - requestType: String | +----------------------------------+
| - status: String |
+--------------------------------+

## Project Structure

```text
src/
└── com/
    └── company/
        └── seaams/
            ├── main/                //  <-- Application entry point and UI controller
            │   └── MainApp.java
            ├── model/               // <-- Plain Old Java Objects (Models / Domain classes)
            │   ├── Person.java
            │   ├── Employee.java
            │   ├── Asset.java
            │   ├── Laptop.java
            │   └── Mobile.java
            ├── service/            // <-- Business logic and data management 
            │   ├── EmployeeService.java
            │   ├── AssetService.java
            │   ├── ServiceRequest.java
            │   └── RequestService.java
            └── util/             //  <-- Helper utilities and validation methods
                └── ValidationUtil.java
```

## Current Status

The application is confirmed to compile and run successfully with the current main file. The menu loads correctly, and the program exits cleanly when option `12` is selected.

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

## Notes

- The project is built around clear domain modeling and collection-based data handling.
- It is suitable for academic use, Java training, and demonstration of OOP and collection concepts.
- The system is currently console-based and does not use a database or graphical interface.
