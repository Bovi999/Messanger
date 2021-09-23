package Messenger.service;

import Messenger.database.DatabaseClass;
import Messenger.model.Comment;
import Messenger.model.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {
    
    private Map<Long, Message> messages = DatabaseClass.getMessages();
    
    public List<Comment> getAllComments(long messageId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<Comment>(comments.values());
    }
    
    public Comment getComment(long commentId, long messageId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.get(commentId);
    }
    
    public Comment createComment(Comment comment, long messageId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size() + 1);
        comments.put(comment.getId(), comment);
        return comments.get(comment.getId());
    }

    public Comment updateComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if(comment.getId() <= 0) return null;
        comments.put(comment.getId(), comment);
        return comment;
    }

    public String deleteComment(long commentId, long messageId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comments.remove(commentId);
        return "comment deleted";
    }
    
}
