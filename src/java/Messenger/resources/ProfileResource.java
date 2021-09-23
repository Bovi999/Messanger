package Messenger.resources;

//<editor-fold defaultstate="collapsed" desc="Imports">
import Messenger.model.Profile;
import Messenger.service.ProfileService;
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
//</editor-fold>

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_XML)
public class ProfileResource {

    @Context
    private UriInfo context;
    
    ProfileService profileService = new ProfileService();

    public ProfileResource() {
    }

    @GET
    public List<Profile> getProfiles() {
        return profileService.getProfiles();
    }
    
    @Path("{username}")
    @GET
    public Profile getProfile(@PathParam("username") String username) {
        return profileService.getProfile(username);
    }
    
    @POST
    public Profile createProfile(Profile profile){
        return profileService.createProfile(profile);
    }

    @Path("/username")
    @PUT
    public Profile updateProfiles(@PathParam("username") String username, Profile profile) {
        profile.setUsername(username);
        return profileService.updateProfile(profile);
    }
    
    @Path("{username}")
    @DELETE
    public String deleteProfiles(@PathParam("username") String username) {
        profileService.deleteProfile((username));
        return "deleted";
    }
}
