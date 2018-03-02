package experiments;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

public class YamlReader {

    public static HashMap<String, Object> readYaml(String path) {
        try {
            InputStream input = new FileInputStream(new File(path));
            return new Yaml().load(input);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
