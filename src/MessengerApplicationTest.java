/*
 * NAME: Yin Lam Lai
 * PID: A115779757
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * Premium user class that extends User
 *
 * @author Yin Lam Lam
 * @since 14/4/2020
 */

public class MessengerApplicationTest {
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
    MessageExchange room1;
    MessageExchange room2;
    MessageExchange room3;
    StandardUser myron;
    StandardUser peppapig;
    StandardUser aidan;
    PremiumUser jesseKim;
    PremiumUser brown;
    MessageExchange photoRoomTest;


    /*
      The date used in Message and its subclasses. You can directly
      call this in your test methods.
     */
    LocalDate date = LocalDate.now();

    @Before
    public void setup() {
        marina = new PremiumUser("Marina", "Instructor");
        room = new ChatRoom();
        room1 = new ChatRoom();
        room2 = new ChatRoom();
        room3 = new ChatRoom();
        photoRoomTest = new PhotoRoom();
        myron = new StandardUser("Myron", "Student");
        aidan = new StandardUser("Aidan", "Student");
        peppapig = new StandardUser("Peppa Pig", "Movie actress");
        jesseKim = new PremiumUser("jesseKim", "Student");
        brown = new PremiumUser("Brown", "Principal");


    }

    /*
      Recap: Assert exception without message
     */
    @Test(expected = IllegalArgumentException.class)
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

    // MESSAGE TEST
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
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());

        }
        try {
            TextMessage test2 = new TextMessage(jesseKim, "This is a test.");
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());

        }
        try {
            TextMessage test3 = new TextMessage(marina, "This is a test.");
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());

        }

        // TEST GET CONTENTS
        try {
            TextMessage testGetContents = new TextMessage(myron, "This is a test.");
            assertEquals("Myron [" + date + "] : This is a test.", testGetContents.getContents());
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }
        try {
            String text = "";
            for (int n = 0; n < 1001; n++) {
                text += "a";
            }
            TextMessage testGetContents = new TextMessage(myron, text);
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void PhotoMessageTest() {

        //CONSTRUCTOR TEST EXCEPTIONS
        try {
            PhotoMessage testFail = new PhotoMessage(myron, "This is a test.");
        } catch (OperationDeniedException e) {
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
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }

        //TEST GET EXTENTION
        try {
            PhotoMessage testGetExtention = new PhotoMessage(marina, "PA2.jpeg");
            assertEquals("jpeg", testGetExtention.getExtension());
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }

        //TEST GET CONTENTS
        try {
            PhotoMessage testGetContents = new PhotoMessage(jesseKim, "PA2.png");
            jesseKim.setCustomTitle("Tiktoker");
            assertEquals("Tiktoker jesseKim [" + date + "] : Picture at PA2.png", testGetContents.getContents());
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }


        //TESTING CONSTRUCTOR
        try {
            PhotoMessage test1 = new PhotoMessage(jesseKim, "PA2.png");
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }
        try {
            PhotoMessage test2 = new PhotoMessage(marina, "PA2.png");
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }
        try {
            PhotoMessage test3 = new PhotoMessage(brown, "PA2.png");
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void StickerMessageTest() {
        // TEST CONSTRUCTOR EXCEPTIONS
        try {
            StickerMessage testFail = new StickerMessage(myron, "This is a test.");
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }
        try {
            StickerMessage testFail1 = new StickerMessage(null, "This is a test.");
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            StickerMessage testFail2 = new StickerMessage(jesseKim, null);
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // TEST CONSTRUCTOR
        try {
            StickerMessage test1 = new StickerMessage(jesseKim, "IfYouSeeThis/SayWassup");
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }
        try {
            StickerMessage test2 = new StickerMessage(jesseKim, "Boku/NoPico");
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }
        try {
            StickerMessage test3 = new StickerMessage(jesseKim, "League/Ashe");
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }
        // TEST GET PACK NAME
        try {
            StickerMessage testPackName = new StickerMessage(jesseKim, "League/AsheVeryHot");
            assertEquals("League", testPackName.getPackName());
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }
        // TEST GET CONTENTS
        try {
            StickerMessage testGetContents = new StickerMessage(jesseKim, "League/TrundleSexy");
            jesseKim.setCustomTitle("Instagram Model");
            assertEquals("Instagram Model jesseKim [" + date + "] : Sticker [TrundleSexy] from Pack [League]",
                    testGetContents.getContents());
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }
    }

    // USER TESTS
    @Test
    public void setBioTest() {
        //SET BIO TEST
        myron.setBio("Wood 4 trash");
        //DISPLAY BIO TEST
        assertEquals("Wood 4 trash", myron.displayBio());

        //SET BIO EXCEPTION TEST
        try {
            marina.setBio(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void joinRoomTest() {
        //  JOINROOM TEST
        try {
            myron.joinRoom(room);
            marina.joinRoom(room);
            assertEquals(2, room.getUsers().size());
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }
        try {
            myron.joinRoom(room1);
            marina.joinRoom(room1);
            assertEquals(myron, room1.getUsers().get(0));
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }
        try {

            myron.joinRoom(room2);
            marina.joinRoom(room2);
            jesseKim.joinRoom(room2);
            assertEquals(3, room2.getUsers().size());
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }

        //  JOINROOM EXCEPTION TEST
        try {
            myron.joinRoom(room3);
            myron.joinRoom(room3);
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        }
        try {
            myron.joinRoom(null);
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException n) {
            System.out.println("Room is Null");
        }
    }

    @Test
    public void quitRoomTest() {
        //  QUITROOM TEST
        try {
            marina.joinRoom(room);
            myron.joinRoom(room);
            myron.quitRoom(room);
            myron.quitRoom(room);
            assertEquals(1, room.getUsers().size());
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException n) {
            System.out.println("Room is Null");
        }
        try {
            myron.quitRoom(room1);
            myron.quitRoom(room1);
            assertEquals(0, room1.getUsers().size());
        } catch (IllegalArgumentException n) {
            System.out.println("Room is Null");
        }
        try {
            myron.joinRoom(room2);
            jesseKim.joinRoom(room2);
            myron.quitRoom(room2);
            jesseKim.quitRoom(room2);
            assertEquals(0, room2.getUsers().size());
        } catch (OperationDeniedException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException n) {
            System.out.println("Room is Null");
        }

        //  QUITROOM EXCEPTION TEST
        try {
            myron.quitRoom(null);
        } catch (IllegalArgumentException n) {
            System.out.println("Room is Null");
        }
    }

    @Test
    public void createChatRoomTest() throws OperationDeniedException {
        // CREATE CHAT ROOM TESTS
        ArrayList<User> test = new ArrayList<>(Arrays.asList(myron, marina, jesseKim));
        MessageExchange testRoom1 = brown.createChatRoom(test);
        assertEquals(4, testRoom1.getUsers().size());

        MessageExchange testRoom2 = myron.createChatRoom(test);
        assertEquals(3, testRoom2.getUsers().size());

        MessageExchange testRoom3 = marina.createChatRoom(test);
        myron.quitRoom(testRoom3);
        brown.joinRoom(testRoom3);
        assertEquals(3, testRoom3.getUsers().size());

        // CREATE CHAT ROOM EXCEPTION TESTS
        ArrayList<User> test1 = new ArrayList<>(Arrays.asList(myron, null, jesseKim));
        try {
            MessageExchange testRoom4 = brown.createChatRoom(test1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void sendMessageTest() throws OperationDeniedException {
        // EXCEPTION TEST
        try {
            myron.joinRoom(room);
            myron.sendMessage(room, 123, "Hello");
        } catch (IllegalArgumentException e) {
            System.out.println("Inputs incorrect!");
        }
        try {
            myron.joinRoom(room1);
            myron.sendMessage(null, 1001, "Hello");
        } catch (IllegalArgumentException e) {
            System.out.println("Inputs incorrect!");
        }
        try {
            myron.joinRoom(room2);
            myron.sendMessage(room2, 1001, null);
        } catch (IllegalArgumentException e) {
            System.out.println("Inputs incorrect!");
        }
        MessageExchange photoRoom1 = new PhotoRoom();
        marina.joinRoom(photoRoom1);
        marina.sendMessage(photoRoom1, 1000, "Hello");


        // TEST
        myron.joinRoom(room3);
        marina.joinRoom(room3);
        myron.sendMessage(room3, 1000, "Hello");
        marina.sendMessage(room3, 1001, "Hello.png");
        assertEquals("Myron [" + date + "] : Hello" + "\n" +
                "null Marina [" + date + "] : Picture at Hello.png", marina.fetchMessage(room3));

        marina.joinRoom(room1);
        marina.sendMessage(room1, 1002, "DSC30/PLZ_DO_PAS");
        assertEquals("null Marina [" + date + "] : Sticker [PLZ_DO_PAS] from Pack [DSC30]",
                marina.fetchMessage(room1));

        marina.joinRoom(photoRoomTest);
        marina.sendMessage(photoRoomTest, 1001, "hello.zip");
    }

    @Test
    public void standardUserTest() throws OperationDeniedException {
        // CONSTRUCTOR TEST
        assertEquals("Aidan", aidan.displayName());
        assertEquals("Peppa Pig", peppapig.displayName());
        assertEquals("Movie actress", peppapig.displayBio());

        // FETCH MESSAGE TEST
        myron.joinRoom(room3);
        myron.sendMessage(room3, 1000, "This is a test");

        assertEquals("", myron.fetchMessage(room3));

        myron.joinRoom(room1);
        for (int n = 0; n < 10; n++) {
            myron.sendMessage(room1, 1000, "ashe is so hot dude legit");
        }
        assertEquals("Myron [" + date + "] : ashe is so hot dude legit", myron.fetchMessage(room1));

        myron.joinRoom(room2);
        for (int n = 0; n < 10; n++) {
            myron.sendMessage(room2, 1000, "ashe is so hot dude legit");
        }
        myron.sendMessage(room2, 1000, "bro nah actually teemo man... scrumptious");
        assertEquals("Myron [" + date + "] : bro nah actually teemo man... scrumptious",
                myron.fetchMessage(room2));

        myron.joinRoom(room);
        marina.joinRoom(room);
        for (int n = 0; n < 10; n++) {
            myron.sendMessage(room, 1000, "ashe is so hot dude legit");
        }
        myron.sendMessage(room, 1000, "bro nah actually teemo man... scrumptious");
        marina.sendMessage(room, 1002, "League_Moe/TRUEEEEE");
        assertEquals("This message cannot be fetched because you are not a premium user.",
                myron.fetchMessage(room));

        // FETCH MESSAGE EXCEPTION TEST
        try {
            marina.fetchMessage(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Input is null!");
        }

        // DISPLAY NAME TEST
        assertEquals("Myron", myron.displayName());
    }

    @Test
    public void premiumUserTest() throws OperationDeniedException {
        // CONSTRUCTOR TEST
        assertEquals("null Brown", brown.displayName());
        assertEquals("null Marina", marina.displayName());
        assertEquals("Instructor", marina.displayBio());

        // FETCH MESSAGE TEST
        marina.joinRoom(room);
        marina.sendMessage(room, 1001, "10KillFortniteWin.png");
        assertEquals("null Marina [" + date + "] : Picture at 10KillFortniteWin.png"
                , marina.fetchMessage(room));

        jesseKim.joinRoom(room1);
        marina.joinRoom(room1);
        marina.sendMessage(room1, 1001, "15KillFortniteWin.png");
        jesseKim.sendMessage(room1, 1002, "FortniteFriedMemes/DefaultDanceXD");
        assertEquals("null Marina [" + date + "] : Picture at 15KillFortniteWin.png" + "\n"
                        + "null jesseKim [" + date + "] : Sticker [DefaultDanceXD] from Pack [FortniteFriedMemes]"
                , marina.fetchMessage(room1));

        myron.joinRoom(room2);
        marina.joinRoom(room2);
        String equates = "";
        for (int n = 0; n < 10; n++) {
            equates += "Myron [" + date + "] : ashe is so hot dude legit" + "\n";
            myron.sendMessage(room2, 1000, "ashe is so hot dude legit");
        }

        marina.sendMessage(room2, 1000, "Please stop this is a class discussion forum.");
        equates += "null Marina [" + date + "] : Please stop this is a class discussion forum." + "\n";
        myron.sendMessage(room2, 1000, "bro nah actually teemo man... scrumptious");
        equates += "Myron [" + date + "] : bro nah actually teemo man... scrumptious" + "\n";
        marina.sendMessage(room2, 1002, "League_Moe/TRUEEEEE");
        equates += "null Marina [" + date + "] : Sticker [TRUEEEEE] from Pack [League_Moe]";
        assertEquals(equates, marina.fetchMessage(room2));


        // FETCH MESSAGE EXCEPTION TEST
        try {
            marina.fetchMessage(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Input is null!");
        }

        // CREATE PHOTO ROOM TEST
        ArrayList<User> testPhoto = new ArrayList<>(Arrays.asList(myron, marina, jesseKim));

        MessageExchange testRoom1 = brown.createPhotoRoom(testPhoto);
        assertEquals(3, testRoom1.getUsers().size());

        MessageExchange testRoom2 = marina.createPhotoRoom(testPhoto);
        assertEquals(2, testRoom2.getUsers().size());

        MessageExchange testRoom3 = marina.createPhotoRoom(testPhoto);
        brown.joinRoom(testRoom3);
        assertEquals(3, testRoom3.getUsers().size());

        // CREATE Photo ROOM EXCEPTION TESTS
        ArrayList<User> test1 = new ArrayList<>(Arrays.asList(myron, null, jesseKim));
        try {
            MessageExchange testRoom4 = brown.createChatRoom(test1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // DISPLAY NAME TEST
        assertEquals("null Marina", marina.displayName());

        // SET CUSTOM TITLE TEST
        marina.setCustomTitle("<Fortnite Streamer>");
        assertEquals("<Fortnite Streamer> Marina", marina.displayName());
    }

    @Test
    public void chatRoomTest() throws OperationDeniedException{
        // CONSTRUCTOR TEST
        MessageExchange test1 = new ChatRoom();
        MessageExchange test2 = new ChatRoom();
        MessageExchange test3 = new ChatRoom();

        assertEquals(0, test1.getUsers().size());
        assertEquals(0, test2.getUsers().size());
        assertEquals(0, test3.getLog().size());

        // GET LOG TEST
        myron.joinRoom(test1);
        myron.sendMessage(test1, 1000, "Meow purr purr");
        assertEquals("Myron [" + date + "] : Meow purr purr",test1.getLog().get(0).getContents());

        // ADD USER TEST
        assertTrue(test2.addUser(jesseKim));
        assertTrue(test2.addUser(myron));
        assertFalse(test2.addUser(myron));

        // REMOVE USER TEST
        test2.removeUser(jesseKim);
        test2.removeUser(myron);
        assertEquals(0, test2.getUsers().size());

        test2.removeUser(myron);
        assertEquals(0, test2.getUsers().size());

        test2.removeUser(marina);
        assertEquals(0, test2.getUsers().size());

        // GET USERS TEST
        myron.joinRoom(test3);
        assertEquals("Myron", test3.getUsers().get(0).username);

        // RECORD MESSAGE TEST
        TextMessage test1text = new TextMessage(myron, "Meow purr purr");
        TextMessage test2text = new TextMessage(myron, "help my soul");
        PhotoMessage test3text = new PhotoMessage(marina, "i_need_sleep.png");
        test3.recordMessage(test1text);
        test3.recordMessage(test2text);
        test3.recordMessage(test3text);
        assertEquals(3, test3.getLog().size());
    }

    @Test
    public void photoRoomTest() throws OperationDeniedException {
        // CONSTRUCTOR TEST
        MessageExchange test1 = new PhotoRoom();
        MessageExchange test2 = new PhotoRoom();
        MessageExchange test3 = new PhotoRoom();

        assertEquals(0, test1.getUsers().size());
        assertEquals(0, test2.getUsers().size());
        assertEquals(0, test3.getLog().size());

        // GET LOG TEST
        marina.joinRoom(test1);
        marina.sendMessage(test1, 1001, "GoldenScar!!!.png");
        assertEquals("null Marina [" + date + "] : Picture at GoldenScar!!!.png"
                ,test1.getLog().get(0).getContents());

        // ADD USER TEST
        assertTrue(test2.addUser(jesseKim));
        assertTrue(test2.addUser(brown));
        assertFalse(test2.addUser(brown));

        // REMOVE USER TEST
        test2.removeUser(jesseKim);
        test2.removeUser(brown);
        assertEquals(0, test2.getUsers().size());

        test2.removeUser(brown);
        assertEquals(0, test2.getUsers().size());

        test2.removeUser(marina);
        assertEquals(0, test2.getUsers().size());

        // GET USERS TEST
        marina.joinRoom(test3);
        assertEquals("Marina", test3.getUsers().get(0).username);

        // RECORD MESSAGE TEST
        PhotoMessage test1text = new PhotoMessage(marina, "gotCamped.jpeg");
        PhotoMessage test2text = new PhotoMessage(marina, "i_hate-thisGame.gif");
        PhotoMessage test3text = new PhotoMessage(marina, "i_need_sleep.png");
        test3.recordMessage(test1text);
        test3.recordMessage(test2text);
        test3.recordMessage(test3text);
        assertEquals(3, test3.getLog().size());
    }

}

