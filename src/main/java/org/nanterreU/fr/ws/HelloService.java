package org.nanterreU.fr.ws;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@Stateless
@WebService(
        serviceName     = "HelloService",
        portName        = "HelloServicePort",
        targetNamespace = "http://ws.fr.nanterreU.org/"
)
public class HelloService {

    @WebMethod
    public String sayHello(@WebParam(name = "name") String name) {
        return "Hello " + name;
    }
}
