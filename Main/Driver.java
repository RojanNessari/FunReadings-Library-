//---------------------------------------------------
// Assignment (1)
// Written by: Rojan Nessari with student id:40255637
//---------------------------------------------------
/*
This program models a library system with classes representing library items (books, journals,
media), clients, and interactions between them. It allows clients to lease and return items, tracks
leased items per client, and provides methods to display client and inventory information.
 */
package Main;
//import classes from different packages
import Library.Item;
import Library.Media;
import Library.Book;
import Library.Journal;
import Client.Client;

import java.util.Locale;
import java.util.Scanner;

public class Driver {
    // Method to find the biggest book in an array of books
    public static Book getBigestBook(Book[] bookArray) {
        Book biggestBook = null;
        int maxPages = Integer.MIN_VALUE;

        for (Book book : bookArray) {
            if (book != null && book.getNumOfPage() > maxPages) {
                biggestBook = book;
                maxPages = book.getNumOfPage();
            }
        }

        return biggestBook;
    }
    // Method to make a deep copy of an array of books
    public static Book[] makeCopyOfBooks(Book[] bookArray) {
        Book[] copyArray = new Book[bookArray.length];

        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i] != null) {
                copyArray[i] = new Book(bookArray[i]);
            }
        }

        return copyArray;
    }
    // Predefined method to initialize some items and clients
    public static void predefiend () {
        // Initialization of items and clients
         Item[]itemArray=new Item[100];
        Media[]mediaArray=new Media[100];
        Journal[]journalArray=new Journal[100];
        Book[]bookArray=new Book[100];
        Book item1=new Book("The Great Gatsby","F. Scott Fitzgerald",1925,2000);
        Book item2=new Book("The Great Gatsby","F. Scott Fitzgerald",1925,2000);
        Book item3=new Book("To Kill a Mockingbird","Harper Lee",1960,1000);
        Media item4=new Media("Inception","Christopher Nolan",2010,"video");
        Media item5=new Media("The Godfather","Francis Ford Coppola",1972,"audio");
        Media item6=new Media("The Godfather","Francis Ford Coppola",1972,"audio");
        Journal item7=new Journal( "Nature", "Various", 1869,100);
        Journal item8=new Journal( "Science", "Various", 1880,50);
        Journal item9=new Journal( "New England Journal of Medicine", "Various", 1812,100);
        System.out.println("the information of pre defiend items in the library is as below:\n");
        System.out.println("item1: "+item1+"\n"+"item2: "+item2+"\n"+"item3: "+item3+"\n"+"item4: "+item4+"\n"+"item5: "+item5+"\n"+"item6: "+item6+"\n"+"item7: "+item7+"\n"+"item8: "+item8+"\n"+"item9: "+item9+"\n");
        System.out.println("the information of  predefiend clients  of the library is as below:\n");
        Client client1=new Client("Ali","579-234-2123","Ali@gmail.com");
        Client client2=new Client("Rose","579-645-4525","rose@gmail.com");
        Client client3=new Client("Meli","352-637-1038","Meli@gmail.com");
        System.out.println("client1: "+client1+"\nclient2: "+client2+"\nclient3: "+client3+"\n");
        System.out.println("============================\n");
        System.out.println("the application is going to cheack the equality of items \n");


        if (item1.equals(item2)) {//check the equality of objects
            System.out.println("item 1 and item 2 are equal");
        }
        else {
            System.out.println("item 1 and item 2 are not equal");

        }
        if (item5.equals(item6)) {
            System.out.println("item 5 and item 6 are equal");
        }
        else {
            System.out.println("item 1 and item 2 are not equal");

        }
        if (item1.equals(item4)) {
            System.out.println("item 1 and item 4 are equal");
        }
        else
            System.out.println("item 1 and item 4 are not equal");
        if (item1.equals(item3)) {
            System.out.println("item 1 and item 3 are equal");
        }
        else
            System.out.println("item 1 and item 3 are not equal\n");

        System.out.println("============================\n");// put the items in their array and display the items
        System.out.println("Book items in the library is as below");
        bookArray[0]= item1;
        bookArray[1]= item2;
        bookArray[2]= item3;
        Item.displayInventory(bookArray);
        System.out.println("============================\n");// put the items in their array and display the items
        System.out.println("Media items in the library is as below");
        mediaArray[0]= item4;
        mediaArray[1]= item5;
        mediaArray[2]= item6;
        Item.displayInventory(mediaArray);
        System.out.println("============================\n");// put the items in their array and display the items
        System.out.println("Journal items in the library is as below");
        journalArray[0]= item7;
        journalArray[1]= item8;
        journalArray[2]= item9;
        Item.displayInventory(journalArray);
        System.out.println("============================\n");
        System.out.println("All the  items in the library is as below");
        itemArray=Item.addArray(bookArray,journalArray,mediaArray);// put all the arrays in another array to show all the items in the library
        Item.displayInventory(itemArray);
        System.out.println("============================\n");// print the biggest book
        Book biggestBook = getBigestBook(bookArray);
            System.out.println("Biggest book:\n" + biggestBook);
        System.out.println("============================\n");
        Book[] copyOfBooks = makeCopyOfBooks(bookArray);// copy of the book  with new id
        System.out.println("Copied books:");
        for (Book book : copyOfBooks) {
            if (book != null) {
                System.out.println(book);
            }
        }

    }
    public static  void main(String []args) {
        // Initialization of arrays and variables
        // Scanner object for user input
        Item[] itemArray = new Item[300];
        Media[] mediaArray = new Media[100];
        Journal[] journalArray = new Journal[100];
        Book[] bookArray = new Book[5];
        Client[] clientArray=new Client[50];
        Scanner kb = new Scanner(System.in);
        int user;
        int NumberOfItem=0;
        // Welcome message
        System.out.println("Welcome to the FunReadings Library application");
        while (true) {
            // Menu for the user
            System.out.println();
            System.out.println("please chose from the following options:\n"+
                    "1.show the menu\n"+
                    "2.run the predefined code\n"+
                    "3.exit the program");
            user = kb.nextInt();
            System.out.println();
            if (user == 1) { // Menu loop
                while (true) {
                    // Menu options
                    System.out.println("Menu: ");
                    System.out.println("1. add  items to the library .");
                    System.out.println("2. delete an item in the library .");
                    System.out.println("3. change information of an item .");
                    System.out.println("4. list all items in a specific category");
                    System.out.println("5. print all items");
                    System.out.println("6. add a client");
                    System.out.println("7. edit a client");
                    System.out.println("8.show all the clients of library");
                    System.out.println("9. delet a client");
                    System.out.println("10. lease an item to a client");
                    System.out.println("11.  return an item from a client");
                    System.out.println("12. show all items leased by a client");
                    System.out.println("13. show all leased items");
                    System.out.println("14. Display the biggest books");
                    System.out.println("15. Make a copy of the books ");
                    System.out.println("16. exit the program.");
                    System.out.println();
                    System.out.println(" please enter the number of your request:");
                    user = kb.nextInt();
                    // Switch case for different operations
                    switch (user) {

                        case 1: {// Add items to the library
                            System.out.print("How many item do you want to add: ");// ask the user the number of book that want to insert.
                            int numOfBook = kb.nextInt();
                            if ((Item.findNumberOfCreatedItem() + numOfBook > 100)) {// if number of book that user want to add is more than the Maximum remaining places.
                                System.out.println("Sorry, there is not enough space in the bookstore."
                                        + " Maximum remaining places: " + (100 - Item.findNumberOfCreatedItem()));
                                break;
                            } else if (Item.count < 100) {
                                for (int i = 0; i < numOfBook; i++) {
                                    System.out.println("please answer to the following questions");
                                    System.out.println(" what type of item do you want to add ?(media , journals,book) ");
                                    String type = kb.next();
                                    System.out.println(" what is the name of  " + type);
                                    String name = kb.next();
                                    System.out.println(" what is the author name  of  " + type);
                                    String author = kb.next();

                                    System.out.println(" what is the year of publication of  " + type);
                                    int year = kb.nextInt();
                                    if (type.startsWith("b") || type.startsWith("B")) {
                                        System.out.println(" what is the number of the pages of book ");
                                        int numOfPage = kb.nextInt();
                                        bookArray[Book.index] = new Book(name, author, year, numOfPage);
                                        System.out.println(bookArray[Book.index - 1] + " is added to the library");

                                        NumberOfItem++;
                                    } else if (type.startsWith("J") || type.startsWith("j")) {
                                        System.out.println(" what is the  volume number of Journal? ");
                                        int volumeNum = kb.nextInt();
                                        journalArray[Journal.seriNum] = new Journal(name, author, year, volumeNum);
                                        System.out.println(journalArray[Journal.seriNum - 1] + " is added to the library");
                                        NumberOfItem++;
                                    } else if (type.startsWith("m") || type.startsWith("M")) {
                                        System.out.println(" what is the type of media? ");
                                        String typeOfMedia = kb.next();
                                        mediaArray[Media.seriNum] = new Media(name, author, year, typeOfMedia);
                                        System.out.println(mediaArray[Media.seriNum - 1] + " is added to the library");
                                        NumberOfItem++;
                                    }

                                }// closing for loop
                            }
                            itemArray = Item.addArray(bookArray, journalArray, mediaArray);
                            break;
                        }
                        case 2: { // Delete an item in the library
                            System.out.println("please enter the id of item you want to delete or q to quit");
                            String id = kb.next();
                            id = id.toUpperCase();
                            switch (id.substring(0, 1)) {
                                case "B": {
                                    bookArray = Book.deletItem(bookArray, id);
                                    System.out.println("item with id " + id + " is deleted ");

                                    break;
                                }

                                case "J": {
                                    journalArray = Journal.deletItem(journalArray, id);
                                    System.out.println("item with id " + id + " is deleted ");
                                    break;
                                }
                                case "M": {
                                    mediaArray = Media.deletItem(mediaArray, id);
                                    System.out.println("item with id " + id + " is deleted ");
                                    break;
                                }
                                case"Q": {
                                    break;
                                }


                            }
                            itemArray = Item.addArray(bookArray, journalArray, mediaArray);
                            break;
                        }
                        case 3: { // Change information of an item
                            System.out.println("please enter the id of item you want to change");
                            String id = kb.next();
                            id = id.toUpperCase();
                            do {

                                System.out.print("What information would you like to change?\n"
                                        + "1. author name\n" + "2. year of publication\n" + "3. name of the item\n");

                                if (id.substring(0, 1).equalsIgnoreCase("b")) {
                                    System.out.println("4.number of pages \n" + "5. quit \n" + "Enter your choice \n");

                                } else if (id.substring(0, 1).equalsIgnoreCase("m")) {
                                    System.out.println("4.type of media \n" + "5. quit \n" + "Enter your choice \n");

                                } else if (id.substring(0, 1).equalsIgnoreCase("j")) {
                                    System.out.println("4.volume Number of journal \n" + "5. quit \n" + "Enter your choice \n");


                                }
                                user = kb.nextInt();

                                switch (user) {
                                    case 1: {
                                        System.out.println("What is the new author name?");
                                        String name = kb.next();
                                        for (int i = 0; i < NumberOfItem; i++) {
                                            if (itemArray[i].getId().equals(id)) {
                                                itemArray[i].setAuthorName(name);
                                            }
                                        }

                                        break;
                                    }
                                    case 2: {
                                        System.out.println("What is the new year of publication  ?");
                                        int year = kb.nextInt();
                                        for (int i = 0; i < NumberOfItem; i++) {
                                            if (itemArray[i].getId().equals(id)) {
                                                itemArray[i].setYear(year);
                                            }
                                        }
                                        break;

                                    }
                                    case 3: {
                                        System.out.println("What is the new name of the item ?");
                                        String title = kb.next();
                                        for (int i = 0; i < NumberOfItem; i++) {
                                            if (itemArray[i].getId().equals(id)) {
                                                itemArray[i].setName(title);
                                            }
                                        }
                                        break;
                                    }
                                    case 4: {
                                        if (id.substring(0, 1).equalsIgnoreCase("b")) {
                                            System.out.println("what is the new number of page ?");
                                            int numbOfPage = kb.nextInt();
                                            for (int i = 0; i < NumberOfItem; i++) {
                                                if (itemArray[i].getId().equals(id)) {
                                                    itemArray[i].setNumOfPage(numbOfPage);
                                                }
                                            }
                                            break;
                                        }
                                        if (id.substring(0, 1).equalsIgnoreCase("m")) {
                                            System.out.println("what is the new type of media ?");
                                            String type = kb.next();
                                            for (int i = 0; i < NumberOfItem; i++) {
                                                if (itemArray[i].getId().equals(id)) {
                                                    itemArray[i].setType(type);
                                                }
                                            }
                                            break;
                                        }
                                        if (id.substring(0, 1).equalsIgnoreCase("j")) {
                                            System.out.println("what is the new volume Number of journal ?");
                                            int num = kb.nextInt();
                                            for (int i = 0; i < NumberOfItem; i++) {
                                                if (itemArray[i].getId().equals(id)) {
                                                    itemArray[i].setVolumeNum(num);
                                                }
                                            }
                                            break;
                                        }


                                    }
                                    case 5: {
                                        break;
                                    }


                                }


                            } while (user != 5);
                            break;
                        }
                        case 4: {// List all items in a specific category
                            System.out.println("please chose from the following option :\n" + " which  item of category  do you want to see?\n" +
                                    "1.book\n" + "2.media\n" + "3.journal\n");
                            user = kb.nextInt();
                            switch (user) {
                                case 1: {
                                    Book.displayInventory(bookArray);
                                    if(bookArray==null){
                                        System.out.println("there is no book item in the library");
                                    }
                                    break;
                                }
                                case 2: {
                                    Media.displayInventory(mediaArray);
                                    if(mediaArray==null){
                                        System.out.println("there is no media item in the library");
                                    }
                                    break;
                                }
                                case 3: {
                                    Journal.displayInventory(journalArray);
                                    if(journalArray==null){
                                        System.out.println("there is no journal item in the library");
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                        case 5: {// Print all items
                            System.out.println("all the item in the library is as bellow :");
                            itemArray = Item.addArray(bookArray, journalArray, mediaArray);
                            Item.displayInventory(itemArray);
                            if(itemArray==null){
                                System.out.println("there is no item in the library");
                            }
                            break;
                        }
                        case 6: { // Add a client
                            System.out.println("How many client do you want to add?");
                            user = kb.nextInt();
                            for (int i = 0; i < user; i++) {
                                System.out.println("please enter the name of the client ");
                                String name = kb.next();
                                System.out.println("please enter the phone number of client");
                                String phoneNum = kb.next();
                                System.out.println("please enter the email adrees for client ");
                                String email = kb.next();
                                clientArray[Client.countClient] = new Client(name, phoneNum, email);
                                System.out.println(clientArray[Client.countClient - 1] + " is added to the library");
                            }
                            break;
                        }
                        case 7:{// Edit a client
                            System.out.println("please enter the id of client you want to change its information:");
                            user= kb.nextInt();
                            for (int i=0;i<Client.countClient;i++){
                                if(clientArray[i].getSerialNum()==user){
                                    do {
                                        System.out.println("What information would you like to change?\n" +
                                                "1.name\n" +
                                                "2.phone number\n" +
                                                "3. email adress\n"+
                                                "4. go back to menu");
                                        user = kb.nextInt();
                                        switch (user) {
                                            case 1: {
                                                System.out.println("please enter the new  name of the client ");
                                                String name = kb.next();
                                                clientArray[i].setName(name);
                                                break;
                                            }
                                            case 2: {
                                                System.out.println("please enter the new  phone number of client");
                                                String phoneNum = kb.next();
                                                clientArray[i].setPhoneNum(phoneNum);
                                                break;
                                            }
                                            case 3: {
                                                System.out.println("please enter the  new email adrees for client ");
                                                String email = kb.next();
                                                clientArray[i].setEmail(email);
                                                break;
                                            }
                                            case 4:{
                                                break;
                                            }
                                        }
                                    }while(user!=4);
                                }
                            }
                            break;
                        }
                        case 8:{// Show all the clients of the library
                            System.out.println("all the clients of the library is as below:");
                                Client.displayInventory(clientArray);
                            break;
                        }
                        case 9:{// Delete a client

                                System.out.println("Please enter the id of the client you want to delete or '0' to quit:");
                                int  id = kb.nextInt();
                                if (id!=0) {
                                    for (int i = 0; i < clientArray.length; i++) {
                                        if (clientArray[i] != null && (clientArray[i].getSerialNum()==id)) {
                                            clientArray[i] = null;
                                            System.out.println("Client with id " + id + " deleted successfully.");
                                            break;
                                        }
                                    }
                                }
                                break;

                        }
                        case 10: {// Lease an item to a client
                            System.out.println("Please enter the ID of the client:");
                            int  clientId = kb.nextInt();

                            System.out.println("Please enter the ID of the item to lease:");
                            String itemId = kb.next().toUpperCase();

                            // Find the client and item
                            Client client = null;
                            for (Client c : clientArray) {
                                if (c != null && c.getSerialNum()==clientId) {
                                    client = c;
                                    break;
                                }
                            }

                            Item item = null;
                            for (Item i : itemArray) {
                                if (i != null && i.getId().equals(itemId)) {
                                    item = i;
                                    break;
                                }
                            }

                            if (client == null || item == null) {
                                System.out.println("Client or item not found.");
                            } else if (item.isLeased()) {
                                System.out.println("Item is already leased.");
                            } else {
                                // Lease the item to the client
                                item.leaseItem(client);
                                System.out.println("Item leased successfully.");
                            }
                            break;
                        }
                        case 11: {// Return an item from a client
                            System.out.println("Please enter the ID of the client:");
                            int clientId = kb.nextInt();

                            System.out.println("Please enter the ID of the item to return:");
                            String itemId = kb.next().toUpperCase();

                            // Find the client and item
                            Client client = null;
                            for (Client c : clientArray) {
                                if (c != null && c.getSerialNum() == clientId) {
                                    client = c;
                                    break;
                                }
                            }

                            Item item = null;
                            for (Item i : itemArray) {
                                if (i != null && i.getId().equals(itemId)) {
                                    item = i;
                                    break;
                                }
                            }

                            if (client == null || item == null) {
                                System.out.println("Client or item not found.");
                            } else if (!item.isLeased() || item.getLeasedTo() == null || item.getLeasedTo().getSerialNum() != clientId) {
                                System.out.println("Item is not leased to this client.");
                            } else {
                                // Return the item
                                item.returnItem();
                                System.out.println("Item returned successfully.");
                            }
                            break;
                        }
                        case 12:{ // Show all items leased by a client
                            System.out.println("Enter the client's ID to see the leased items:");
                            int clientId = kb.nextInt();
                            boolean foundClient = false;
                            for (Client client : clientArray) {
                                if (client != null && client.getSerialNum() == clientId) {
                                    foundClient = true;
                                    System.out.println("Items leased by " + client.getName() + ":");
                                    for (Item item : itemArray) {
                                        if (item != null && item.isLeased() && item.getLeasedTo() == client) {
                                            System.out.println(item);
                                        }
                                    }
                                    break;
                                }
                            }
                            if (!foundClient) {
                                System.out.println("Client not found.");
                            }
                            break;
                        }
                        case 13:{// Show all leased items
                            System.out.println("Leased items:");
                            boolean foundLeasedItem = false;
                            for (Item item : itemArray) {
                                if (item != null && item.isLeased()) {
                                    foundLeasedItem = true;
                                    System.out.println(item);
                                }
                            }
                            if (!foundLeasedItem) {
                                System.out.println("No items are currently leased.");
                            }
                            break;
                        }
                        case 14: {// Display the biggest books
                            Book biggestBook = getBigestBook(bookArray);
                            if (biggestBook != null) {
                                System.out.println("Biggest book:\n" + biggestBook);
                            } else {
                                System.out.println("No books are available.");
                            }
                            break;
                        }
                        case 15:{// Make a copy of the books
                            Book[] copyOfBooks = makeCopyOfBooks(bookArray);
                            System.out.println("Copied books:");
                            for (Book book : copyOfBooks) {
                                if (book != null) {
                                    System.out.println(book);
                                }
                            }
                            break;

                        }

                        case 16: { // Exit the program
                            break;

                        }
                    }
                    // Check if the user wants to exit the menu
                    if (user == 16) {
                        break;
                    }

                }


            }
            // Run predefined code
            if (user == 2) {
                predefiend();
            }
            // Exit the program
            if(user==3){
                System.out.println("thanks for using the FunReadings Library application ");
                System.exit(0);

            }
        }//end of loop
    }//end of main
}// end of program


