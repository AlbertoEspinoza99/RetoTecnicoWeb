package com.technicaltest.web.model.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Usuario {


    private   String firtName ;
    private   String middleName ;

    private   String lastName ;

    private   String password ;


    public static List<Usuario> lista(DataTable table){

        List<Usuario> lis=new ArrayList<>();
        List<Map<String,String>> OB=table.asMaps();

        for (Map<String,String> f:OB){

            lis.add(new ObjectMapper().convertValue(f, Usuario.class));

        }

        return lis;

    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
