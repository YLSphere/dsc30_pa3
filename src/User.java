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

public abstract class User {

    // Error message to use in OperationDeniedException
    protected static final String JOIN_ROOM_FAILED =
            "Failed to join the chat room.";
    protected static final String INVALID_MSG_TYPE =
            "Cannot send this type of message to the specified room.";

    // instance variables
    protected String username;
    protected String bio;
    protected ArrayList<MessageExchange> rooms;


    /**
     * Constructor for User class
     *
     * @param username current user's username
     * @param bio current user's bio
     */
    public User(String username, String bio) {
        if (username == null || bio == null) {
            throw new IllegalArgumentException();
        }
        this.username = username;
        this.bio = bio;
        this.rooms = new ArrayList<>();


    }
    /**
     * sets a new bio for current user.
     *
     * @param newBio new bio to be set
     */
    public void setBio(String newBio) {
        if (newBio == null) {
            throw new IllegalArgumentException();
        }
        this.bio = newBio;
    }

    /**
     * Description of method
     *
     * @return the user's current bio as a string
     */
    public String displayBio() {
        return bio;
    }

    /**
     * joins the current user into a room and add's the room to the user's current room arrayList
     *
     * @param me room user is to be added to
     * @throws OperationDeniedException when the user is already in the room
     */
    public void joinRoom(MessageExchange me) throws OperationDeniedException {
        if (me == null) {
            throw new IllegalArgumentException();
        }

        if (!me.addUser(this)) {
            throw new OperationDeniedException(JOIN_ROOM_FAILED);
        } else {
            rooms.add(me);
            me.addUser(this);
        }


    }
    /**
     * removes the user from said room and remoes the room name in the user's room ArrayList
     *
     * @param me room to be removed from
     */
    public void quitRoom(MessageExchange me) {
        if (me == null) {
            throw new IllegalArgumentException();
        }
        me.removeUser(this);
        rooms.remove(me);
    }

    /**
     * Creates a new chat room with initial list of users in it and hte creator
     *
     * @param users initial user's to be added to the room
     * @return returns the new room's name
     */
    public MessageExchange createChatRoom(ArrayList<User> users) {
        MessageExchange myRoom = new ChatRoom();
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
     * sent message by user. If the user is premium, they can
     * send any types of messages, but standard users can only
     * send text messages.
     *
     * @param me room message is to be sent in
     * @param msgType message type defined in Message abstract class
     * @param contents Message contents
     */
    public void sendMessage(MessageExchange me, int msgType, String contents) {
        if (msgType != Message.TEXT & msgType != Message.STICKER & msgType != Message.PHOTO) {
            throw new IllegalArgumentException();
        }
        if (me == null || contents == null) {
            throw new IllegalArgumentException();
        }
        boolean notInRoom = false;
        for (MessageExchange i : this.rooms) {
            if (i == me) {
                notInRoom = true;
                break;
            }
        }
        if (notInRoom = false) {
            throw new IllegalArgumentException();
        }
        try {
            if (msgType == Message.TEXT) {
                TextMessage messageSent = new TextMessage(this, contents);
                if (!me.recordMessage(messageSent)) {
                    System.out.print(INVALID_MSG_TYPE);
                }
            } else if (msgType == Message.PHOTO) {
                PhotoMessage messageSent = new PhotoMessage(this, contents);
                if (!me.recordMessage(messageSent)) {
                    System.out.print(INVALID_MSG_TYPE);
                }

            } else if (msgType == Message.STICKER) {
                StickerMessage messageSent = new StickerMessage(this, contents);
                if (!me.recordMessage(messageSent)) {
                    System.out.print(INVALID_MSG_TYPE);
                }
            }
        } catch (OperationDeniedException e) {
            System.out.print(e.getMessage());
        }
    }
    /**
     * message retrieving method to be implemented in standard and premium user class
     */
    public abstract String fetchMessage(MessageExchange me);

    /**
     * username display method to be implemented in standard and premium user class
     */
    public abstract String displayName();
}
