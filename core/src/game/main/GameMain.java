package game.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import utils.gui.Gui;
import utils.gui.Slider;
import utils.gui.SliderListener;

public class GameMain extends ApplicationAdapter {

    private Slider slider;

    public boolean drawFps = true;

    @Override
    public void create() {
        Gui.resetRenderers();

        slider = new Slider(300, 300, 300, 50);
        slider.setValues(0, 100, 50, 10);
        slider.setSliderListener(new SliderListener() {
            @Override
            public void sliderDragged(Slider slider, int value) {
                System.out.println("Dragged slider: " + value);
            }

            @Override
            public void sliderDropped(Slider slider, int value) {
                System.out.println("Dropped slider: " + value);
            }
        });
    }

    @Override
    public void resize(int width, int height) {
        Gui.resetRenderers();
    }

    @Override
    public void dispose() {
        Gui.dispose();
    }

    private void act(float delta) {
        slider.act(delta);
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
        slider.draw(Gui.batch, 1f);

        //Render fps counter
        if (drawFps) {
            Gui.begin(Gui.batch);
            Gui.font.draw(Gui.batch, "" + Gdx.graphics.getFramesPerSecond(), 5, Gdx.graphics.getHeight() - 5);
        }

        //End all renderers
        Gui.end(Gui.batch);
        Gui.end(Gui.sr);
    }
}
