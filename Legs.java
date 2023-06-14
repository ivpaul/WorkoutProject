import java.util.List;
import java.util.Random;

public class Legs {
    private static final Random random = new Random();
    private final List<String> exercises = List.of("Air Squat", "Front Squat", "Overhead Squat",
            "DB Overhead Lunge", "DB Lunge", "Pistols");

    public String generateExercise() {
        return getRandomExercise(exercises);
    }

    private String getRandomExercise(List<String> exercises) {
        int index = random.nextInt(exercises.size());
        return exercises.get(index);
    }
}
