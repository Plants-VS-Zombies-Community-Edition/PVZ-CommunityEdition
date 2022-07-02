package pvz.community.renderer.window;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;
import pvz.community.PlantsVSZombies;
import pvz.community.launcher.GameLauncher;
import pvz.community.renderer.window.scenes.Scene;
import pvz.community.renderer.window.scenes.types.mainmenu.MainMenuScene;
import pvz.community.utils.Logger;
import pvz.community.utils.UpTime;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11C.*;

public class Window {

    private int width, height; String title;
    private long glfwWindowAddress;


    private static Window window = null;
    private static Scene scene; // Current scene

    private Window() {
        this.width = 800;
        this.height = 600;
        this.title = GameLauncher.TITLE + " - " + GameLauncher.VERSION;
    }


    public void run() {
        init();
        loop();
    }


    private void init() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit() ) throw new IllegalStateException("Unable to initialize GLFW");

        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        glfwWindowAddress = glfwCreateWindow(this.width, this.height, this.title, MemoryUtil.NULL, MemoryUtil.NULL);
        if (glfwWindowAddress == MemoryUtil.NULL) throw new IllegalStateException("Failed to create the GLFW window");

        // Make OpenGL CTX current
        glfwMakeContextCurrent(glfwWindowAddress);

        // Enable vsync
        glfwSwapInterval(1);

        // Display the window
        glfwShowWindow(glfwWindowAddress);


        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        // Create the actual main menu scene
        Window.changeScene(new MainMenuScene());
    }

    private void loop() {
        glClearColor(1.0f, 1.0f, 1.0f, 0.0f);

        // Frame times
        float startTime = PlantsVSZombies.getInstance().getSystemUtils().getTimeNano(UpTime.FormatDelta.SECOND);
        float endTime;
        float deltaTime = -1.0f;


        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while ( !glfwWindowShouldClose(glfwWindowAddress) ) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
            glfwPollEvents(); // Poll for window events. The key callback above will only be invoked during this call.

            if (deltaTime >= 0) scene.update(deltaTime);

            glfwSwapBuffers(glfwWindowAddress); // swap the color buffers

            // This should be on the end of the code block
            // to avoid the frame time lag spike not being recorded if occurs.
            endTime = PlantsVSZombies.getInstance().getSystemUtils().getTimeNano(UpTime.FormatDelta.SECOND);
            deltaTime = endTime - startTime;
            startTime = endTime;
        }

    }

    public static Window get() {
        if (Window.window == null) {
            Window.window = new Window();
            window.init();
        }
        return Window.window;
    }

    public static void changeScene(Scene scene) {
        Window.scene = scene;

        int i = 0;
    }
}
