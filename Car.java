import processing.core.PVector;

//Class for the Car
public class Car extends GameObject {
    public void draw() {
        Game.getInstance().image(Resources.getCar(), position.x, position.y);

        //Controls for the movement of the car
        if (Game.getInstance().keyPressed) {
            if (Game.getInstance().key == 'a') {
                position.x -= 5;
            }

            if (Game.getInstance().key == 'd') {
                position.x += 5;
            }

            if (position.x > Game.getInstance().width - Resources.getCar().width) {
                position.x = Game.getInstance().width - Resources.getCar().width;
            }

            if (position.x < 0) {
                position.x = 0;
            }
        }
    }

    public void start() {
        position = new PVector(Game.getInstance().width / 2 - (Resources.getCar().width / 2), Game.getInstance().height - Resources.getCar().height);
    }
    
    //Resets game when die
    public void die() {
        Game.getInstance().reset();
    }
}
