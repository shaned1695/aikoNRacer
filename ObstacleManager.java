import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

public class ObstacleManager extends GameObject{
    float speed;
    List<GameObject> obstacles = new ArrayList<>();
    int frequency = 70;

    ObstacleManager(float speed) {
        this.speed = speed;
    }

    public void draw() {
        obstacles.forEach(o -> o.draw());
        obstacles = obstacles.stream().filter(o -> !o.delete).collect(Collectors.toList());

        if (Game.getInstance().frameCount % frequency == 0) {
            obstacles.add(new Obstacle(speed, new PVector(0,0)));
        }
    }

    public void start() {
        obstacles.add(new Obstacle(speed, new PVector(0,0)));

        Timer timer = new Timer();
        timer.schedule(new UpdateFrequency(), 0, 2500);
    }

    class UpdateFrequency extends TimerTask {
        public void run() {
            frequency--;

            if (frequency < 20) {
                frequency = 20;
            }
        }
    }
}
