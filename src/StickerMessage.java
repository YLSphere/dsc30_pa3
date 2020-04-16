public class StickerMessage extends Message {

    // instance variable
    private String packName;

    public StickerMessage(User sender, String stickerSource) throws OperationDeniedException {
        super(sender);
        if (sender instanceof PremiumUser == false) {
            throw new OperationDeniedException(DENIED_USER_GROUP);
        }
        if (sender == null || stickerSource == null) {
            throw new IllegalArgumentException();
        }
        String[] unpacked = stickerSource.split("/");
        packName = unpacked[0];
        contents = unpacked[1];
    }

    public String getContents() {
        return getSender().displayName() + " [" + getDate().toString() + "] : Sticker [" + contents
                + "] from Pack [" + packName + "]";
    }

    public String getPackName() {

        return packName;
    }
}
