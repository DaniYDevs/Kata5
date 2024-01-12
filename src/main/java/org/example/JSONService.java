package org.example;

public class JSONService {
    public void request(String file, int val){
        System.out.println("Valor: "+val+" JSON Service: "+file);
    }

    public void respond(String file, int val){
        System.out.println("Valor: "+val+" JSON Service Response: "+file);
    }
}
