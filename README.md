
# FunReadings Library Management System

This Java project simulates a library management system for FunReadings Library, which handles books, journals, and media items. The system is intended for library employees to manage items, clients, leases, and returns.

## Project Overview

The project consists of multiple classes that manage library items and clients using object-oriented principles such as inheritance and polymorphism. The system supports several operations, including adding, editing, and deleting items and clients, leasing and returning items, and displaying various reports.

## Features

- **Item Types**: 
  - Books (with a number of pages).
  - Journals (with a volume number).
  - Media (audio, video, or interactive types).
  
- **Client Management**: 
  - Add, edit, or delete client information.
  
- **Lease Management**: 
  - Lease items to clients and return leased items.
  - Show all leased items or items leased by a specific client.

- **Reports**:
  - List all items in a specific category (Books, Journals, Media).
  - Display the biggest book by the number of pages.
  - Make a deep copy of the array of books.
  - Print all items (from all categories).

## Classes and Methods

### Item Classes
- **Book**: Contains attributes such as title, author, ISBN, number of pages, and publication year.
- **Journal**: Contains attributes such as title, author, volume number, and publication year.
- **Media**: Contains attributes such as title, author, media type (audio, video, interactive), and publication year.
  
- Common Methods:
  - Constructors: Default, parameterized, and copy constructors.
  - Accessors and mutators for attributes.
  - `toString()`: Returns a string representation of the item.
  - `equals()`: Compares two items based on relevant attributes (excluding ID).

### Client Class
- Attributes:
  - Client ID, name, phone number, and email.
- Methods:
  - Constructors, accessors, mutators, and string representation methods.

### Library System
- **getBiggestBook()**: Finds the book with the highest number of pages.
- **copyBooks()**: Makes a deep copy of the array of books.
- **Driver Class**: Includes the main program logic, handling user input, and running either the menu-based or predefined scenario for testing.

## Menu Options

When running in menu mode, the system provides the following options:
```
1. Add an item
2. Delete an item
3. Change information of an item
4. List all items in a specific category (book, journal, or media)
5. Print all items
6. Add a client
7. Edit a client
8. Delete a client
9. Lease an item to a client
10. Return an item from a client
11. Show all items leased by a client
12. Show all leased items
13. Display the biggest book
14. Make a copy of the books array
15. Quit
```

## UML Diagram

The project includes a UML diagram representing the inheritance hierarchy between the various classes (Books, Journals, Media, Clients).

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or later.
- An IDE like IntelliJ IDEA, Eclipse, or any other text editor.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/Library-Management-System.git
   ```
2. Compile and run the program using your IDE or terminal.

### Running the Program
1. Compile the Java files:
   ```bash
   javac *.java
   ```
2. Run the driver class:
   ```bash
   java LibrarySystemDriver
   ```

### Testing
You can run the system in two modes:
1. **Menu-driven mode**: Navigate through the menu and perform operations manually.
2. **Pre-defined scenario**: Automatically creates sample items and clients, then performs various operations for testing purposes.

## Author

- **Rojan Nessari**  
  *Concordia University, COMP 249, Winter 2024*
