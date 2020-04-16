import java.util.ArrayList;

public class PremiumUser extends User {

    // instance variable
    private String customTitle;

    public PremiumUser(String username, String bio) {
        super(username, bio);
    }

    public String fetchMessage(MessageExchange me) {
        if (me == null) {
            throw new IllegalArgumentException();
        }
        String returned = "";
        int size = me.getLog().size();
        for (int n = 0; n< size; n++ ) {
            returned += me.getLog().get(n);
            if (n != size - 1) {
                returned += "\n";
            }
        }
        return returned;
    }

    public MessageExchange createPhotoRoom(ArrayList<User> users) {
        PhotoRoom myRoom = new PhotoRoom();
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

    public String displayName() {
        /* TODO */
        return customTitle + " " + username;
    }

    public void setCustomTitle(String newTitle) {
        customTitle = newTitle;
    }
}
