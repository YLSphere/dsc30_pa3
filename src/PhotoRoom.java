/*
 * NAME: Yin Lam Lai
 * PID: A115779757
 */
import java.util.ArrayList;

public class PhotoRoom implements MessageExchange {

    // instance variables
    private ArrayList<User> users;
    private ArrayList<Message> log;

    public PhotoRoom() {
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
            if (u instanceof PremiumUser) {
                users.add(u);
                return true;
            }
        }
        return false;
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
        if (m instanceof PhotoMessage) {
            log.add(m);
            return true;
        }
        return false;
    }

}
