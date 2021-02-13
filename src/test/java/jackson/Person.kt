package jackson

import com.fasterxml.jackson.annotation.JsonProperty

data class PersonKt(@JsonProperty("username") val userName: String)
