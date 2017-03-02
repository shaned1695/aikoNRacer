import processing.core.PApplet;
import java.util.*;
import java.util.stream.Collectors;

public class Game extends PApplet{
    List<GameObject> gameObjects = new ArrayList<>();
    static Game instance;
    Car car;
    int score = 0;
    boolean reset = false;

    public void setup() {
        addGameObject(new RoadManager(10));
        car = new Car();
        addGameObject(car);
        addGameObject(new ObstacleManager(10));

        textSize(32);
    }

    public void settings(){
        size(500, 900, P2D);
        instance = this;
    }

    public void draw(){
        if (reset) {
            addGameObject(new RoadManager(10));
            car = new Car();
            addGameObject(car);
            addGameObject(new ObstacleManager(10));

            reset = false;
        }

        background(255);
        ellipse(mouseX, mouseY, 20, 20);

        gameObjects = gameObjects.stream().filter(g -> !g.delete).collect(Collectors.toList());
        gameObjects.forEach(g -> g.draw());


        text("Score: " + Integer.toString(score), 10, 30);

        if (Game.getInstance().frameCount % 5 == 0) {
            score++;
        }
    }

    public static void main(String... args){
        PApplet.main("Game");
    }

    public static Game getInstance() {
        return instance;
    }

    public void addGameObject(GameObject g) {
        gameObjects.add(g);
        g.start();
    }

    public Car getCar() {
        return car;
    }

    public void reset() {
        gameObjects.forEach(g -> g.delete());
        reset = true;
        score = 0;
    }
}
