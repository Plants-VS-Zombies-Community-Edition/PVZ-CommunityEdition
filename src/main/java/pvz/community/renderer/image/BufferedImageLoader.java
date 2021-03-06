package pvz.community.renderer.image;


import pvz.community.utils.Logger;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

public class BufferedImageLoader {

    private BufferedImage image;
    private final String resourceDir = "./src/main/resources/";
    public BufferedImage getLast() {
        return image;
    }

    public boolean exists(String resource) {
        File file = new File(resourceDir + resource);
        BasicFileAttributes attr = null;
        try {
            attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            if (file.exists() && file.isFile()) return true;
            if (attr.isRegularFile()) return true;

        }
        catch (IOException e) {
            Logger.INSTANCE.error(e.getMessage());
        }
        return false;
    }

    public BufferedImage loadImage(String path) {
        File file = new File(resourceDir + path);
        BasicFileAttributes basicFileAttributes;
        try {
            basicFileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        }
        catch (IOException e) {
            Logger.INSTANCE.error("Error basic file attributes for the image in: " + path);
            e.printStackTrace();
            return null;
        }

        if (!file.exists()) {
            Logger.INSTANCE.error("File not found: " + path);
            return null;
        }

        if (basicFileAttributes.isDirectory()) {
            Logger.INSTANCE.error("File is a directory: " + path);
            return null;
        }
        try {
            image = ImageIO.read(new File(resourceDir + path));

            return image;
        }
        catch (IOException e) {
            Logger.INSTANCE.error("Error loading image: " + path);
            e.printStackTrace();
            return null;
        }
    }
}


