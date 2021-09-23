package Messenger.service;

import Messenger.database.DatabaseClass;
import Messenger.model.Like;
import Messenger.model.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LikeService {
    
    private Map<Long, Message> messages = DatabaseClass.getMessages();
    
    private Map<Long, Like> likes;
    
    public List<Like> getAllLikes(long messageId){
        likes = messages.get(messageId).getLikes();
        return new ArrayList<>(likes.values());
    }
    
    public Like getLike(long messageId, long likeId){
        likes = messages.get(messageId).getLikes();
        if(!likes.containsKey(likeId)) return null;
        return likes.get(likeId);
    }
    
    public Like createLike (long messageId, Like like){
        likes =  messages.get(messageId).getLikes();
        like.setId(likes.size() + 1);
        likes.put(like.getId(), like);
        return like;
    }
    
    public Like updateLike(long messageId, Like like){
        likes = messages.get(messageId).getLikes();
        if(!likes.containsKey(like.getId())) return null;
        likes.put(like.getId(), like);
        return like;
    }
    
    public String deleteLike(long messageId, long likeId){
        likes = messages.get(messageId).getLikes();
        if(!likes.containsKey(likeId)) return null;
        likes.remove(likeId);
        return "like unliked";
    }
    
}
