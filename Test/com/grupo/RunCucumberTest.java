package com.grupo;

import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.*;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.grupo")
public class RunCucumberTest { }





