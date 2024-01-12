package org.example;

public class XMLService implements WebServiceInterface{
    @Override
    public void request(String file) {
        System.out.println("XML Service: "+file);
    }

    @Override
    public void respond(String file) {
        System.out.println("XML Service Response: "+file);
    }
}
