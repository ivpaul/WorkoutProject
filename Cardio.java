import java.util.List;
import java.util.Random;

public class Cardio {
    private static final Random random = new Random();
    private final List<String> exercises = List.of("Run", "Burpee", "Row/Bike", "Double Unders");

    public String generateExercise() {
        return getRandomExercise(exercises);
    }

    private String getRandomExercise(List<String> exercises) {
        int index = random.nextInt(exercises.size());
        return exercises.get(index);
    }
}
