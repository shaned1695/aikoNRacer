import processing.core.PVector;

public abstract class GameObject {
    public PVector position;
    boolean delete = false;

    public abstract void start();
    public abstract void draw();

    public void delete() {
        delete = true;
    }
}
