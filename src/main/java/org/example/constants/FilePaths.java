package org.example.constants;

import java.nio.file.Paths;

public class FilePaths {
    private static final String ROOT_PATH = System.getProperty("user.dir");

    // CONFIG PATHS
    public static final String TEST_CONFIG_PATH = Paths.get(ROOT_PATH, "src", "test", "resources", "test-config.properties").toString();
}
