package game.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import utils.gui.Gui;

public class GameMain extends ApplicationAdapter {

    @Override
    public void create() {
        Gui.resetRenderers();
    }

    @Override
    public void resize(int width, int height) {
        Gui.resetRenderers();
    }

    @Override
    public void dispose() {
        Gui.dispose();
    }

    public void act(float delta) {

    }

    @Override
    public void render() {
        //Act
        act(Gdx.graphics.getDeltaTime());

        //Clear background
        Gdx.gl.glClearColor(Gui.background_color.r, Gui.background_color.g, Gui.background_color.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Start batch
        Gui.begin(Gui.batch);

        //Render things here
        

        //End all renderers
        Gui.end(Gui.batch);
        Gui.end(Gui.sr);
    }
}
