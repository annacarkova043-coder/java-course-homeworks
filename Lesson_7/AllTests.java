import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.DisplayName;

@Suite
@SelectPackages("") // This will run all tests in the default package
@DisplayName("All JUnit 5 Tests for Lesson 7")
public class AllTests {
    // This class is just a container for the test suite
}