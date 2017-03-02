import processing.core.PVector;
import java.util.concurrent.ThreadLocalRandom;

public class Obstacle extends GameObject{
    float speed;

    Obstacle(float speed, PVector position) {
        this.speed = speed;
        this.position = position;

        position.y = -Resources.getFence().height;
        position.x = ThreadLocalRandom.current().nextInt(0, Game.getInstance().width - Resources.getFence().width);
    }

    public void draw() {
        if (position.y > Game.getInstance().height) {
            delete();
        }

        Game.getInstance().image(Resources.getFence(), position.x, position.y);
        position.y += speed;

        PVector pPosLeftCorner = Game.getInstance().getCar().position;
        PVector pPosRightCorner = new PVector();
        pPosRightCorner.x = Game.getInstance().getCar().position.x + Resources.getCar().width;
        pPosRightCorner.y = Game.getInstance().getCar().position.y;

        if (pPosLeftCorner.x > position.x && pPosLeftCorner.x < position.x + Resources.getFence().width
                && pPosLeftCorner.y > position.y && pPosLeftCorner.y < position.y + Resources.getFence().height) {
            Game.getInstance().getCar().die();
        }

        if (pPosRightCorner.x > position.x && pPosRightCorner.x < position.x + Resources.getFence().width
                && pPosRightCorner.y > position.y && pPosRightCorner.y < position.y + Resources.getFence().height) {
            Game.getInstance().getCar().die();
        }
    }

    public void start() {

    }
}
