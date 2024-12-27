import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Kelas ActivityTrackerApp adalah aplikasi untuk melacak aktivitas dengan menampilkan tabel
 * yang mencakup ID, Nama Aktivitas, Deskripsi, dan Waktu/Tanggal aktivitas.
 *
 * Aplikasi ini menggunakan Swing untuk membangun antarmuka pengguna dan mengelola data aktivitas
 * dengan menampilkan tabel yang dapat diubah.
 */
public class ActivityTrackerApp {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private GUIHandler guiHandler;

    /**
     * Konstruktor untuk membuat dan menyiapkan tampilan aplikasi.
     * Inisialisasi elemen-elemen UI dan menyiapkan tabel untuk menampilkan data aktivitas.
     */
    public ActivityTrackerApp() {
        frame = new JFrame("Activity Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Inisialisasi model tabel dengan nama kolom, termasuk Timestamp
        String[] columnNames = {"ID", "Activity Name", "Description", "Timestamp"};
        tableModel = new DefaultTableModel(columnNames, 0);
        setTableModel(tableModel);

        // Inisialisasi GUI Handler
        guiHandler = new GUIHandler(this);

        // Menyiapkan UI
        guiHandler.setupUI(frame);

        frame.setVisible(true);
    }

    /**
     * Mendapatkan model tabel yang digunakan dalam aplikasi.
     *
     * @return model tabel DefaultTableModel
     */
    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    /**
     * Mendapatkan objek tabel yang digunakan dalam aplikasi.
     *
     * @return objek tabel JTable
     */
    public JTable getTable() {
        return table;
    }

    /**
     * Menetapkan model tabel baru ke aplikasi.
     *
     * @param tableModel model tabel yang baru
     */
    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    /**
     * Menetapkan objek tabel baru ke aplikasi.
     *
     * @param table objek tabel yang baru
     */
    public void setTable(JTable table) {
        this.table = table;
    }
}
