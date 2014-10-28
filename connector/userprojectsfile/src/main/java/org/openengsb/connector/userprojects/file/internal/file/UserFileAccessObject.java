package org.openengsb.connector.userprojects.file.internal.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openengsb.domain.userprojects.model.User;

/**
 * The object providing access to the users file.
 */
public class UserFileAccessObject extends BaseFileAccessObject {

    private static final String USERS_FILE_NAME = "users";

    private final File usersFile;

    public UserFileAccessObject(File mainDir) {
        usersFile = new File(mainDir, USERS_FILE_NAME);
        usersFile.mkdirs();
    }

    public UserFileAccessObject(String mainDirName) {
        this(new File(mainDirName));
    }

    /**
     * Finds all the available users.
     * 
     * @return the list of available users
     */
    public List<User> findAllUsers() {
        List<User> list = new ArrayList<>();
        List<String> usernames;
        try {
            usernames = readLines(usersFile);
        } catch (IOException e) {
            throw new FileBasedRuntimeException(e);
        }
        for (String username : usernames) {
            list.add(new User(username));
        }
        
        return list;
    }

}
