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

    public PhotoMessage(User sender, String photoSource) throws OperationDeniedException {
        super(sender);
        if (sender == null || photoSource == null) {
            throw new IllegalArgumentException();
        }
        if (sender instanceof PremiumUser == false) {
            throw new OperationDeniedException(DENIED_USER_GROUP);
        }

        boolean isFound = false;
        for (String n : ACCEPTABLE_EXTENSIONS) {
            if (photoSource.substring(photoSource.length() - EXTENTION_INDEX).toLowerCase().contains(n)) {
                isFound = true;
                extension = n;
                break;
            }
        }
        if (isFound == true) {
            this.contents = photoSource;
        } else {
            throw new OperationDeniedException(INVALID_INPUT);
        }

    }

    public String getContents() {
        return getSender().displayName() + " [" + getDate().toString() + "] : Picture at " + contents;
    }

    public String getExtension() {
        return extension;
    }

}
