package com.grupo;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.ConfigurationParameter;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.grupo.steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
  value = "pretty, html:target/cucumber-report.html, json:target/cucumber.json")
@ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = "camelcase")
public class RunCucumberTest { }
