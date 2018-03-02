package experiments;

import com.hubspot.jinjava.Jinjava;

import java.util.HashMap;

public class TemplateHandler {

    private static Jinjava jinjava;

    public TemplateHandler() {
        jinjava = new Jinjava();
    }

    public static String renderTemplate(String templatePath, HashMap<String, String> data) {
        HashMap<String, Object> templates = YamlReader.readYaml(templatePath);
        String renderedTemplate = null;

        try {
            HashMap<String, Object> outer = (HashMap<String, Object>) templates.get("booking");
            String templateStr = outer.get("makeBooking").toString();

            System.out.println(templateStr);
            System.out.println(data);

            renderedTemplate = jinjava.render(templateStr, data);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return renderedTemplate;
    }
}
