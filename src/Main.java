import model.Launcher;

public class Main {

    public static void main(String[] args) {

        try {
            Launcher.launch();
        }

        catch(Exception e) {
            System.err.println("ERROR : " + e);
        }

    }
}
