import java.util.List;
import java.util.Random;

public class Pull {
    private static final Random random = new Random();
    private final List<String> exercises = List.of("Deadlift Sumo", "Deadlift High Pull", "Medicine Ball Clean",
            "Deadlift", "Snatch", "Clean");

    public String generateExercise() {
        return getRandomExercise(exercises);
    }

    private String getRandomExercise(List<String> exercises) {
        int index = random.nextInt(exercises.size());
        return exercises.get(index);
    }
}
