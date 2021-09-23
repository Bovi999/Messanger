package Messenger.service;

import Messenger.database.DatabaseClass;
import Messenger.exception.DataNotFoundException;
import Messenger.model.Message;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MessageService {
    
    private final Map<Long, Message> messages = DatabaseClass.getMessages();
    
    public  MessageService() {
        messages.putIfAbsent(1L, new Message(1, "Hello World", "Christian"));
        messages.putIfAbsent(2L, new Message(2, "Hello Bovi", "Christian"));
    }
    
    public List<Message> getAllMessages(){
        return new ArrayList<>(messages.values());
    }
    
    public List<Message> getAllMessagessForYear(int year){
        List<Message> messagesForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for(Message message : messages.values()){
            cal.setTime(message.getCreated());
            if(cal.get(Calendar.YEAR) == year){
                messagesForYear.add(message);
                //Date ate = message.getCreated();
                //ate.getYear();
            }
        }
        return messagesForYear;
    }
    
    public List<Message> getAllMessagesPaginated(int start, int size){
        ArrayList<Message> list = new ArrayList<Message>(messages.values());
        if(start + size > list.size()) return new ArrayList<Message>();
        return list.subList(start, start + size);
    }
    
    public Message getMessage(long id) {
        Message message = messages.get(id);
        if(message == null) throw new DataNotFoundException("Ikechukwu Message does not exist ");
        return message;
    }
    
    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
        
    }
    
    public Message updateMessage(Message message) {
        if (!messages.containsKey(message.getId())) {
            throw new DataNotFoundException("Message with id: " + message.getId() + "Not Found");
        }
        messages.put(message.getId(), message);
        return message;
    }
    
    public Message removeMessage(long id) {
        if (!messages.containsKey(id)) {
            throw new DataNotFoundException("Message with id: " + id + "Not Found");
        }
        return messages.remove(id);
    }
}
