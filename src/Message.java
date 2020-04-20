import java.time.LocalDate;

public abstract class Message {

    // Use these variable names as the msgType argument of sendMessage()
    // DO NOT MODIFY!
    public static final int TEXT    = 1000;
    public static final int PHOTO   = 1001;
    public static final int STICKER = 1002;

    // Error message to use in OperationDeniedException
    protected static final String DENIED_USER_GROUP =
            "This operation is disabled in your user group.";

    // instance variables
    private LocalDate date;
    private User sender;
    protected String contents;

    /**
     * Constructor for the Message abstract class
     *
     * @param sender the sender of the message
     */
    public Message(User sender) {
        this.date = LocalDate.now();
        if (sender == null) {
            throw new IllegalArgumentException();
        } else {
            this.sender = sender;
        }
    }
    /**
     * Returns current date
     * @return current date
     */

    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns sender's username
     * @return current sender
     */
    public User getSender() {
        return sender;
    }

    /**
     * Abstract method implemented in sticker, photo, and text message class
     */
    public abstract String getContents();

}
