package Messenger.resources;

import Messenger.model.Comment;
import Messenger.service.CommentService;
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

@Path("/comments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_XML)
public class CommentResource {

    @Context
    private UriInfo context;
    
    private CommentService commentService = new CommentService();

    public CommentResource() {
    }

    @GET
    public List<Comment> getComments(@PathParam("messageId") long messageId) {
        return commentService.getAllComments(messageId);
    }
    
    @Path("/{commentId}")
    @GET
    public Comment getAComment(@PathParam("commentId") long commentId, @PathParam("messageId") long messageId) {
        return commentService.getComment(commentId, messageId);
    }

    @POST
    public Comment createComment(Comment comment, @PathParam("messageId") long messageId) {
        return commentService.createComment(comment, messageId);
    }
    
    @PUT
    @Path("{commentId}")
    public Comment putXml(@PathParam("commentId") long commentId, @PathParam("messageId") long messageId, Comment comment) {
        comment.setId(commentId);
        return commentService.updateComment(messageId, comment);
    }
    
    @DELETE
    @Path("{commentId}")
    public String deleteComment(@PathParam("commentId") long commentId, @PathParam("messageId") long messageId ){
        return commentService.deleteComment(commentId, messageId);
    }
}
