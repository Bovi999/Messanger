
package Messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class ShareResource {
    
    @GET
    public String getShares(){
        return "They are sharing me oh!";
    }
    
}
