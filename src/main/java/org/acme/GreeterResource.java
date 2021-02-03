package org.acme;

import java.util.Arrays;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/hello")
public class GreeterResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("fill/{index}")
    @Produces(MediaType.TEXT_PLAIN)
    public String fill(@PathParam("index") String index) throws Exception {

        HashMap<String, String> mem = new HashMap<String, String>();
        char[] chars = new char[2 * 1024 * 1024];
        Arrays.fill(chars, 'f');
        mem.put(Math.random() + "", new String(chars));
        System.out.println("Added " + index + "MB");
        return "Added " + index + "MB \n";

    }
}