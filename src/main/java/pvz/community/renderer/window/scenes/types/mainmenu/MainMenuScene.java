package pvz.community.renderer.window.scenes.types.mainmenu;

import pvz.community.renderer.window.scenes.Scene;
import pvz.community.utils.Logger;

import static org.lwjgl.opengl.GL20.*;

public class MainMenuScene extends Scene {


    private final String vertexShaderSRC = "#version 330 core\n" +
            "layout (location = 0) in vec3 aPos;\n" +
            "layout (location = 1) in vec3 aColor;\n" +
            "\n" +
            "out vec4 fColor;\n" +
            "\n" +
            "void main() {\n" +
            "\n" +
            "    fColor = aColor;\n" +
            "    gl_Position = vec4(aPos, 1.0);\n" +
            "}\n";

    private final String fragmentShaderSRC = "#version 330 core\n" +
            "\n" +
            "in vec4 fColor;\n" +
            "out vec4 color;\n" +
            "\n" +
            "void main() {\n" +
            "    color = fColor;\n" +
            "}";

    private int vertexId, fragmentId, shaderProgram;

    public MainMenuScene() {

    }

    @Override
    public void init() {
        // Loading and compiling the vertex

        vertexId = glCreateShader(GL_VERTEX_SHADER);

        glShaderSource(vertexId, vertexShaderSRC);

        glCompileShader(vertexId);

        // Error checking
        int success = glGetShaderi(vertexId, GL_COMPILE_STATUS);
        if (success == GL_FALSE) {
            int strLen = glGetShaderi(vertexId, GL_INFO_LOG_LENGTH);
            Logger.INSTANCE.error("Failed to compile vertex shader");
            Logger.INSTANCE.error(glGetShaderInfoLog(vertexId, strLen));
            assert false: "";
        }


        // Loading and compiling the fragment

        fragmentId = glCreateShader(GL_VERTEX_SHADER);

        glShaderSource(fragmentId, fragmentShaderSRC);

        glCompileShader(fragmentId);

        // Error checking
        success = glGetShaderi(fragmentId, GL_FRAGMENT_SHADER);
        if (success == GL_FALSE) {
            int strLen = glGetShaderi(fragmentId, GL_INFO_LOG_LENGTH);
            Logger.INSTANCE.error("Failed to compile fragment shader");
            Logger.INSTANCE.error(glGetShaderInfoLog(fragmentId, strLen));
            assert false: "";
        }

        shaderProgram = glCreateProgram();
        glAttachShader(shaderProgram, vertexId);
        glAttachShader(shaderProgram, fragmentId);
        glLinkProgram(shaderProgram);

        // Check for errors
        success = glGetProgrami(shaderProgram, GL_LINK_STATUS);

        if (success == GL_FALSE) {
            int strLen = glGetProgrami(shaderProgram, GL_INFO_LOG_LENGTH);
            Logger.INSTANCE.error("Failed to link shader program");
            Logger.INSTANCE.error(glGetProgramInfoLog(shaderProgram, strLen));
            assert false: "";
        }

    }


    @Override
    public void update(float deltaTime) {



    }


}
