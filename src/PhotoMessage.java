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

public class PhotoMessage extends Message {

    // Error message to use in OperationDeniedException
    private static final String INVALID_INPUT =
            "The source path given cannot be parsed as photo.";

    // input validation criteria
    private static final String[] ACCEPTABLE_EXTENSIONS =
            new String[] {"jpg", "jpeg", "gif", "png", "tif"};
    private static final int EXTENTION_INDEX = 4;

    // instance variable
    private String extension;

    /**
     * constructor for the photoMessage class
     *
     * @param sender user sending the emssage
     * @param photoSource photomessage to be sent. Has to have the extentions
     * listed in ACCEPTABLE_EXTENTIONS
     */
    public PhotoMessage(User sender, String photoSource) throws OperationDeniedException {
        super(sender);
        if (sender == null || photoSource == null) {
            throw new IllegalArgumentException();
        } else if (!(sender instanceof PremiumUser)) {
            throw new OperationDeniedException(DENIED_USER_GROUP);
        }

        boolean isFound = false;
        for (String n : ACCEPTABLE_EXTENSIONS) {
            if (photoSource.substring(photoSource.length()
                    - EXTENTION_INDEX).toLowerCase().contains(n)) {
                isFound = true;
                extension = n;
                break;
            }
        }
        if (isFound) {
            this.contents = photoSource;
        } else {
            throw new OperationDeniedException(INVALID_INPUT);
        }

    }
    /**
     * returns the contents of a photo message sent
     *
     * @return contents of a photo message sent as a string
     */
    public String getContents() {
        return getSender().displayName() + " [" + getDate().toString() + "] : Picture at "
                + contents;
    }
    /**
     * returns the extension of the photo message sent
     *
     * @return the extension of the photo message sent
     */
    public String getExtension() {
        return extension;
    }

}
