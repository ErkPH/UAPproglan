import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Kelas CRUDHandler menangani operasi CRUD (Create, Read, Update, Delete) untuk aplikasi
 * ActivityTracker, termasuk menambah, memperbarui, menghapus, dan menyimpan data aktivitas.
 * Data aktivitas disimpan dalam file teks dan dapat dimuat kembali ketika aplikasi dibuka.
 */
public class CRUDHandler {
    private ActivityTrackerApp tracker;
    private File file = new File("activities.txt");

    /**
     * Konstruktor untuk menginisialisasi objek CRUDHandler dengan aplikasi ActivityTracker.
     * Menginisialisasi pemuatan data dari file teks ketika objek dibuat.
     *
     * @param tracker objek ActivityTrackerApp yang digunakan untuk berinteraksi dengan UI
     */
    public CRUDHandler(ActivityTrackerApp tracker) {
        this.tracker = tracker;
        loadData();
    }

    /**
     * Menambahkan aktivitas baru ke tabel dengan meminta input dari pengguna melalui dialog.
     * Aktivitas baru yang ditambahkan termasuk ID, Nama Aktivitas, Deskripsi, dan Timestamp.
     */
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

            // Mendapatkan waktu dan tanggal saat ini
            String timestamp = getCurrentTimestamp();

            // Menambahkan baris baru dengan timestamp saat ini
            tracker.getTableModel().addRow(new Object[]{id, name, description, timestamp});
        }
    }

    /**
     * Mendapatkan timestamp (waktu dan tanggal) saat ini dalam format "yyyy-MM-dd HH:mm:ss".
     *
     * @return timestamp sebagai String
     */
    private String getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    /**
     * Memperbarui aktivitas yang dipilih di tabel. Pengguna akan diminta untuk memasukkan
     * data baru untuk ID, Nama Aktivitas, dan Deskripsi, dan timestamp akan diperbarui.
     */
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

                // Memperbarui timestamp ketika aktivitas diperbarui
                tracker.getTableModel().setValueAt(getCurrentTimestamp(), selectedRow, 3);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to update.");
        }
    }

    /**
     * Menghapus aktivitas yang dipilih dari tabel.
     * Jika tidak ada baris yang dipilih, menampilkan pesan peringatan.
     */
    public void deleteActivity() {
        int selectedRow = tracker.getTable().getSelectedRow();
        if (selectedRow != -1) {
            tracker.getTableModel().removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
        }
    }

    /**
     * Menyimpan data aktivitas yang ada dalam tabel ke file teks.
     * Setiap baris aktivitas disimpan dalam format CSV (id, nama, deskripsi, timestamp).
     */
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

    /**
     * Memuat data aktivitas dari file teks dan menambahkannya ke tabel aplikasi.
     * Jika file tidak ditemukan atau terjadi kesalahan, menampilkan pesan error.
     */
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
