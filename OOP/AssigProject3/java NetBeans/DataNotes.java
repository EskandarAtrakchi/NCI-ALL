package healthconnect;

import java.io.Serializable;

/**
 *
 * @author Eskandar Atrakchi
 */
class DataNotes implements Serializable {
    private final String text;
    private final int numberReference;

    public DataNotes (String text, int numberReference) {
        this.text = text;
        this.numberReference = numberReference;
    }

    //I will only get the variables 
    //I will let the user set them 
    public String getText() {
        return text;
    }

    public int getNumberReference() {
        return numberReference;
    }

    @Override
    public String toString() {
        return "DataNotes{" +
                "text='" + text + '\'' +
                ", numberReference=" + numberReference +
                '}';
    }
}
