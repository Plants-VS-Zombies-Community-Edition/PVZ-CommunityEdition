package pvz.community

import lombok.Getter
import pvz.community.launcher.LauncherSettings
import pvz.community.renderer.window.GameWindow

/**
    This class is the main game instance.
    It is responsible for starting the game, and for handling the game loop.
    It takes LauncherSettings as a parameter, which is used to configure the game.
    Launcher Settings are stored in the properties.json file
    @see GameLauncher
 **/
class PlantsVSZombies(settings: LauncherSettings){

    private var s = settings;
    fun getSettings(): LauncherSettings {
        return s;
    }
    private val instance: PlantsVSZombies = this
    companion object {
        lateinit var instance: PlantsVSZombies //This is used to access the game instance from anywhere in the game
    }

    @Getter private var window: GameWindow? = GameWindow();






}