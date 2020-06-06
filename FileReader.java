import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text file
public class FileReader {
    Scanner myReader;

    public FileReader(String file) {


        try {

            File myObj = new File(file);
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String readDataForOneType(String SearchLine, String fate) {
        Scanner word = new Scanner(System.in);
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            if (line.contains(SearchLine)) {
                String[] typeParts = line.split("TYPE");
                String[] secondTypeParts = typeParts[1].split("\\[");
                String[] type = secondTypeParts[1].split("]");
                String[] fnameParts = line.split("FNAME");
                String[] secondFnameParts = fnameParts[1].split("\\[");
                String[] fname = secondFnameParts[1].split("]");
                String[] lnameParts = line.split("LNAME");
                String[] secondLnameParts = lnameParts[1].split("\\[");
                String[] lname = secondLnameParts[1].split("]");
                String[] ageParts = line.split("AGE");
                String[] secondAgeParts = ageParts[1].split("\\[");
                String[] age = secondAgeParts[1].split("]");
                String data = type[0] + " | " + fname[0] + " | " + lname[0] + " | " + age[0];
                return data;
            }
        }
        mainMenu.choseType(word);
        return " ";
    }

    public String readDataWithKidName(String SearchLine, String fate, String name) {
        Scanner word = new Scanner(System.in);
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            if (line.contains(SearchLine)) {
                String[] kidParts = line.split("KFNAME");
                String[] secondKidParts = kidParts[1].split("\\[");
                String[] thirdKidPart = secondKidParts[1].split("]");
                String[] kid = thirdKidPart[0].split("]");
                if (kid.equals(name)) {
                    String[] fnameParts = line.split("FNAME");
                    String[] secondFnameParts = fnameParts[1].split("\\[");
                    String[] fname = secondFnameParts[1].split("]");
                    String[] lnameParts = line.split("LNAME");
                    String[] secondLnameParts = lnameParts[1].split("\\[");
                    String[] lname = secondLnameParts[1].split("]");
                    String[] ageParts = line.split("AGE");
                    String[] secondAgeParts = ageParts[1].split("\\[");
                    String[] age = secondAgeParts[1].split("]");
                    String data = fname[0] + " | " + lname[0] + " | " + age[0];
                    return data;
                }
            }
        }
        mainMenu.choseType(word);
        return " ";
    }

    public String readDataWithTypeSex(String SearchLine, String fate, String programType) {
        Scanner word = new Scanner(System.in);
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            if (line.contains(SearchLine)&&line.contains(programType)) {
                String[] typeParts = line.split("TYPE");
                String[] secondTypeParts = typeParts[1].split("\\[");
                String[] type = secondTypeParts[1].split("]");
                String[] typeTwo = type[0].split("]");
                String[] fnameParts = line.split("FNAME");
                String[] secondFnameParts = fnameParts[1].split("\\[");
                String[] fname = secondFnameParts[1].split("]");
                String[] lnameParts = line.split("LNAME");
                String[] secondLnameParts = lnameParts[1].split("\\[");
                String[] lname = secondLnameParts[1].split("]");
                String[] ageParts = line.split("AGE");
                String[] secondAgeParts = ageParts[1].split("\\[");
                String[] age = secondAgeParts[1].split("]");
                String data = type[0] + " | " + fname[0] + " | " + lname[0] + " | " + age[0];
                    return data;
                }

        }
        mainMenu.selectByTypeAndSex(word);
        return "";
    }

    //lines = bufferedReader.readLine()) != null
}
