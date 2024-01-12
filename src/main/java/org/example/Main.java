package org.example;

import org.eclipse.jetty.util.Promise;
import spark.Spark;

import java.util.Objects;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        JSONService jsonService = new JSONService();

        Adapter adaptedService = new Adapter(jsonService);

        XMLService xmlService = new XMLService();

        Spark.port(4567);
        Spark.post("/adaptedRequest", (request, response) -> {
           String json = request.body();
           adaptedService.request(json);
            return "Adapter Request Received";
        });

        Spark.post("/adaptedResponse", (request, response) -> {
            String xml = request.body();
            adaptedService.respond(xml);
            return "Adapter Response Received";
        });

        Spark.post("/directXMLRequest",(request,response) -> {
            String xml = request.body();
            xmlService.request(xml);
            return "Direct XML Request Received";
        });

        Spark.post("/directXMLResponse",(request,response) -> {
            String xml = request.body();
            xmlService.respond(xml);
            return "Direct XML Respond Received";
        });


        Spark.post("/directJSONRequest",(request,response) -> {
            String json = request.body();
            int val = Integer.parseInt(request.queryParams("val"));
            jsonService.request(json,val);
            return "Direct JSON Request Received";
        });


        Spark.post("/directJSONResponse",(request,response) -> {
            String json = request.body();
            int val = Integer.parseInt(request.queryParams("val"));
            jsonService.respond(json,val);
            return "Direct JSON Respond Received";
        });

    }
}