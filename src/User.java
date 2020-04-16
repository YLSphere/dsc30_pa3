import java.util.ArrayList;

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

    public User(String username, String bio) {
        if (username == null || bio == null) {
            throw new IllegalArgumentException();
        }
        this.username = username;
        this.bio = bio;
        this.rooms = new ArrayList<>();


    }

    public void setBio(String newBio) {
        if (newBio == null) {
            throw new IllegalArgumentException();
        }
        this.bio = newBio;
    }

    public String displayBio() {
        return bio;
    }

    public void joinRoom(MessageExchange me) throws OperationDeniedException {
        if (me == null) {
            throw new IllegalArgumentException();
        }

        if (me.addUser(this) == false) {
            throw new OperationDeniedException(JOIN_ROOM_FAILED);
        } else {
            rooms.add(me);
        }


    }

    public void quitRoom(MessageExchange me) {
        if (me == null) {
            throw new IllegalArgumentException();
        }
        me.removeUser(this);
        rooms.remove(me);
    }

    public MessageExchange createChatRoom(ArrayList<User> users) {
        ChatRoom myRoom = new ChatRoom();
        myRoom.addUser(this);
        for (User n : users) {
            try {
                n.joinRoom(myRoom);
            } catch (OperationDeniedException e) {
                System.out.print(e.getMessage());
            }
        }
        return myRoom;
    }

    public void sendMessage(MessageExchange me, int msgType, String contents) {
        if (msgType != Message.TEXT || msgType != Message.STICKER || msgType != Message.PHOTO) {
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
                if (me.recordMessage(messageSent) == false) {
                    System.out.print(INVALID_MSG_TYPE);
                } else {
                    me.recordMessage(messageSent);
                }

            } else if (msgType == Message.PHOTO){
                PhotoMessage messageSent = new PhotoMessage(this, contents);
                if (me.recordMessage(messageSent) == false) {
                    System.out.print(INVALID_MSG_TYPE);
                } else {
                    me.recordMessage(messageSent);
                }
            } else if (msgType == Message.STICKER){
                StickerMessage messageSent = new StickerMessage(this, contents);
                if (me.recordMessage(messageSent) == false) {
                    System.out.print(INVALID_MSG_TYPE);
                } else {
                    me.recordMessage(messageSent);
                }
            }
        } catch (OperationDeniedException e) {
            System.out.print(e.getMessage());
        }
    }

    public abstract String fetchMessage(MessageExchange me);

    public abstract String displayName();
}
