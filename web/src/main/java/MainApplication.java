import utility.DatabaseUtils;

import java.util.List;

public class MainApplication {

    public static void main(String[] args) {
        System.out.println("Fetching user details from the database...");

        // Call the getUserDetails method from the DatabaseUtils class
        List<String> userDetails = DatabaseUtils.getUserDetails();

        // Print out each user detail
        for (String detail : userDetails) {
            System.out.println(detail);
        }
    }
}