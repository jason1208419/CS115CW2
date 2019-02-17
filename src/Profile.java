
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class represents a profile of a person in the social network.
 *
 * @author 689591
 */
public class Profile {

    private final String name;
    private final int birthDay;
    private final int birthMonth;
    private final int birthYear;
    private String town;
    private String country;
    private String nationality;
    private String[] interestsList;
    private final ArrayList<Profile> friendsList = new ArrayList<>();

    /**
     * Creates a profile of a person.
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
     */
    public Profile(String name, int birthDay, int birthMonth, int birthYear, String town, String country, String nationality, String[] interests) {
        this.name = name;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.town = town;
        this.country = country;
        this.nationality = nationality;
        this.interestsList = interests;
    }

    /**
     * Gets the town of residence of the person.
     *
     * @return The town of residence of the person.
     */
    public String getTown() {
        return town;
    }

    /**
     * Sets the town of residence of the person.
     *
     * @param town Resets the town of residence of the person.
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * Gets the country of residence of the person.
     *
     * @return The country of residence of the person.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country of the person.
     *
     * @param country Resets the country of the person.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the nationality of the person.
     *
     * @return The nationality of the person.
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the nationality of residence of the person.
     *
     * @param nationality Resets the nationality of residence of the person.
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Gets the interests of the person.
     *
     * @return The interests of the person.
     */
    public String[] getInterestsList() {
        return interestsList;
    }

    /**
     * Sets the interests of the person.
     *
     * @param interestsList Resets the array of interests of the person.
     */
    public void setInterestsList(String[] interestsList) {
        this.interestsList = interestsList;
    }

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the date of birth of the person.
     *
     * @return The date of birth of the person.
     */
    public String getDateOfBirth() {
        return birthDay + "/" + birthMonth + "/" + birthYear;
    }

    /**
     * Adds a friend to the friend list.
     *
     * @param p The profile of the friend which is going to be added.
     */
    public void addFriend(Profile p) {
        for (int i = 0; i < numOfFriends(); i++) {//Go through the arraylist
            if (getFriend(i).equals(p)) {//Don't add the same profile twice
                System.out.println("Friend already exist. " + p.getName() + " didn't add.");
                return;
            }
        }
        friendsList.add(p);
    }

    /**
     * Gets friend i from the list.
     *
     * @param i The position of the list.
     * @return The profile of the friend in position i.
     * @throws ArrayIndexOutOfBoundsException Throws an exception if i is not
     * valid.
     */
    public Profile getFriend(int i) throws ArrayIndexOutOfBoundsException {
        if (i < numOfFriends()) {//return the profile if i is valid
            return friendsList.get(i);
        } else {//Throws an exception if i is not valid
            throw new ArrayIndexOutOfBoundsException("No friend in position " + i);
        }
    }

    /**
     * Returns the number of friends for this profile.
     *
     * @return The number of friends.
     */
    public int numOfFriends() {
        return friendsList.size();
    }

    /**
     * Method to convert a profile to a string.
     *
     * @return The detail of the person.
     */
    @Override
    public String toString() {
        return "\tname: " + name + "\n\tdate of birth: " + getDateOfBirth() + "\n\ttown: " + town + "\n\tcountry: " + country
                + "\n\tnationality: " + nationality + "\n\tinterests: " + Arrays.toString(interestsList) + "\n";
    }
}
