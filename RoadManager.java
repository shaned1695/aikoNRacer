import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import processing.core.PVector;

public class RoadManager extends GameObject{
    float speed;
    List<GameObject> roads = new ArrayList<>();
    boolean addRoad = false;

    RoadManager(float speed) {
        this.speed = speed;
    }

    public void draw() {
        roads.forEach(r -> r.draw());
        roads = roads.stream().filter(r -> !r.delete).collect(Collectors.toList());

        if (addRoad) {
            roads.add(new Road(speed, new PVector(0, -Resources.getRoad().height), ()->roadEndedCoverage()));
            addRoad = false;
        }
    }

    public void start() {
        roads.add(new Road(speed, new PVector(0, -Resources.getRoad().height), ()->roadEndedCoverage()));

        for(int i = 0; i < 5; i++) {
            roads.add(new Road(speed, new PVector(0, Resources.getRoad().height * i), ()->{}));
        }
    }

    void roadEndedCoverage() {
        addRoad = true;
    }
}
