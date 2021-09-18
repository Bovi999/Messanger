package Messenger.resources;

import Messenger.model.Message;
import Messenger.service.MessageService;
import java.util.List;
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
import javax.ws.rs.core.MediaType;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_XML)
public class MessageResource {

    @Context
    private UriInfo context;
    
    MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }
    
    @Path("/{id}")
    @GET
    public Message getMessage(@PathParam("id") long id) {
        return messageService.getMessage(id);
    }
    
    @POST
    public Message createMessage( Message message){
        return messageService.addMessage(message);
    }

    @Path("{id}")
    @PUT
    public Message updateMessage(@PathParam("id") Long id, Message message) {
        message.setId(id);
        return messageService.updateMessage(message);
    }
    
    @Path("{id}")
    @DELETE
    public void deleteMessage(@PathParam("id") long id){
        messageService.removeMessage(id);
    }
    
    @Path("test")
    @GET
    public String test() {
        return "test";
    }
    
}
