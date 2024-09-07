//---------------------------------------------------
// Assignment (1)
// Written by: Rojan Nessari with student id:40255637
//---------------------------------------------------
package Client;

import Library.Item;// import class Item

/**
 * Represents a client in the library system.
 */
public class Client {

    protected Item Item;// Item associated with the client
    private String name;
    private String phoneNum;
    private String email;
    public static int countClient = 0;

    private int serialNum;

    private Item[] leasedItems = new Item[10];// Array of leased items for the client
    private int leasedItemCount = 0; // Count of leased items for the client

    //constructor
    public Client() {
        serialNum = 1000 + (++countClient);


    }

    public Client(String name, String phoneNum, String email) {
        this.email = email;
        this.name = name;
        this.phoneNum = phoneNum;
        serialNum = 1000 + (++countClient);
    }

    //Copy constructor for Client.
    public Client(Client c) {
        this.email = c.email;
        this.name = c.name;
        this.phoneNum = c.phoneNum;

    }

    // Getters and setters omitted for brevity...
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSerialNum() {
        return serialNum;
    }


    // Checks if the client is equal to another object.
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        return email.equalsIgnoreCase(other.email) && name.equalsIgnoreCase(other.name)
                && phoneNum.equalsIgnoreCase(other.phoneNum);
    }

    //Returns a string representation of the client.
    @Override
    public String toString() {
        return getClass().getName().substring(7) + " name = " + name + ", phone Number = " + phoneNum + ", email adress = " + email + ", client id = " + serialNum;
    }

    //Displays the inventory of clients.
    public static void displayInventory(Client[] client) {
        for (int i = 0; i < client.length; i++) {
            if (client[i] != null) {
                System.out.println(client[i]);
            }
        }

    }

    //Lease an item to the client.
    public void leaseItem(Item item) {
        if (leasedItemCount < leasedItems.length) {
            leasedItems[leasedItemCount] = item;
            leasedItemCount++;
            item.setLeasedByClient(this);
            System.out.println("Item leased: " + item);
        } else {
            System.out.println("Client has reached the maximum limit for leased items.");
        }
    }

    //Return an item leased by the client.
    public void returnItem(Item item) {
        for (int i = 0; i < leasedItems.length; i++) {
            if (leasedItems[i] != null && leasedItems[i].equals(item)) {
                leasedItems[i].setLeasedByClient(null);
                leasedItems[i] = null;
                System.out.println("Item returned: " + item);
                break;
            }
        }
    }

    //Display the items leased by the client.
    public void displayLeasedItems() {
        System.out.println("Leased items for client " + this.getName() + ":");
        for (int i = 0; i < leasedItems.length; i++) {
            if (leasedItems[i] != null) {
                System.out.println(leasedItems[i]);
            }
        }
    }


}






