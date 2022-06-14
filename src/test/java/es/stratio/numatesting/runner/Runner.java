package es.stratio.numatesting.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features"},
        glue = {"es/stratio/numatesting/steps"}
        //tags = {"@Tag1"} //include(@)/exclude(@~)
)

public class Runner {

//    public static void main(String[] args) throws Throwable {
//        //String[] arguments = {"--glue", "path/to/glue/code","--glue", "Second/Path/to/glue code", "--tags","@test", path,"--plugin","pretty","--plugin","json:/path/to/report"};
//        String[] arguments = {"--plugin", "html:build/reports/cucumber", "--glue", "es/stratio/numatesting/steps"};
//        io.cucumber.core.cli.Main.main(arguments);
//    }

}
