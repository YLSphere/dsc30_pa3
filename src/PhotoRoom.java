/*
 * NAME: Yin Lam Lai
 * PID: A115779757
 */
import java.util.ArrayList;

/**
 * Premium user class that extends User
 *
 * @author Yin Lam Lam
 * @since 14/4/2020
 */

public class PhotoRoom implements MessageExchange {

    // instance variables
    private ArrayList<User> users;
    private ArrayList<Message> log;

    /**
     * Constructs the users and log array for a new photoroom
     */
    public PhotoRoom() {
        users = new ArrayList<>();
        log = new ArrayList<>();
    }

    /**
     * Returns the message log for the photo room
     */
    public ArrayList<Message> getLog() {
        return log;
    }

    /**
     * Adds users to current room
     *
     * @param u username of a user
     * @return True if the user is successfully added, false if the user is already in the room and
     * or is a standard user
     */
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

    /**
     * Removes a user from current room
     *
     * @param u User to be removed
     */
    public void removeUser(User u) {
        if (users.contains(u)) {
            users.remove(u);
        }
    }

    /**
     * Returns an arraylist of the users in the photoroom
     *
     * @return Array list of current users in a room
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Records a given message onto the log
     *
     * @param m Incoming message from sender
     * @return If message is a photo, record it on log and return true, else false
     */
    public boolean recordMessage(Message m) {
        if (m instanceof PhotoMessage) {
            log.add(m);
            return true;
        }
        return false;
    }

}
