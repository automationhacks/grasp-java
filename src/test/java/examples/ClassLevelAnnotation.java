package examples;

import org.testng.annotations.Test;

// Class can be annotated with @Test
// All public methods would be treated as Test methods
@Test
public class ClassLevelAnnotation {

    public void launchRocket() {
        System.out.println("Rocket launched");
    }

    // We can re-annotate certain methods if we need to add additional attributes.
    @Test(groups = {"functest"})
    public void outerSpace() {
        System.out.println("Reached outer space");
    }
}
