//---------------------------------------------------
// Assignment (1)
// Written by: Rojan Nessari with student id:40255637
//---------------------------------------------------
package Library;
/**
 * The Journal class represents a journal item in the library.
 * It extends the Item class and adds functionality specific to journals.
 */
public class Journal extends Item {
    private int volumeNum;// Volume number of the journal
    public static int seriNum=0;// Static variable to track the serial number of journals
    /**
     * Default constructor for Journal class.
     * Initializes the journal with default values and increments the serial number.
     */
    public Journal() {
        super();
        serialNum=seriNum++;
        id="J"+serialNum;
    }
/**
 * Parameterized constructor for Journal class.
 * Initializes the journal with specified values and increments the serial number.
 */
    public Journal(String name, String authorName, int year, int volumeNum) {
        super(name, authorName, year);
        this.volumeNum=volumeNum;
        serialNum=++seriNum;
        id="J"+serialNum;
    }
/**
 * Copy constructor for Journal class.
 * Initializes the journal with values copied from another journal object and increments the serial number.
 */
    public Journal(Journal j) {
        super(j);
        volumeNum=j.volumeNum;
        serialNum=++seriNum;
        id="J"+serialNum;
    }
    /**
     * Getter method for retrieving the volume number of the journal.
     *
     * @return The volume number of the journal.
     */
    public int getVolumeNum() {
        return volumeNum;
    }
    /**
     * Setter method for setting the volume number of the journal.
     *
     * @param volumeNum The volume number to be set.
     */
@Override
    public void setVolumeNum(int volumeNum) {
        this.volumeNum = volumeNum;
    }
    /**
     * Returns a string representation of the journal object.
     *
     * @return A string containing the details of the journal.
     */
    public String toString() {
        return super.toString()+", volumeNum= "+volumeNum+" ";
    }
    /**
     * Checks if the journal object is equal to another object.
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Journal other = (Journal) obj;
        return volumeNum == other.volumeNum;
    }
    //Deletes a journal item from the journal array based on its ID.
    public static Journal[] deletItem(Journal[] journalArray,String  id) {
        int indexOfItemToDelete = 0;
        while (indexOfItemToDelete < journalArray.length) {

            if (journalArray[indexOfItemToDelete] == null) {
                indexOfItemToDelete++;
                continue;
            }
            if (journalArray[indexOfItemToDelete].getId().equals(id)) {
                break;
            }

            indexOfItemToDelete++;

        }
        if (indexOfItemToDelete == journalArray.length)
            journalArray[indexOfItemToDelete - 1] = null;
        else {

            for (int i = indexOfItemToDelete; i < journalArray.length - 1; i++) {

                if (journalArray[i + 1] == null) {
                    journalArray[i] = null;
                    continue;
                }
                journalArray[i] = new Journal(journalArray[i + 1]);
                journalArray[i + 1] = null;

            }


        }


        return journalArray;
    }
    //Displays the inventory of journal items.
    public static void displayInventory(Journal[] journals){
        for (int i=0;i<journals.length;i++){
            if(journals[i]!=null)
                System.out.println(journals[i]);
        }
    }
}
