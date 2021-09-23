package Messenger.model;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Like implements Serializable{
    
    private long id;
    
    private String author;
    
    private Date created;

    public Like() {
    }

    public Like(long id, String author, Date created) {
        this.id = id;
        this.author = author;
        this.created = created;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Like{" + "id=" + id + ", author=" + author + ", created=" + created + '}';
    }
    
    
    
}
