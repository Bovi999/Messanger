package Messenger.resources;

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
    
    @Path("{profileName}")
    @GET
    public Profile getProfile(@PathParam("profileName") String profileName) {
        return profileService.getProfile(profileName);
    }
    
    @POST
    public Profile createProfile(Profile profile){
        return profileService.createProfile(profile);
    }

    @PUT
    public Profile updateProfiles(Profile profile) {
        return profileService.updateProfile(profile);
    }
    
    @Path("{profileName}")
    @DELETE
    public String deleteProfiles(@PathParam("profileName") String profileName) {
        profileService.deleteProfile((profileName));
        return "deleted";
    }
}
