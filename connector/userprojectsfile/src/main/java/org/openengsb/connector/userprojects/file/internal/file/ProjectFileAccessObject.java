package org.openengsb.connector.userprojects.file.internal.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openengsb.domain.userprojects.model.Project;

/**
 * The object providing access to the projects file.
 */
public class ProjectFileAccessObject extends BaseFileAccessObject {

    private static final String PROJECTS_FILE_NAME = "projects";

    private final File projectsFile;

    public ProjectFileAccessObject(File mainDir) {
        projectsFile = new File(mainDir, PROJECTS_FILE_NAME);
        projectsFile.mkdirs();
    }

    public ProjectFileAccessObject(String mainDirName) {
        this(new File(mainDirName));
    }

    /**
     * Finds all the available projects.
     * 
     * @return the list of available projects
     */
    public List<Project> findAllProjects() {
        List<Project> list = new ArrayList<>();
        List<String> projectNames;
        try {
            projectNames = readLines(projectsFile);
        } catch (IOException e) {
            throw new FileBasedRuntimeException(e);
        }
        for (String projectName : projectNames) {
            list.add(new Project(projectName));
        }
        
        return list;
    }
}
