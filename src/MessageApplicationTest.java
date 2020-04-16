import java.time.LocalDate;
import static org.junit.Assert.*;

import com.sun.tools.doclets.standard.Standard;
import org.junit.*;
public class MessageApplicationTest {
    /*
      Messages defined in starter code. Remember to copy and paste these strings to the
      test file if you cannot directly access them. DO NOT change the original declaration
      to public.
     */
    private static final String INVALID_INPUT =
            "The source path given cannot be parsed as photo.";

    /*
      Global test variables. Initialize them in @Before method.
     */
    PremiumUser marina;
    MessageExchange room;
    StandardUser myron;
    PremiumUser yeet;
    PremiumUser brown;


    /*
      The date used in Message and its subclasses. You can directly
      call this in your test methods.
     */
    LocalDate date = LocalDate.now();

    @Before
    public void setup() {
        marina = new PremiumUser("Marina", "Instructor");
        room = new ChatRoom();
        myron = new StandardUser("Myron", "Student");
        yeet = new PremiumUser("yeet", "Student");
        brown = new PremiumUser("Brown", "Principal");


    }

    /*
      Recap: Assert exception without message
     */
    @Test (expected = IllegalArgumentException.class)
    public void testPremiumUserThrowsIAE() {
        marina = new PremiumUser("Marina", null);
    }

    /*
      Assert exception with message
     */
    @Test
    public void testPhotoMessageThrowsODE() {
        try {
            PhotoMessage pm = new PhotoMessage(marina, "PA02.zip");
            fail("Exception not thrown"); // will execute if last line didn't throw exception
        } catch (OperationDeniedException ode) {
            assertEquals(INVALID_INPUT, ode.getMessage());
        }
    }

    @Test
    public void TextMessageTest() {
        // TEST CONSTRUCTOR EXCEPTIONS
        try {
            TextMessage test1 = new TextMessage(null, "This is a test.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (OperationDeniedException n) {
            System.out.println(n.getMessage());
        }
        // TEST CONSTRUCTOR
        try {
            TextMessage test1 = new TextMessage(myron, "This is a test.");
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());

        }
        try {
            TextMessage test2 = new TextMessage(yeet, "This is a test.");
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());

        }
        try {
            TextMessage test3 = new TextMessage(marina, "This is a test.");
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());

        }

        // TEST GET CONTENTS
        try {
            TextMessage testGetContents = new TextMessage(myron, "This is a test.");
            assertEquals("Myron [" + date + "] : This is a test.", testGetContents.getContents());
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
        try {
            String text = "";
            for (int n = 0; n< 1001; n++) {
                text += "a";
            }
            TextMessage testGetContents = new TextMessage(myron, text);
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void PhotoMessageTest() {

        //CONSTRUCTOR TEST EXCEPTIONS
        try {
            PhotoMessage testFail = new PhotoMessage(myron, "This is a test.");
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
        try {
            PhotoMessage testFail1 = new PhotoMessage(null, "This is a test.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (OperationDeniedException n) {
            System.out.println(n.getMessage());
        }
        try {
            PhotoMessage testFail2 = new PhotoMessage(marina, null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (OperationDeniedException n) {
            System.out.println(n.getMessage());
        }
        try {
            PhotoMessage testFail3 = new PhotoMessage(marina, "PA2.matlab");
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }

        //TEST GET EXTENTION
        try {
            PhotoMessage testGetExtention = new PhotoMessage(marina, "PA2.jpeg");
            assertEquals("jpeg", testGetExtention.getExtension());
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }

        //TEST GET CONTENTS
        try {
            PhotoMessage testGetContents = new PhotoMessage(yeet, "PA2.png");
            yeet.setCustomTitle("Tiktoker");
            assertEquals("Tiktoker yeet [" + date + "] : Picture at PA2.png", testGetContents.getContents());
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }


        //TESTING CONSTRUCTOR
        try {
            PhotoMessage test1 = new PhotoMessage(yeet, "PA2.png");
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
        try {
            PhotoMessage test2 = new PhotoMessage(marina, "PA2.png");
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
        try {
            PhotoMessage test3 = new PhotoMessage(brown, "PA2.png");
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void StickerMessageTest() {
        // TEST CONSTRUCTOR EXCEPTIONS
        try {
            StickerMessage testFail = new StickerMessage(myron, "This is a test.");
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
        try {
            StickerMessage testFail1 = new StickerMessage(null, "This is a test.");
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            StickerMessage testFail2 = new StickerMessage(yeet, null);
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // TEST CONSTRUCTOR
        try {
            StickerMessage test1 = new StickerMessage(yeet, "IfYouSeeThis/SayWassup");
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
        try {
            StickerMessage test2 = new StickerMessage(yeet, "Boku/NoPico");
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
        try {
            StickerMessage test3 = new StickerMessage(yeet, "League/Ashe");
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
        // TEST GET PACK NAME
        try {
            StickerMessage testPackName = new StickerMessage(yeet, "League/AsheVeryHot");
            assertEquals("League", testPackName.getPackName());
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
        // TEST GET CONTENTS
        try {
            StickerMessage testGetContents = new StickerMessage(yeet, "League/TrundleSexy");
            yeet.setCustomTitle("Instagram Model");
            assertEquals("Instagram Model yeet [" + date + "] : Sticker [TrundleSexy] from Pack [League]",
                    testGetContents.getContents());
        } catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
    }
}






