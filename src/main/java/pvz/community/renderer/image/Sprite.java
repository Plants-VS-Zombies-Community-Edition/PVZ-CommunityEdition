package pvz.community.renderer.image;

import lombok.Getter;
import lombok.Setter;

public class Sprite {

    @Getter @Setter
    private int x, y, width, height;

    public Sprite(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }




}
