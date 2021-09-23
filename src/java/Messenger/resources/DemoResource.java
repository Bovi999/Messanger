package Messenger.resources;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("demo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DemoResource {

    public DemoResource() {
    }

    //Matrix param are just like the query param but instead of the "?" we make use of ";" 
    @GET
    public String getJSON(@MatrixParam("id") long id) {
        return "Demo Resource " + id;
    }
    
    //Header param are used to access informations contained in the request headers  
    @GET
    @Path("headers")
    public String getHeads(@HeaderParam("Content-Type") String content, @HeaderParam("Authorization") String auth) {
        return "Authorization: " + auth +" " + "Content-Type: " + content;
    }
    
    //Cookie param are used to access informations contained in the cookie  
    @GET
    @Path("cookie")
    public String getCookie(@CookieParam("hobby") String hobby, @CookieParam("love") String love) {
        return "Hobby: " + hobby +" " + "Love: " + love;
    }
    
    //Form param are used to access informations contained in a form. The data gotten is a key, value pair and comes in url encoded format  
    @POST
    @Path("form")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String getForm(@FormParam("hobby") String hobby, @FormParam("love") String love) {
        return "Hobby: " + hobby +" " + "Love: " + love;
    }
    
    //Form param are used to access informations contained in the cookie  
    @POST
    @Path("formdata")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String getFormData(@FormParam("hobby") String hobby, @FormParam("hobby") String love) {
        return "Hobby: " + hobby +" " + "Love: " + love;
    }

    //@Context gives you access to the entire request
    @GET
    @Path("context")
    public String getParamsUsingContext(@Context UriInfo uriInfo) {
       String path = uriInfo.getAbsolutePath().toString();
       return "Path: " + path + " " + uriInfo.getQueryParameters();
    }
    
    @GET
    @Path("httpheaders")
    public String getHeadersUsingContext(@Context HttpHeaders httpHeaders) {
        return httpHeaders.getRequestHeader("Authorization").toString();
    }
    
}
