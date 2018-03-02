package experiments;

import com.google.gson.Gson;

import java.util.Map;

public class JsonUtils {

    private Gson gson;

    public JsonUtils() {
        this.gson = new Gson();
    }

    public String convertToJson(Map map) {
        return gson.toJson(map);
    }
}
