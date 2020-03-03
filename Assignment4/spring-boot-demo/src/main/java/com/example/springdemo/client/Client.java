package com.example.springdemo.client;

import com.example.springdemo.server.Server;

import javax.xml.namespace.QName;
import java.net.URL;
import javax.xml.ws.Service;
public class Client {
    public static void main(String[] args) throws Exception {
    URL url = new URL("http://localhost:7779/ws/hello?wsdl");

    //1st argument service URI, refer to wsdl document above
    //2nd argument is service name, refer to wsdl document above
    QName qname = new QName("http://server.springdemo.example.com/", "ImplService");
    Service service = Service.create(url, qname);
    Server server= service.getPort(Server.class);


    System.out.println(server.getActivityData("Sleeping"));
    System.out.println(server.getActivityData("Toileting"));
}


}
