package utils.gui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Austin on 9/10/2016.
 */
public class Slider extends Actor {

    private int min = 0, max = 100, current = 50;
    private boolean dragging = false;
    private int dragOffset = 0;

    private SliderListener listener;

    public void setSliderListener(SliderListener listener) {
        this.listener = listener;
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        //End batch, start shape rendering
        Gui.end(batch);
        Gui.begin(Gui.sr, ShapeRenderer.ShapeType.Filled, Gui.frame_color);

        //Render frame background
        Gui.sr.rect(getX(), getY(), getWidth(), getHeight());

        //Render frame border
        if (Gui.has_border) {
            Gui.begin(Gui.sr, ShapeRenderer.ShapeType.Line, Gui.trim_color);
            Gui.sr.rect(getX(), getY(), getWidth(), getHeight());
        }

        //End shape rendering
        Gui.end(Gui.sr);
    }
}
