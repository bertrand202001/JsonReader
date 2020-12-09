package com.javaapi.json.examples;

import javax.json.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;

public class ReadJsonExample {

    public static void main(String a[]){

        File jsonInputFile = new File("./jsonInput.txt");
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Create JsonReader from Json.
            JsonReader reader = Json.createReader(is);
            // Get the JsonObject structure from JsonReader.
            JsonObject empObj = reader.readObject();
            reader.close();
            // read string data
            System.out.println("Emp Name: " + empObj.getString("emp_name"));
            // read integer data
            System.out.println("Emp Id: " + empObj.getInt("emp_id"));
            // read inner json element
            JsonObject addrObj = empObj.getJsonObject("address");
            System.out.println("City: " + addrObj.getString("city"));

            JsonArray direct_reports = (JsonArray) empObj.get("direct_reports");
            System.out.println(direct_reports);
            Iterator<JsonValue> iterator = direct_reports.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
