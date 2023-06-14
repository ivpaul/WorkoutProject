import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Push {
    private static final int RECENT_HISTORY_SIZE = 5;
    private static final Random random = new Random();
    private final List<String> allExercises;
    private final List<String> recentHistory;

    public Push() {
        allExercises = new ArrayList<>();
        // Add all push exercises to the list
        allExercises.add("Shoulder Press");
        allExercises.add("Push Press");
        allExercises.add("Push Jerk");
        allExercises.add("Thruster");
        allExercises.add("HSPU");
        allExercises.add("Wall Walks");

        recentHistory = new ArrayList<>();
    }

    public String generateExercise() {
        if (recentHistory.size() < RECENT_HISTORY_SIZE) {
            // If recent history is not filled, generate a random exercise
            return getRandomExercise();
        } else {
            // Filter exercises that haven't been done recently
            List<String> availableExercises = new ArrayList<>(allExercises);
            availableExercises.removeAll(recentHistory);

            if (availableExercises.isEmpty()) {
                // If all exercises have been done recently, generate a random exercise
                return getRandomExercise();
            } else {
                // Select an exercise from the available exercises
                return getRandomExercise(availableExercises);
            }
        }
    }

    private String getRandomExercise() {
        int index = random.nextInt(allExercises.size());
        return allExercises.get(index);
    }

    private String getRandomExercise(List<String> exercises) {
        int index = random.nextInt(exercises.size());
        return exercises.get(index);
    }

    public void updateHistory(String exercise) {
        // Add the exercise to the recent history
        recentHistory.add(exercise);

        if (recentHistory.size() > RECENT_HISTORY_SIZE) {
            // Remove the oldest exercise if the history size exceeds the limit
            recentHistory.remove(0);
        }
    }
}
