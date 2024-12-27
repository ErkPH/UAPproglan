import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUIHandler {
    private ActivityTrackerApp tracker;
    private CRUDHandler crudHandler;

    public GUIHandler(ActivityTrackerApp tracker) {
        this.tracker = tracker;
        this.crudHandler = new CRUDHandler(tracker);
    }

    public void setupUI(JFrame frame) {
        DefaultTableModel tableModel = tracker.getTableModel();  // Use the existing tableModel
        JTable table = new JTable(tableModel);
        tracker.setTable(table);

        JScrollPane scrollPane = new JScrollPane(table);
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton saveButton = new JButton("Save");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(this::handleAdd);
        updateButton.addActionListener(this::handleUpdate);
        deleteButton.addActionListener(this::handleDelete);
        saveButton.addActionListener(this::handleSave);
    }

    private void handleAdd(ActionEvent e) {
        crudHandler.addActivity();
    }

    private void handleUpdate(ActionEvent e) {
        crudHandler.updateActivity();
    }

    private void handleDelete(ActionEvent e) {
        crudHandler.deleteActivity();
    }

    private void handleSave(ActionEvent e) {
        crudHandler.saveData();
    }
}
