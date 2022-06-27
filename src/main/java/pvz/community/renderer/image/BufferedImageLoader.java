package pvz.community.renderer.image;

import pvz.community.logger.GlobalConsole;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

public class BufferedImageLoader {
    private BufferedImage image;


    public BufferedImage getLast() {
        return image;
    }


    public BufferedImage loadImage(String path) throws IOException {
        File file = new File(path);
        BasicFileAttributes basicFileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);

        if (!file.exists()) {
            GlobalConsole.getLogger().error("File not found: " + path);
            return null;
        }

        if (basicFileAttributes.isDirectory()) {
            GlobalConsole.getLogger().error("File is a directory: " + path);
            return null;
        }
        image = ImageIO.read(new File(path));
        return image;
    }
}
