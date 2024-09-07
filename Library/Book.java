//---------------------------------------------------
// Assignment (1)
// Written by: Rojan Nessari with student id:40255637
//---------------------------------------------------
package Library;

/**
 * Represents a book in the library.
 */
public class Book extends Item {
    private int numOfPage;
    public static int seriNum = 0;
    public static int index = 0;

    // Constructors
    public Book() {
        super();
        serialNum = ++seriNum;
        id = "B" + serialNum;
        index++;
    }

    public Book(String name, String authorName, int year, int numOfPage) {
        super(name, authorName, year);
        this.numOfPage = numOfPage;
        serialNum = ++seriNum;
        id = "B" + serialNum;
        index++;

    }

    public Book(Book book) {
        super(book);
        numOfPage = book.numOfPage;
        serialNum = ++seriNum;
        id = "B" + serialNum;
    }

    //getters and setters
    public int getNumOfPage() {
        return numOfPage;
    }

    @Override
    public void setNumOfPage(int numOfPage) {
        this.numOfPage = numOfPage;
    }
    //Returns a string representation of the book.

    public String toString() {
        return super.toString() + ", ,number of Pages = " + numOfPage + " ";
    }

    //Checks if the book is equal to another object.
// Two books are considered equal if they have the same number of pages.
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))

            return false;

        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return numOfPage == other.numOfPage;
    }

    //Deletes a book from the array of books.
    public static Book[] deletItem(Book[] bookArray, String id) {
        int indexOfItemToDelete = 0;
        while (indexOfItemToDelete < bookArray.length) {

            if (bookArray[indexOfItemToDelete] == null) {
                indexOfItemToDelete++;
                continue;
            }
            if (bookArray[indexOfItemToDelete].getId().equals(id)) {
                break;
            }

            indexOfItemToDelete++;

        }
        if (indexOfItemToDelete == bookArray.length)
            bookArray[indexOfItemToDelete - 1] = null;
        else {

            for (int i = indexOfItemToDelete; i < bookArray.length - 1; i++) {

                if (bookArray[i + 1] == null) {
                    bookArray[i] = null;
                    continue;
                }
                bookArray[i] = new Book(bookArray[i + 1]);
                bookArray[i + 1] = null;

            }

        }

        return bookArray;
    }

    //Displays the inventory of books.
    public static void displayInventory(Book[] book) {
        for (int i = 0; i < book.length; i++) {
            if (book[i] != null)
                System.out.println(book[i]);

        }

    }
}