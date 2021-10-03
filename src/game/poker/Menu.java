package game.poker;

public class Menu {
    public static final String CHOICELIST = " Would you like to\nFold\nCheck/Call\nRaise";

    public static final String FOLDED = " folded";
    public static final String CALLED = " called";
    public static final String RAISED = " raised";

    public static void getChoiceList(String name) { System.out.println(name + CHOICELIST); }
    public static void getFolded(String name) { System.out.println(name + FOLDED); }
    public static void getCalled(String name) { System.out.println(name + CALLED); }
    public static void getRaised(String name) { System.out.println(name + RAISED); }
    //replace most/all of text from Game.java -> beautify (ASCII ART) -> place into appropriate spaces
    //could add decorations to the side of the menu at all times
    //TODO::starry feel for the menu page
    //TODO::copy pasta the rest of the card, link at bottom
    //TODO::add parameters to card printer,
    //to replace A and V with appropriate Numbers
    static String[] spades = {" _____", "|A .  |", "| /.\\ |", "|(_._)|", "|  |  |", "|____V|"};

    public static void spades() {
        for (String s:
             spades) {
            System.out.println(s);
        }
    }
    //ASCII ART BY ejm98
    //https://www.asciiart.eu/miscellaneous/playing-cards
}
