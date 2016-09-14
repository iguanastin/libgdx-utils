package utils.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import java.util.ArrayList;

/**
 * @author austinbt
 */
public class MultiInputProcessor implements InputProcessor {

    private ArrayList<InputProcessor> processors = new ArrayList<InputProcessor>();

    public void setAsCurrentProcessor() {
        Gdx.input.setInputProcessor(this);
    }

    public boolean addAtFront(InputProcessor processor) {
        if (!processors.contains(processor)) {
            processors.add(0, processor);
            return true;
        }

        return false;
    }

    public boolean addAtBack(InputProcessor processor) {
        if (!processors.contains(processor)) {
            processors.add(processor);
        }

        return false;
    }

    public boolean contains(InputProcessor processor) {
        return processors.contains(processor);
    }

    public int getPriority(InputProcessor processor) {
        return processors.indexOf(processor);
    }

    public boolean remove(InputProcessor processor) {
        return processors.remove(processor);
    }

    @Override
    public boolean keyDown(int keycode) {
        for (InputProcessor processor : processors) {
            if (processor.keyDown(keycode)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        for (InputProcessor processor : processors) {
            if (processor.keyUp(keycode)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        for (InputProcessor processor : processors) {
            if (processor.keyTyped(character)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        for (InputProcessor processor : processors) {
            if (processor.touchDown(screenX, screenY, pointer, button)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        for (InputProcessor processor : processors) {
            if (processor.touchUp(screenX, screenY, pointer, button)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        for (InputProcessor processor : processors) {
            if (processor.touchDragged(screenX, screenY, pointer)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        for (InputProcessor processor : processors) {
            if (processor.mouseMoved(screenX, screenY)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        for (InputProcessor processor : processors) {
            if (processor.scrolled(amount)) {
                return true;
            }
        }

        return false;
    }
}
