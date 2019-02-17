
import java.util.Arrays;

/**
 * A class to test the Profile class.
 *
 * @author 689591
 */
public class ProfileMain {

    public static void main(String[] args) {
        //Test the setters
        System.out.println("Test set");
        Profile jason = new Profile("Jason", 4, 4, 1999, "Swansea", "UK", "XXX", new String[]{"game", "movie"});
        System.out.println(jason);
        jason.setTown("Cardiff");
        jason.setCountry("US");
        jason.setNationality("YYY");
        jason.setInterestsList(new String[]{"sleep", "drink", "eat"});
        System.out.println(jason);

        //Test the getters
        System.out.println("\nTest get");
        System.out.println("Name: " + jason.getName() + "\nDate Of Birth: " + jason.getDateOfBirth()
                + "\nTown: " + jason.getTown() + "\nCountry: " + jason.getCountry() + "\nNationality: " + jason.getNationality()
                + "\nInterests: " + Arrays.toString(jason.getInterestsList()));

        //Test the methods of friend list
        System.out.println("\nTest friend list");
        Profile jon = new Profile("Jon", 2, 2, 2000, "LS", "EU", "ZZZ", new String[]{"gym", "work"});
        Profile john = new Profile("John", 3, 3, 1988, "LA", "SW", "EEE", new String[]{"party", "sports"});
        jason.addFriend(jon);
        jon.addFriend(jason);
        System.out.println(jason.numOfFriends());
        jason.addFriend(john);
        john.addFriend(jason);
        System.out.println(jason.numOfFriends());
        System.out.println(jason.getFriend(1));
        System.out.println(jason.getFriend(0));
    }
}
