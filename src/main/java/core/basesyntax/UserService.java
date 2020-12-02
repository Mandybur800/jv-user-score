package core.basesyntax;

import core.basesyntax.exception.UserNotFoundException;

public class UserService {

    public int getUserScore(String[] records, String email) {
        int userScope = -1;
        for (String user : records) {
            String[] userRecords = user.split(":");
            if (userRecords[0].equals(email) && !email.matches(".*[0-9]")) {
                return Integer.parseInt(userRecords[1]);
            }
        }
        throw new UserNotFoundException("User with given email doesn't exist");
    }
}
