import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CRUDHandler {
    private ActivityTrackerApp tracker;
    private File file = new File("activities.txt");

    public CRUDHandler(ActivityTrackerApp tracker) {
        this.tracker = tracker;
        loadData();
    }

    public void addActivity() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField descField = new JTextField();

        Object[] message = {
                "ID:", idField,
                "Activity Name:", nameField,
                "Description:", descField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Add Activity", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String id = idField.getText();
            String name = nameField.getText();
            String description = descField.getText();

            // Get current time and date
            String timestamp = getCurrentTimestamp();

            // Add row with the current timestamp
            tracker.getTableModel().addRow(new Object[]{id, name, description, timestamp});
        }
    }

    private String getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    public void updateActivity() {
        int selectedRow = tracker.getTable().getSelectedRow();
        if (selectedRow != -1) {
            JTextField idField = new JTextField(tracker.getTableModel().getValueAt(selectedRow, 0).toString());
            JTextField nameField = new JTextField(tracker.getTableModel().getValueAt(selectedRow, 1).toString());
            JTextField descField = new JTextField(tracker.getTableModel().getValueAt(selectedRow, 2).toString());

            Object[] message = {
                    "ID:", idField,
                    "Activity Name:", nameField,
                    "Description:", descField
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Update Activity", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                tracker.getTableModel().setValueAt(idField.getText(), selectedRow, 0);
                tracker.getTableModel().setValueAt(nameField.getText(), selectedRow, 1);
                tracker.getTableModel().setValueAt(descField.getText(), selectedRow, 2);

                // Update timestamp when activity is updated
                tracker.getTableModel().setValueAt(getCurrentTimestamp(), selectedRow, 3);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to update.");
        }
    }

    public void deleteActivity() {
        int selectedRow = tracker.getTable().getSelectedRow();
        if (selectedRow != -1) {
            tracker.getTableModel().removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
        }
    }

    public void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < tracker.getTableModel().getRowCount(); i++) {
                String id = tracker.getTableModel().getValueAt(i, 0).toString();
                String name = tracker.getTableModel().getValueAt(i, 1).toString();
                String description = tracker.getTableModel().getValueAt(i, 2).toString();
                String timestamp = tracker.getTableModel().getValueAt(i, 3).toString();
                writer.write(id + "," + name + "," + description + "," + timestamp);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null, "Data saved successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage());
        }
    }

    private void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            DefaultTableModel tableModel = tracker.getTableModel();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 4);
                tableModel.addRow(parts);
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
