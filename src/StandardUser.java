/*
 * NAME: Yin Lam Lai
 * PID: A115779757
 */

/**
 * Standard user class that extends User
 *
 * @author Yin Lam Lam
 * @since 14/4/2020
 */

public class StandardUser extends User {

    // Message to append when fetching non-text message
    private static final String FETCH_DENIED_MSG =
            "This message cannot be fetched because you are not a premium user.";
    private static final int ONE_TENTH_MESSAGES = 10;


    /**
     * Constructor for StandardUser
     *
     * @param username current user's username
     * @param bio current user's bio
     */
    public StandardUser(String username, String bio) {
        super(username, bio);
    }

    /**
     * Message retrieve by a standard user. They can only receive the latest one tenth
     * of messages and can only receive text messages
     *
     * @param me current interface(room) that extends users
     * @return the returned messages as a combined string
     */
    public String fetchMessage(MessageExchange me) {
        if (me == null) {
            throw new IllegalArgumentException();
        }
        int size = me.getLog().size();
        if (size < ONE_TENTH_MESSAGES) {
            return "";
        }
        int oneTenth = size / ONE_TENTH_MESSAGES;
        String returned = "";
        for (int n = size - oneTenth; n < size; n++) {
            Message message = me.getLog().get(n);
            if (message instanceof PhotoMessage || message instanceof StickerMessage) {
                returned += FETCH_DENIED_MSG;
            } else {
                returned += message.getContents();
            }
            if (n != size - 1) {
                returned += "\n";
            }
        }
        return returned;
    }

    /**
     * returns the user's username
     * @return user's username
     */
    public String displayName() {
        return username;
    }
}
