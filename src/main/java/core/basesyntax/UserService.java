package core.basesyntax;

import core.basesyntax.exception.UserNotFoundException;

public class UserService {

    public int getUserScore(String[] records, String email) {
        int userScope = -1;
        for (String user : records) {
            if (user.matches(email + ".*") && !email.matches(".*[0-9]")) {
                String[] userRecords = user.split(":");
                userScope = Integer.parseInt(userRecords[1]);
            }
        }
        if (userScope == -1) {
            throw new UserNotFoundException("User with given email doesn't exist");
        }
        return userScope;
    }
}
