package com.technicaltest.web.utils;

import com.jayway.jsonpath.JsonPath;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class UtilApp {

    public static void escribirJson(Object jsonObject, String filename) {
        try (FileWriter file = new FileWriter("src/test/resources/jsonData/" + filename + ".json")) {
            file.write(jsonObject.toString());
            System.out.println("Archivo JSON guardado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getJsonValue(String filename, String jsonPath) {
        String ruta="src/test/resources/jsonData/"+filename+ ".json";
        String jValue = "";
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(ruta)));
            jValue = JsonPath.read(contenido, jsonPath);
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo JSON: " + e.getMessage(), e);
        }
        return jValue;
    }



    public static String aleatorio(){

        String abedecario="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder resultado=new StringBuilder();
        Random ramdom=new Random();

        for (int i=0;i<3;i++){
            resultado.append(abedecario.charAt(ramdom.nextInt(abedecario.length())));
        }

        for (int i=0;i<3;i++){
            resultado.append(ramdom.nextInt(9));
        }

        return resultado.toString();

    }





}