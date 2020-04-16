import java.util.ArrayList;

public class ChatRoom implements MessageExchange {

    // instance variables
    private ArrayList<User> users;
    private ArrayList<Message> log;

    public ChatRoom() {
        users = new ArrayList<>();
        log = new ArrayList<>();
    }

    public ArrayList<Message> getLog() {
        return log;
    }

    public boolean addUser(User u) {
        if (users.contains(u)) {
            return false;
        } else {
            users.add(u);
        }
        return true;
    }

    public void removeUser(User u) {
        if (users.contains(u)) {
            users.remove(u);
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean recordMessage(Message m) {
        log.add(m);
        return true;
    }


}