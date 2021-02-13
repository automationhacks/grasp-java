package jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

class APIResponse implements IAPIResponse {
    public <T> T deserialize(Class<T> cls, String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, cls);
    }

    public <T> T deserializeWithIgnore(Class<T> cls, String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        return mapper.readValue(json, cls);
    }
}
