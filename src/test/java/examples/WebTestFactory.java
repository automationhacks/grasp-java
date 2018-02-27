package examples;

import org.testng.annotations.Factory;

public class WebTestFactory {

    /**
     * Factory can generate tests programmatically.
     * It must return an array of Objects wherein each object can be a different classes
     * object
     * @return Object array
     */
    @Factory
    public Object[] createInstances() {
        Object[] instances = new Object[5];

        for (int i = 0; i < 5; i++) {
            // Create a new instance of WebTest and add in instances array
            instances[i] = new WebTest(i * 2);
        }

        return instances;
    }
}
