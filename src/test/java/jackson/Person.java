package jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

class Person {
    @JsonProperty("username")
    String userName;
}

