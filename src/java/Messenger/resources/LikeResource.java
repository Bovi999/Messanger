package Messenger.resources;

import Messenger.model.Like;
import Messenger.service.LikeService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/likes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_XML)
public class LikeResource {
    
    LikeService likeService = new LikeService();
    
    @GET
    public List<Like> getLikes(@PathParam("messageId") long messageId){
        return likeService.getAllLikes(messageId); 
    }
    
    @Path("{likeId}")
    @GET
    public Like getLike(@PathParam("messageId") long messageId, @PathParam("likeId") long likeId){
        return likeService.getLike(messageId, likeId);
    }
    
    @POST
    public Like createLike(@PathParam("messageId") long messageId, Like like ){
        return likeService.createLike(messageId, like);
    }
    
    @PUT
    @Path("{likeId}")
    public Like updateLike(@PathParam("messageId") long messageId, @PathParam("likeId") long likeId, Like like ){
        like.setId(likeId);
        return likeService.updateLike(messageId, like);
    }
    
    @DELETE
    @Path("{likeId}")
    public String deleteLike(@PathParam("messageId") long messageId, @PathParam("likeId") long likeId){
        return likeService.deleteLike(messageId, likeId);
    }
 
}
