package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.security.spec.ECField;

class Adapter implements WebServiceInterface {
    private JSONService jsonService;

    public Adapter(JSONService jsonService) {
        this.jsonService = jsonService;
    }

    @Override
    public void request(String file) {
        String xmlRequest=convertJsonXml(file);
        System.out.println("Adapter Request: "+ xmlRequest);
    }

    private String convertJsonXml(String json) {
        try{
            ObjectMapper jsonMapper = new ObjectMapper();
            JsonNode jsonNode = jsonMapper.readTree(json);

            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.writeValueAsString(jsonNode);
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public void respond(String file) {
        String jsonResponse = convertXmlJson(file);
        System.out.println("Adapter Response: "+ jsonResponse);
    }

    private String convertXmlJson(String xml) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            JsonNode jsonNode = xmlMapper.readTree(xml.getBytes());

            ObjectMapper jsonMapper = new ObjectMapper();
            return jsonMapper.writeValueAsString(jsonNode);
        }catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
