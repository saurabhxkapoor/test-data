import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(
        features = { "src/test/resources/validatePriceDisplayedOnTwoPage.feature"},
        glue = { "page", "steps"}
)
public class RunnerTest {


}
