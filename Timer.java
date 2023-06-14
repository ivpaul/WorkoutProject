import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timer {
    private JLabel counterLabel;
    private javax.swing.Timer countdownTimer;
    private int duration;

    public Timer(int duration, JLabel counterLabel) {
        this.duration = duration;
        this.counterLabel = counterLabel;
        countdownTimer = new javax.swing.Timer(1000, new CountdownListener());
    }

    public void start() {
        countdownTimer.start();
    }

    public void stop() {
        countdownTimer.stop();
    }

    class CountdownListener implements ActionListener {
        private int remainingTime = duration;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (remainingTime > 0) {
                int minutes = remainingTime / 60;
                int seconds = remainingTime % 60;
                String timeString = String.format("%02d:%02d", minutes, seconds);
                counterLabel.setText(timeString);
                remainingTime--;
            } else {
                stop();
                // Perform any additional actions when the timer reaches zero
                counterLabel.setText("Time's up!");
            }
        }
    }
}
