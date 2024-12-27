import javax.swing.SwingUtilities;

/**
 * Kelas Main yang berfungsi sebagai titik masuk (entry point) untuk aplikasi ActivityTracker.
 *
 * Kelas ini menggunakan SwingUtilities untuk memastikan bahwa pembuatan UI dilakukan pada
 * Event Dispatch Thread (EDT), yang merupakan thread yang tepat untuk komponen GUI Swing.
 */
public class Main {

    /**
     * Metode utama (main) yang berfungsi untuk menjalankan aplikasi. Metode ini menggunakan
     * SwingUtilities untuk memastikan inisialisasi UI dilakukan di Event Dispatch Thread.
     *
     * @param args argumen baris perintah (tidak digunakan dalam aplikasi ini)
     */
    public static void main(String[] args) {
        // Memastikan pembuatan objek ActivityTrackerApp terjadi pada EDT
        SwingUtilities.invokeLater(ActivityTrackerApp::new);
    }
}
