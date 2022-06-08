package es.stratio.numatesting.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features"},
        glue = {"src/test/java/es/stratio/numatesting/steps"}
        //tags = {"@Tag1"} //include(@)/exclude(@~)
)

public class Runner {
}
