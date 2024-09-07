//---------------------------------------------------
// Assignment (1)
// Written by: Rojan Nessari with student id:40255637
//---------------------------------------------------
package Library;
/**
 * Represents a media item in the library, extending the Item class.
 */
public class Media extends Item {
    private String type;
    public static int seriNum=0;
    // Constructors
    public Media() {
        super();
        serialNum=++seriNum;
        id="M"+serialNum;
    }

    public Media(String name, String authorName, int year,String  type) {
        super(name,authorName,year);
        this.type=type;
        serialNum=++seriNum;
        id="M"+serialNum;
    }
    public Media(Media M) {
        super(M);
        type=M.type;
        serialNum=++seriNum;
        id="M"+serialNum;
    }
//setter and getter
    public String getType() {
        return type;
    }
@Override
    public void setType(String type) {
        this.type = type;
    }
    //Returns a string representation of the media item.
    public String toString() {
        return super.toString()+",  type of media = "+type+" ";
    }


//Checks if the media item is equal to another object.
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Media other = (Media) obj;
        return type.equalsIgnoreCase(other.type);
    }
    //Deletes a media item from the media array based on its ID.
    public static Media[] deletItem(Media[] mediaArray,String  id) {
        int indexOfItemToDelete =0;
        while( indexOfItemToDelete< mediaArray.length ){

            if(mediaArray[indexOfItemToDelete] ==null){
                indexOfItemToDelete++;
                continue;
            }
            if(mediaArray[indexOfItemToDelete].getId().equals(id)){
                break;
            }

            indexOfItemToDelete++;

        }
        if(indexOfItemToDelete == mediaArray.length)
            mediaArray[indexOfItemToDelete-1] =null;
        else{

            for( int i = indexOfItemToDelete; i< mediaArray.length-1; i++){

                if(mediaArray[i+1] == null){
                    mediaArray[i] = null;
                    continue;
                }
                mediaArray[i] = new Media(mediaArray[i+1]);
                mediaArray[i+1] = null;

            }

        }


        // {book1, book2, book3, book4, null, null, null} i=2
        //{book1, book2, book4, null, null, null, null} i=3



        return mediaArray;


    }
    //Displays the inventory of media items.
    public static void displayInventory(Media[] media){
        for (int i=0;i<media.length;i++){
            if(media[i]!=null)
                System.out.println(media[i]);
        }
    }

}
