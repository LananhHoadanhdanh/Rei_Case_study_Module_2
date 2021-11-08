public class Main {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static void main(String[] args) {
        System.out.println(ANSI_BLUE + "This text is red!" + ANSI_BLUE);
    }
}
