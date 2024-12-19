import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDHandler {
    private static final String FILE_NAME = "activities.txt";
    private List<String> activities;

    public CRUDHandler() {
        activities = new ArrayList<>();
        loadActivitiesFromFile();
    }

    public List<String> getActivities() {
        return activities;
    }

    public void addActivity(String activity) {
        activities.add(activity);
        saveActivitiesToFile();
    }

    public void deleteActivity(int index) {
        if (index >= 0 && index < activities.size()) {
            activities.remove(index);
            saveActivitiesToFile();
        }
    }

    private void loadActivitiesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                activities.add(line);
            }
        } catch (IOException e) {
            // File not found, create a new one
            saveActivitiesToFile();
        }
    }

    private void saveActivitiesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String activity : activities) {
                writer.write(activity);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving activities: " + e.getMessage());
        }
    }
}
