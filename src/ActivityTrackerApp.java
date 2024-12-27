import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActivityTrackerApp {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private GUIHandler guiHandler;

    public ActivityTrackerApp() {
        frame = new JFrame("Activity Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Initialize table model with column names, including Timestamp
        String[] columnNames = {"ID", "Activity Name", "Description", "Timestamp"};
        tableModel = new DefaultTableModel(columnNames, 0);
        setTableModel(tableModel);

        // Initialize GUI Handler
        guiHandler = new GUIHandler(this);

        // Setup UI
        guiHandler.setupUI(frame);

        frame.setVisible(true);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JTable getTable() {
        return table;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
}
