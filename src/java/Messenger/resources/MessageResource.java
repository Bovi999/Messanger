package Messenger.resources;

import Messenger.beans.MessageFilterBean;
import Messenger.model.Message;
import Messenger.service.MessageService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_XML)
public class MessageResource {

    @Context
    private UriInfo context;
    
    MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start, @QueryParam("size") int size) {
        if(year > 0){
            return messageService.getAllMessagessForYear(year);
        }
        if(start > 0 && size > 0){
            return messageService.getAllMessagessForYear(year);
        }
        
        return messageService.getAllMessages();
    }
    
    @GET
    @Path("beanparam")
    public String getFilterMessages(@BeanParam MessageFilterBean messageFilter) {
        if(messageFilter.getYear() > 0){
            //return messageService.getAllMessagessForYear(messageFilter.getYear());
        }
        if(messageFilter.getStart() > 0 && messageFilter.getSize() > 0){
            //return messageService.getAllMessagesPaginated(messageFilter.getStart(), messageFilter.getSize());
        }
        //return messageService.getAllMessages();
        return messageFilter.getAuth();
    }
    
    @Path("/{messageId}")
    @GET
    public Response getMessage(@PathParam("messageId") long id) {
        Message fetchedMessage = messageService.getMessage(id);
        return Response.status(Status.FOUND).entity(fetchedMessage).build();
    }
    
    @POST
    public Response createMessage( Message message, @Context UriInfo uriInfo) throws URISyntaxException{
        Message newMessage =  messageService.addMessage(message);
        String id = String.valueOf(newMessage.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
        //return Response.status(Status.CREATED).entity(newMessage).build();
        return Response.created(uri).entity(newMessage).build();
    }

    @Path("{messageId}")
    @PUT
    public Message updateMessage(@PathParam("messageId") Long id, Message message) {
        message.setId(id);
        return messageService.updateMessage(message);
    }
    
    @Path("{messageId}")
    @DELETE
    public void deleteMessage(@PathParam("messageId") long id){
        messageService.removeMessage(id);
    }
    
    @Path("coded")
    @GET
    public Response coded() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://8.208.96.127:8080/CodeSales/shop/items");
        Response book = target.request().get(Response.class);
        return book;
    }
    
    @Path("test")
    @GET
    public String test(){
        String path = context.getPath();
        return path;
    }
    
    @Path("{messageId}/comments")
    public CommentResource comments(){
        return new CommentResource();
    }
    
    @Path("{messageId}/likes")
    public LikeResource likes(){
        return new LikeResource();
    }
    
    @Path("{messageId}/shares")
    public ShareResource shares(){
        return new ShareResource();
    }
}
