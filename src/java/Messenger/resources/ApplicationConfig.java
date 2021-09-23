
package Messenger.resources;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Messenger.exception.DataNotFoundExceptionMapper.class);
        resources.add(Messenger.resources.CommentResource.class);
        resources.add(Messenger.resources.DemoResource.class);
        resources.add(Messenger.resources.LikeResource.class);
        resources.add(Messenger.resources.MessageResource.class);
        resources.add(Messenger.resources.ProfileResource.class);
        resources.add(Messenger.resources.ShareResource.class);
    }
    
}
