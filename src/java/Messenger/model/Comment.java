package Messenger.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
    
    private long id;
    
    private String message;
    
    private Date created;
    
    private String author;

    public Comment() {
    }

    public Comment(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.created = new Date();
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comment{id=").append(id);
        sb.append(", message=").append(message);
        sb.append(", created=").append(created);
        sb.append(", author=").append(author);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
