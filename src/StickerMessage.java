/*
 * NAME: Yin Lam Lai
 * PID: A115779757
 */

/**
 * Premium user class that extends User
 *
 * @author Yin Lam Lam
 * @since 14/4/2020
 */

public class StickerMessage extends Message {

    // instance variable
    private String packName;

    /**
     * Constructor for the stickerMessage class
     *
     * @param sender the message sender
     * @param stickerSource the sticker name and pack name in form stickerName/packName
     * @throws OperationDeniedException when the sender is not a premium user
     */
    public StickerMessage(User sender, String stickerSource) throws OperationDeniedException {
        super(sender);
        if (!(sender instanceof PremiumUser)) {
            throw new OperationDeniedException(DENIED_USER_GROUP);
        }
        if (sender == null || stickerSource == null) {
            throw new IllegalArgumentException();
        }
        String[] unpacked = stickerSource.split("/");
        packName = unpacked[0];
        contents = unpacked[1];
    }

    /**
     * returns the contents of the emssage sent by the sender
     *
     * @return the sent message as a combined string
     */
    public String getContents() {
        return getSender().displayName() + " [" + getDate().toString() + "] : Sticker [" + contents
                + "] from Pack [" + packName + "]";
    }

    /**
     * returns the pack name of the sticker sent
     * @return pack name of sticker sent
     */
    public String getPackName() {

        return packName;
    }
}
