package org.example.constants;

import org.example.utils.PropertyReader;

import java.util.Optional;

public class EnvVars {
    public static final String RUN_ON = Optional.ofNullable(System.getenv("run_on")).orElse(PropertyReader.getProperty("run_on"));
    public static final String BROWSER = Optional.ofNullable(System.getenv("browser")).orElse(PropertyReader.getProperty("browser"));
    public static final String URL = Optional.ofNullable(System.getenv("url")).orElse(PropertyReader.getProperty("url"));
    public static final String DIMENSIONS = Optional.ofNullable(System.getenv("dimensions")).orElse(PropertyReader.getProperty("dimensions"));
    public static final String SCALE = Optional.ofNullable(System.getenv("scale")).orElse(PropertyReader.getProperty("scale"));
    public static final String IMPLICIT_TIMEOUT = Optional.ofNullable(System.getenv("implicit_timeout")).orElse(PropertyReader.getProperty("implicit_timeout"));
    public static final String EXPLICIT_TIMEOUT = Optional.ofNullable(System.getenv("explicit_timeout")).orElse(PropertyReader.getProperty("explicit_timeout"));
    public static final String BROWSERSTACK_USER = Optional.ofNullable(System.getenv("browserstack_user")).orElse(PropertyReader.getProperty("browserstack_user"));
    public static final String BROWSERSTACK_KEY = Optional.ofNullable(System.getenv("browserstack_key")).orElse(PropertyReader.getProperty("browserstack_key"));
}
