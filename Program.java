import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Program {
    private Timer timer;

    public void runTimer(int duration) {
        JFrame window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());

        JLabel label60 = new JLabel("60 min: ");
        JLabel label40 = new JLabel("40 min: ");
        JLabel label30 = new JLabel("30 min: ");
        JLabel label20 = new JLabel("20 min: ");

        window.add(label60);
        window.add(label40);
        window.add(label30);
        window.add(label20);

        if (duration == 60) {
            timer = new Timer(60 * 60, label60);
            System.out.println("Performing 60 minutes workout...");
        } else if (duration == 40) {
            timer = new Timer(40 * 60, label40);
            System.out.println("Performing 40 minutes workout...");
        } else if (duration == 30) {
            timer = new Timer(30 * 60, label30);
            System.out.println("Performing 30 minutes workout...");
        } else if (duration == 20) {
            timer = new Timer(20 * 60, label20);
            System.out.println("Performing 20 minutes workout...");
        } else {
            System.out.println("Invalid duration. Please choose from 60, 40, 30, or 20 minutes.");
            return;
        }

        timer.start();
        window.setVisible(true);
    }

    public static void main(String[] args) {
        Scanner timeDomain = new Scanner(System.in);
        System.out.println("How long would you like to workout today?");
        int duration = timeDomain.nextInt();
        System.out.println("You would like to workout for " + duration + " minutes.");


        Push push = new Push();
        String exercise1 = push.generateExercise();
        System.out.println("Push exercise 1: " + exercise1);
        push.updateHistory(exercise1);

        String exercise2 = push.generateExercise();
        System.out.println("Push exercise 2: " + exercise2);
        push.updateHistory(exercise2);

        SwingUtilities.invokeLater(() -> {
            Program program = new Program();
            program.runTimer(duration);
        });
    }
}
