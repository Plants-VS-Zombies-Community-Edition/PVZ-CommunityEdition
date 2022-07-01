package pvz.community.renderer.window.scenes;

public abstract class Scene {

    public Scene() {
        init();
    }



    public abstract void update(float deltaTime);

    public void init() {}

}
