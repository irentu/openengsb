package org.openengsb.connector.userprojects.file.internal.file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * Base class for accessing files.
 */
public abstract class BaseFileAccessObject {

    protected static final String ASSOCIATION_SEPARATOR = ":-:";
    protected static final String VALUE_SEPARATOR = ",";

    protected List<String> readLines(File file) throws IOException {
        return FileUtils.readLines(file);
    }

}
