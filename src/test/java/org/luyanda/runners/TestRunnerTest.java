package org.luyanda.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.luyanda.steps",
        plugin = {
                "pretty", "com.aventstack.chaintest.plugins.ChainTestCucumberListener:"
        },
        monochrome = true
)

public class TestRunnerTest extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios(){
                return super.scenarios();
        }
}
