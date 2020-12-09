package com.javaapi.json.examples;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class DataReader {

    public static void main(String a[]){

        File jsonInputFile = new File("./DataConfig.json");
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Create JsonReader from Json.
            JsonReader reader = Json.createReader(is);
            // Get the JsonObject structure from JsonReader.
            JsonObject data = reader.readObject();
            reader.close();

            JsonObject site = data.getJsonObject("site");
            String site_name = site.getString("name");
            System.out.println(site_name);

            JsonArray devices = (JsonArray) site.get("devices");
            JsonObject device1 = devices.getJsonObject(1);
            String device1_name = device1.getString("serialNumber");
            String device1_ip = device1.getString("ip");
            String device1_type = device1.getString("type");
            String device1_id = device1.getString("id");
            System.out.println(device1_name);
            System.out.println(device1_ip);
            System.out.println(device1_type);
            System.out.println(device1_id);

            JsonObject job = data.getJsonObject("job");
            JsonArray filedownload = (JsonArray) job.get("fileDownload");
            JsonObject job1 = filedownload.getJsonObject(0);
            String  downloadName1 = job1.getString("downloadName");
            String fileName1 = job1.getString("fileName");
            String packageName1 = job1.getString("packageName");
            String downloadPath1 = job1.getString("downloadPath");
            System.out.println(downloadName1);
            System.out.println(fileName1);
            System.out.println(packageName1);
            System.out.println(downloadPath1);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
