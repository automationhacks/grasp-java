package experiments;

import com.google.gson.Gson;
import com.hubspot.jinjava.Jinjava;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Standalone {

    public static void main(String[] args) throws FileNotFoundException{

        String template = "{\n" +
                "  \"paymentType\": 3,\n" +
                "  \"deviceToken\": \"\",\n" +
                "  \"collection_location\":\"pickup\",\n" +
                "  \"shipment_method\":\"SameDay\",\n" +
                "  \"routes\":\n" +
                "  [{\n" +
                "    \"originName\": \"\",\n" +
                "    \"originNote\": \"\",\n" +
                "    \"originContactName\": \"{{originContact}}\",\n" +
                "    \"originContactPhone\": \"+917411586355\",\n" +
                "    \"originLatLong\": \"-6.170962,106.859825\",\n" +
                "    \"originAddress\": \"Central Jakarta City\",\n" +
                "    \"destinationName\": \"\",\n" +
                "    \"destinationNote\": \"\",\n" +
                "    \"destinationContactName\": \"{{destinationContact}}\",\n" +
                "    \"destinationContactPhone\": \"+917411586355\",\n" +
                "    \"destinationLatLong\": \"-6.221148,106.823604\",\n" +
                "    \"destinationAddress\": \"South Jakarta City\",\n" +
                "    \"item\": \"Special package\",\n" +
                "    \"storeOrderId\":\"\",\n" +
                "    \"insuranceDetails\":\n" +
                "    {\n" +
                "      \"applied\": \"true\",\n" +
                "      \"fee\": \"2500\",\n" +
                "      \"product_description\": \"PS4 latest\",\n" +
                "      \"product_price\": \"3500000\"\n" +
                "    }\n" +
                "\n" +
                "  }]\n" +
                "}";

        Jinjava jinjava = new Jinjava();

        HashMap<String, String> data = new HashMap<String, String>();
        data.put("name", "Gaurav");
        data.put("originContact", "Origin");
        data.put("destinationContact", "Destination");

        String rendered = jinjava.render(template, data);
        System.out.println(rendered);


    }
}
