import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class GUIHandler {
    private JPanel mainPanel;
    private JTextField inputField;
    private JList<String> activityList;
    private DefaultListModel<String> activityListModel;
    private CRUDHandler crudHandler;

    // Map untuk menyimpan warna berdasarkan aktivitas
    private Map<String, Color> activityColors;

    public GUIHandler() {
        crudHandler = new CRUDHandler();
        activityColors = new HashMap<>();
        initializeActivityColors();  // Menginisialisasi warna untuk aktivitas
        initializeGUI();
    }

    // Fungsi untuk menginisialisasi warna berdasarkan aktivitas
    private void initializeActivityColors() {
        activityColors.put("makan", Color.YELLOW); // Warna kuning untuk makan
        activityColors.put("belajar", Color.CYAN); // Warna cyan untuk belajar
        activityColors.put("olahraga", Color.GREEN); // Warna hijau untuk olahraga
        // Tambahkan warna lainnya jika diperlukan
    }

    // Fungsi untuk menambah aktivitas
    private void addActivity() {
        String activity = inputField.getText().trim();
        if (!activity.isEmpty()) {
            // Menambahkan timestamp ke aktivitas
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String activityWithTime = activity + " (Added: " + timestamp + ")";

            // Menambahkan aktivitas ke CRUD handler dan model list
            crudHandler.addActivity(activityWithTime);
            activityListModel.addElement(activityWithTime);

            // Menampilkan aktivitas dengan warna latar belakang sesuai
            displayActivityWithColor(activity);

            inputField.setText("");
        } else {
            JOptionPane.showMessageDialog(mainPanel, "Activity cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Fungsi untuk menampilkan aktivitas beserta warna latar belakang sesuai
    private void displayActivityWithColor(String activity) {
        JPanel activityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));  // Layout untuk menata teks

        // Label untuk menampilkan nama aktivitas
        JLabel activityLabel = new JLabel(activity);
        activityPanel.add(activityLabel);

        // Menentukan warna latar belakang sesuai aktivitas
        Color bgColor = activityColors.get(activity.toLowerCase());
        if (bgColor != null) {
            activityPanel.setBackground(bgColor);
        }

        // Menambahkan panel aktivitas ke panel utama
        mainPanel.add(activityPanel);
        mainPanel.revalidate();  // Memperbarui tampilan
        mainPanel.repaint();
    }

    // Fungsi untuk menginisialisasi GUI
    private void initializeGUI() {
        mainPanel = new JPanel(new BorderLayout());

        // List Component
        activityListModel = new DefaultListModel<>();
        crudHandler.getActivities().forEach(activityListModel::addElement);
        activityList = new JList<>(activityListModel);
        JScrollPane scrollPane = new JScrollPane(activityList);

        // Input Field and Buttons
        inputField = new JTextField();
        JButton addButton = new JButton("Add Activity");
        JButton deleteButton = new JButton("Delete Activity");

        addButton.addActionListener(e -> addActivity());
        deleteButton.addActionListener(e -> deleteActivity());

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        inputPanel.add(buttonPanel, BorderLayout.EAST);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void deleteActivity() {
        int selectedIndex = activityList.getSelectedIndex();
        if (selectedIndex != -1) {
            crudHandler.deleteActivity(selectedIndex);
            activityListModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(mainPanel, "Please select an activity to delete!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
