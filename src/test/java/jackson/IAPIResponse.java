package jackson;

import java.io.IOException;

interface IAPIResponse {
    <T> T deserialize(Class<T> cls, String json) throws IOException;
}
