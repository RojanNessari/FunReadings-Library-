//---------------------------------------------------
// Assignment (1)
// Written by: Rojan Nessari with student id:40255637
//---------------------------------------------------
package Library;
/**
 * Represents an item in the library, such as a book, journal, or media.
 */

import Client.Client;

public class Item {
    // attributes
    protected String name;
    protected String id;
    protected String authorName;
    protected int year;
    protected int serialNum;
    public static int count = 0;
    private boolean leased = false;
    private Client leasedTo;
    private Client leasedByClient;

    // Constructor
    public Item() {
        count++;
    }

    public Item(String name, String authorName, int year) {
        this.name = name;
        this.authorName = authorName;
        this.year = year;
        count++;
    }

    public Item(Item i) {
        name = i.name;
        authorName = i.authorName;
        year = i.year;
        count++;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Client getLeasedByClient() {
        return leasedByClient;
    }

    public void setLeasedByClient(Client client) {
        this.leasedByClient = client;
    }

    public String getId() {
        return id;
    }

    public void setNumOfPage(int numOfPage) {
    }

    public void setType(String type) {
    }

    public void setVolumeNum(int volumeNum) {
    }

    public boolean isLeased() {
        return leased;
    }

    public Client getLeasedTo() {
        return leasedTo;
    }

    public void leaseItem(Client client) {
        leased = true;
        leasedTo = client;
    }

    public void returnItem() {
        leased = false;
        leasedTo = null;
    }

    //Returns a string representation of the item.
    public String toString() {
        return getClass().getName().substring(8) + " name =" + name + ", id=" + id + ", authorName=" + authorName + ", year=" + year;
    }

    //Checks if the item is equal to another object.
    //Two items are considered equal if they have the same author name, name, and year.
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Item other = (Item) obj;
        return (authorName.equalsIgnoreCase(other.authorName)) && (name.equalsIgnoreCase(other.name)) && (year == other.year);
    }

    //Displays the inventory of items.
    public static void displayInventory(Item[] item) {
        for (int i = 0; i < item.length; i++) {
            if (item[i] != null)
                System.out.println(item[i]);
        }
    }

    //Finds the total number of created items.
    public static int findNumberOfCreatedItem() {
        return count + 1;
    }

    //Combines arrays of books, journals, and media items into a single array of items.
    public static Item[] addArray(Book[] book, Journal[] journal, Media[] media) {
        Item[] item = new Item[book.length + journal.length + media.length];
        int index = 0;
        for (int i = 0; i < book.length; i++) {
            if (book[i] != null) {
                item[index] = book[i];
                index++;
            }
        }
        for (int i = 0; i < journal.length; i++) {
            if (journal[i] != null) {
                item[index] = journal[i];
                index++;
            }
        }
        for (int i = 0; i < media.length; i++) {
            if (media[i] != null) {
                item[index] = media[i];
                index++;
            }
        }
        return item;
    }


}
