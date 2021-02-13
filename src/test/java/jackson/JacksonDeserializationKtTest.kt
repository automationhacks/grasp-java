package jackson

import org.testng.Assert
import org.testng.annotations.Test
import java.io.IOException


class JacksonDeserializationKTTest {
    @Test
    fun whenValidJsonMatchingModel_thenDeserializationSucceeds() {
        val json = """{
                   "username": "Gaurav"
                   }"""
        try {
            val person = KAPIResponse().deserialize(PersonKt::class.java, json)
            Assert.assertEquals(person.userName, "Gaurav")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}