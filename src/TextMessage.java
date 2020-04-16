/*
 * NAME: Yin Lam Lai
 * PID: A115779757
 */
public class TextMessage extends Message {

    // Error message to use in OperationDeniedException
    private static final String EXCEED_MAX_LENGTH =
            "Your input exceeded the maximum length limit.";

    // input validation criteria
    private static final int MAX_TEXT_LENGTH = 1000;

    public TextMessage(User sender, String text) throws OperationDeniedException {
        super(sender);
        if (sender == null || text == null) {
            throw new IllegalArgumentException();
        }
        if (text.length() > MAX_TEXT_LENGTH) {
            throw new OperationDeniedException(EXCEED_MAX_LENGTH);
        } else {
            this.contents = text;
        }


    }

    public String getContents() {
        return getSender().displayName() + " [" + getDate().toString() + "] : " + this.contents;
    }

}
