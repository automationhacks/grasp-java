package experiments;

import java.util.HashMap;

public class App {

    private static JsonUtils json;
    public static HashMap<String, String> bookingData;

    public App() {

    }

    public static void main(String[] args) {

        // Basic example
//        Map<String, Object> yaml = YamlReader.readYaml("src/main/java/experiments/data/test.yml");
//        json = new JsonUtils();
//        String jsonStr = json.convertToJson(yaml);
//        System.out.println(jsonStr);

        String dataPath = "src/main/java/experiments/data/data.yml";
        HashMap<String, Object> data = YamlReader.readYaml(dataPath);

        if (data.containsKey("bookingData")) {
            bookingData = (HashMap<String, String>) data.get("bookingData");
            System.out.println(bookingData);
        }

//        HashMap<String, String> data = new HashMap<String, String>() {
//            {
//                put("originContact", "Gaurav");
//                put("destinationContact", "Singh");
//            }
//        };

        String templatePath = "src/main/java/experiments/data/template.yml";
        TemplateHandler handler = new TemplateHandler();

        String renderedTemplate = handler.renderTemplate(templatePath, bookingData);
        System.out.println(renderedTemplate);



    }
}
