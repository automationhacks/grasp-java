package experiments.exp1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TemplateExp {
    public static void main(String[] args) {

        File ymlFile = new File("src/main/java/experiments/exp1/client.yml");
        try (InputStream in = new FileInputStream(ymlFile)) {
            Yaml yml = new Yaml();
            Map mapping = yml.load(in);


            String json = mapping.get("consumer_instant").toString();

            Gson gson = new Gson();
            Map body = gson.fromJson(json, Map.class);
            System.out.println(body);


            System.out.println(mapping);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
