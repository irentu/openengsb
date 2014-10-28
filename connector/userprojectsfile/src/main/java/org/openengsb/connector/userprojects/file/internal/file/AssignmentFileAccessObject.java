package org.openengsb.connector.userprojects.file.internal.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.openengsb.domain.userprojects.model.Assignment;

/**
 * The object providing access to the assignments file.
 */
public class AssignmentFileAccessObject extends BaseFileAccessObject {

    private static final String ASSIGNMENTS_FILE_NAME = "assignments";

    private final File assignmentsFile;

    public AssignmentFileAccessObject(File mainDir) {
        assignmentsFile = new File(mainDir, ASSIGNMENTS_FILE_NAME);
        assignmentsFile.mkdirs();
    }

    public AssignmentFileAccessObject(String mainDirName) {
        this(new File(mainDirName));
    }

    /**
     * Finds all the available assignments.
     * 
     * @return the list of available assignments
     */
    public List<Assignment> findAllAssignments() {
        List<Assignment> list = new ArrayList<>();
        List<String> assignmentStrings;
        try {
            assignmentStrings = readLines(assignmentsFile);
        } catch (IOException e) {
            throw new FileBasedRuntimeException(e);
        }
        for (String assignmentString : assignmentStrings) {
            Assignment assignment = new Assignment();
            String[] substrings = StringUtils.split(assignmentString, ASSOCIATION_SEPARATOR);
            assignment.setProject(substrings[0]);
            assignment.setUser(substrings[1]);
            if (substrings.length > 2) {
                assignment.setRoles(Arrays.asList(StringUtils.split(substrings[2], VALUE_SEPARATOR)));
            }
            list.add(assignment);
        }
        
        return list;
    }

}
