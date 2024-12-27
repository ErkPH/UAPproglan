import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Kelas GUIHandler menangani antarmuka pengguna (UI) untuk aplikasi ActivityTracker.
 * Kelas ini mengatur tampilan tabel, tombol, dan aksi untuk menambah, memperbarui,
 * menghapus, dan menyimpan data aktivitas.
 */
public class GUIHandler {
    private ActivityTrackerApp tracker;
    private CRUDHandler crudHandler;

    /**
     * Konstruktor untuk menginisialisasi objek GUIHandler dengan aplikasi ActivityTracker
     * dan CRUDHandler yang digunakan untuk operasi database.
     *
     * @param tracker objek ActivityTrackerApp yang digunakan untuk berinteraksi dengan UI
     */
    public GUIHandler(ActivityTrackerApp tracker) {
        this.tracker = tracker;
        this.crudHandler = new CRUDHandler(tracker);
    }

    /**
     * Menyiapkan elemen-elemen antarmuka pengguna, termasuk tabel untuk menampilkan data
     * aktivitas dan panel tombol untuk operasi CRUD (Add, Update, Delete, Save).
     *
     * @param frame JFrame yang digunakan sebagai window utama aplikasi
     */
    public void setupUI(JFrame frame) {
        DefaultTableModel tableModel = tracker.getTableModel();  // Menggunakan tableModel yang ada
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

        // Menambahkan aksi untuk tombol
        addButton.addActionListener(this::handleAdd);
        updateButton.addActionListener(this::handleUpdate);
        deleteButton.addActionListener(this::handleDelete);
        saveButton.addActionListener(this::handleSave);
    }

    /**
     * Menangani aksi saat tombol Add diklik, yang memanggil metode untuk menambah aktivitas.
     *
     * @param e event aksi tombol
     */
    private void handleAdd(ActionEvent e) {
        crudHandler.addActivity();
    }

    /**
     * Menangani aksi saat tombol Update diklik, yang memanggil metode untuk memperbarui aktivitas.
     *
     * @param e event aksi tombol
     */
    private void handleUpdate(ActionEvent e) {
        crudHandler.updateActivity();
    }

    /**
     * Menangani aksi saat tombol Delete diklik, yang memanggil metode untuk menghapus aktivitas.
     *
     * @param e event aksi tombol
     */
    private void handleDelete(ActionEvent e) {
        crudHandler.deleteActivity();
    }

    /**
     * Menangani aksi saat tombol Save diklik, yang memanggil metode untuk menyimpan data.
     *
     * @param e event aksi tombol
     */
    private void handleSave(ActionEvent e) {
        crudHandler.saveData();
    }
}
