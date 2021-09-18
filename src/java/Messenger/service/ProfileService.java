package Messenger.service;

import Messenger.database.DatabaseClass;
import Messenger.model.Profile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {
    
    private Map<String, Profile> profiles = DatabaseClass.getProfiles();
    
    public ProfileService (){
        profiles.putIfAbsent("Bovi", new Profile(1, "Bovi", "Christian", "Ajaero"));
        profiles.putIfAbsent("Byte", new Profile(2, "Byte", "sunday", "Ikechukwu"));
        profiles.putIfAbsent("Ikemba", new Profile(3, "Ikemba", "Basten", "Milik"));
    }
    
    public List<Profile> getProfiles(){
        return new ArrayList<Profile>(profiles.values());
    }
    
    public Profile getProfile(String profileName){
       return profiles.get(profileName);
    }
    
    public Profile createProfile(Profile profile){
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getUsername(), profile);
        return profile;
    }
    
    public  Profile updateProfile(Profile profile){
        if(profile.getUsername().isEmpty()) return null;
        profiles.put(profile.getUsername(), profile);
        return profile;
    }
    
    public void deleteProfile(String profileName){
        profiles.remove(profileName);
    }
}
