import processing.core.PVector;

//class for the road
public class Road extends GameObject{
    float speed;
    boolean calledBack = false;
    Runnable endedCoverageCallback;

    Road(float speed, PVector position, Runnable endedCoverageCallback) {
        this.speed = speed;
        this.position = position;
        this.endedCoverageCallback = endedCoverageCallback;
    }

    public void draw() {
        if (position.y > Game.getInstance().height) {
            delete();
        }

        Game.getInstance().image(Resources.getRoad(), position.x, position.y, Game.getInstance().width, Resources.getRoad().height);

        position.y += speed;

        if (Resources.getRoad().height - Resources.getRoad().height - position.y  <= 0 && !calledBack) {
            endedCoverageCallback.run();
            calledBack = true;
        }
    }

    public void start() {

    }
}
