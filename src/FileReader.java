
import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class reads a profile file.
 *
 * @author 689591
 */
public class FileReader {

    /**
     * Method to read the file and return a binary search tree of profiles from
     * this file.
     *
     * @param filename The name of the file.
     * @return The tree of profiles from the file.
     */
    public static BST readProfiles(String filename) {
        Scanner in = null;

        File inputFile = new File(filename);

        try {//Open the file
            in = new Scanner(inputFile);
        } catch (FileNotFoundException e) {//Tell the user file does not exist if file not found
            System.out.println("Cannot open " + filename);
            System.exit(0);
        }

        return FileReader.readFileData(in);
    }

    /**
     * Reads the data file used by the program and returns the constructed
     * binary search tree.
     *
     * @param in The scanner of the file.
     * @return The binary search tree represented by the data file.
     */
    private static BST readFileData(Scanner in) {
        BST tree = new BST();
        Profile profile;
        Scanner lineReader;

        while (in.hasNext()) {//Read the next line if it exist
            String line = in.nextLine();
            lineReader = new Scanner(line);
            lineReader.useDelimiter(",");

            try {//Read data in a line and insert the created profile
                profile = readFileLine(lineReader);
                tree.insertProfile(profile);
                //System.out.println("Profile inserted:\n" + profile);
            } catch (InputMismatchException e) {//Tell the user input type is wrong
                System.err.println("Wrong data type inputted!\nError line: " + line + "\n");
            } catch (NoSuchElementException e) {//Tell the user data is missing
                System.err.println("Some input data are missing!\nError line: " + line + "\n");
            }
        }
        in.close();
        return tree;
    }

    /**
     * Reads the data on a line used by the program and returns the
     * constructed profile.
     *
     * @param in The scanner of the file.
     * @return The created profile.
     */
    private static Profile readFileLine(Scanner in) {
        String name = in.next();

        int birthDay = in.nextInt();
        int birthMonth = in.nextInt();
        int birthYear = in.nextInt();

        String town = in.next();
        String country = in.next();
        String nationality = in.next();

        String interests = "";
        if (in.hasNext()) {//Read interests if exist
            interests = in.next();
        }
        String[] interestsList = interests.split(";");

        in.close();

        return createProfile(name, birthDay, birthMonth, birthYear, town, country, nationality, interestsList);
    }

    /**
     * Method to create a profile based on the data read from the file.
     *
     * @param name The name of the person.
     * @param birthDay The day of birth of the person.
     * @param birthMonth The month of birth of the person.
     * @param birthYear The year of birth of the person.
     * @param town The town of residence of the person.
     * @param country The country of residence of the person.
     * @param nationality The nationality of the person.
     * @param interests The array of interests of the person represented in
     * strings.
     * @return The profile to insert.
     */
    private static Profile createProfile(String name, int birthDay, int birthMonth, int birthYear, String town, String country, String nationality, String[] interests) {
        Profile profile = new Profile(name, birthDay, birthMonth, birthYear, town, country, nationality, interests);
        //System.out.println("Profile created: " + profile);
        return profile;
    }
}
