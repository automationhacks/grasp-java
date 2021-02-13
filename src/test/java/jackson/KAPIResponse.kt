package jackson

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.IOException

class KAPIResponse : IAPIResponse {
    @Throws(IOException::class)
    override fun <T> deserialize(cls: Class<T>, json: String): T {
        val mapper = ObjectMapper().registerKotlinModule()
        return mapper.readValue(json, cls)
    }

    @Throws(IOException::class)
    fun <T> deserializeWithIgnore(cls: Class<T>?, json: String?): T {
        val mapper = ObjectMapper().registerKotlinModule()
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
        return mapper.readValue(json, cls)
    }
}
