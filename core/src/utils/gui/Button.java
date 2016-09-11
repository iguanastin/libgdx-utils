package utils.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Button extends Actor {

    private boolean mouseDown = false;
    private String text;
    
    private ButtonAcceptListener listener;

    public Button(String text, int x, int y, int width, int height) {
        this.text = text;
        setPosition(x, y);
        setSize(width, height);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAcceptListener(ButtonAcceptListener listener) {
        this.listener = listener;
    }
    
    @Override
    public void act(float delta) {
        if (!mouseDown && Gdx.input.justTouched() && isMouseOver()) {
            mouseDown = true;
        } else if (mouseDown && !Gdx.input.isTouched()) {
            if (isMouseOver() && listener != null) {
                listener.accepted(this);
            }
            mouseDown = false;
        }
    }
    
    private boolean isMouseOver() {
        int x = Gdx.input.getX();
        int y = Gdx.graphics.getHeight() - Gdx.input.getY();
        return x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Gui.end(batch);
        Gui.begin(Gui.sr, ShapeRenderer.ShapeType.Filled, Gui.frame_color);

        //Use alt color if mouse down on button
        if (mouseDown) {
            Gui.sr.setColor(Gui.alternate_color);
        }
        //Draw frame background
        Gui.sr.rect(getX(), getY(), getWidth(), getHeight());

        //Draw trim if applicable
        if (Gui.has_border) {
            Gui.begin(Gui.sr, ShapeRenderer.ShapeType.Line, Gui.trim_color);
            Gui.sr.rect(getX(), getY(), getWidth(), getHeight());
        }

        //End shape rendering
        Gui.end(Gui.sr);

        //Begin batch
        Gui.begin(batch);
        //Draw button text
        Gui.drawTextCenteredAt(Gui.batch, text, getX() + getWidth()/2, getY() + getHeight()/2);
    }
    
}
