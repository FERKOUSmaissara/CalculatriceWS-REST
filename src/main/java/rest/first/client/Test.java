package rest.first.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class Test {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/CalculatriceWS/rest");

        System.out.println(target.path("hello").request(MediaType.TEXT_PLAIN).get(String.class));
        System.out.println(target.path("hello").request(MediaType.TEXT_XML).get(String.class));
        System.out.println(target.path("hello").request(MediaType.TEXT_HTML).get(String.class));

        System.out.println(target.path("todos").request(MediaType.APPLICATION_JSON).get(String.class));
        System.out.println(target.path("todos/1").request(MediaType.APPLICATION_JSON).get(String.class));

        client.close();
    }
}
