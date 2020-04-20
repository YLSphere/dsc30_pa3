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

public class PremiumUser extends User {

    // instance variable
    private String customTitle;

    /**
     * Constructor for premiumUser
     *
     * @param username the user's username
     * @param bio the user's current bio
     */
    public PremiumUser(String username, String bio) {
        super(username, bio);
    }

    /**
     * Message retriever for a premium user. Premium users can receive all
     * messages no matter what type
     *
     * @param me the current interface(room) that extends User
     * @return combined messages as a string
     */
    public String fetchMessage(MessageExchange me) {
        if (me == null) {
            throw new IllegalArgumentException();
        }
        String returned = "";
        int size = me.getLog().size();
        for (int n = 0; n < size; n++) {
            returned += me.getLog().get(n).getContents();
            if (n != size - 1) {
                returned += "\n";
            }
        }
        return returned;
    }

    /**
     * Creates a new photoRoom that includes certain users by default and creator
     *
     * @param users list of default users that are included
     * @return new photoRoom interface
     */
    public MessageExchange createPhotoRoom(ArrayList<User> users) {
        MessageExchange myRoom = new PhotoRoom();
        myRoom.addUser(this);
        for (User n : users) {
            try {
                if (n != null) {
                    n.joinRoom(myRoom);
                } else {
                    throw new IllegalArgumentException();
                }

            } catch (OperationDeniedException e) {
                System.out.print(e.getMessage());
            }
        }
        return myRoom;
    }

    /**
     * returns the premium user's title and name as a combined string
     */
    public String displayName() {
        return customTitle + " " + username;
    }

    /**
     * changes the premium user's title
     */
    public void setCustomTitle(String newTitle) {
        customTitle = newTitle;
    }
}
