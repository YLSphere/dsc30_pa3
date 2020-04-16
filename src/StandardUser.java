import java.util.ArrayList;
import java.util.List;

public class StandardUser extends User {

    // Message to append when fetching non-text message
    private static final String FETCH_DENIED_MSG =
            "This message cannot be fetched because you are not a premium user.";
    private static final int ONE_TENTH_MESSAGES = 10;

    public StandardUser(String username, String bio) {
        super(username, bio);
    }

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
                returned = returned + FETCH_DENIED_MSG;
            } else {
                returned += message.getContents();
            }
            if (n != size - 1) {
                returned += "\n";
            }
        }
        return returned;
    }

    public String displayName() {
        return username;
    }
}
