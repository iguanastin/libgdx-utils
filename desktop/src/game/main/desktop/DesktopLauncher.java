package game.main.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl.LwjglFrame;
import com.badlogic.gdx.graphics.Color;
import game.main.GameMain;
import java.awt.Toolkit;

public class DesktopLauncher {

    public static void main(String[] arg) {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.backgroundFPS = 0;
        config.foregroundFPS = 60;
        config.vSyncEnabled = true;
        config.fullscreen = false;
        config.resizable = true;
        config.x = -1;
        config.y = -1;
        config.width = width;
        config.height = height;
        config.initialBackgroundColor = Color.GRAY;
        config.title = "LibGDX Utils";
        new LwjglFrame(new GameMain(), config).setExtendedState(LwjglFrame.MAXIMIZED_BOTH);
    }
}
