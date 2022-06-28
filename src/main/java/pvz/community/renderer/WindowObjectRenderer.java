package pvz.community.renderer;

import lombok.Getter;
import pvz.community.renderer.image.BufferedImageLoader;
import pvz.community.renderer.image.Sprite;
import pvz.community.renderer.window.GameWindow;

public class WindowObjectRenderer {

    private Sprite[] onScreenSprites;
    @Getter private final BufferedImageLoader bufferedImageLoader;

    public WindowObjectRenderer() {
        this.bufferedImageLoader = new BufferedImageLoader();

    }






}
