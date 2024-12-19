import javax.swing.*;

public class ActivityTrackerApp {
    private JFrame frame;
    private GUIHandler guiHandler;

    public ActivityTrackerApp() {
        guiHandler = new GUIHandler();
    }

    public void createAndShowGUI() {
        frame = new JFrame("Activity Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(guiHandler.getMainPanel());
        frame.setVisible(true);
    }
}
