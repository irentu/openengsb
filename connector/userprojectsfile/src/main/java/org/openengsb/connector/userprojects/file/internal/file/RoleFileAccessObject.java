package org.openengsb.connector.userprojects.file.internal.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.openengsb.domain.userprojects.model.Role;

/**
 * The object providing access to the roles file.
 */
public class RoleFileAccessObject extends BaseFileAccessObject {

    private static final String ROLES_FILE_NAME = "roles";

    private final File rolesFile;

    public RoleFileAccessObject(File mainDir) {
        rolesFile = new File(mainDir, ROLES_FILE_NAME);
        rolesFile.mkdirs();
    }

    public RoleFileAccessObject(String mainDirName) {
        this(new File(mainDirName));
    }

    /**
     * Finds all the available roles.
     * 
     * @return the list of available roles
     */
    public List<Role> findAllRoles() {
        List<Role> list = new ArrayList<>();
        List<String> roleStrings;
        try {
            roleStrings = readLines(rolesFile);
        } catch (IOException e) {
            throw new FileBasedRuntimeException(e);
        }
        for (String roleString : roleStrings) {
            String[] substrings = StringUtils.split(roleString, ASSOCIATION_SEPARATOR);
            Role role = new Role(substrings[0]);
            if (substrings.length > 1) {
                role.setRoles(Arrays.asList(StringUtils.split(substrings[1], VALUE_SEPARATOR)));
            }
            list.add(role);
        }
        
        return list;
    }

}
