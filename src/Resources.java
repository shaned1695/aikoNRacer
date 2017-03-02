import processing.core.PImage;

public class Resources {
    private Resources() {}
    static PImage road;
    static PImage fence;

    static PImage getCar() {
        return Game.getInstance().loadImage("Resources/Car.png");
    }

    static PImage getRoad() {
        if (road == null) {
            road = Game.getInstance().loadImage("Resources/road.png");
        }

        return road;
    }

    static PImage getFence() {
        if (fence == null) {
            fence = Game.getInstance().loadImage("Resources/fence.png");
        }

        return fence;
    }
}
