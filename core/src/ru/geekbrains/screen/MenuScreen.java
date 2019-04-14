package ru.geekbrains.screen;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.Ship;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Background background;
    private Texture sh;
    private Ship ship;

    @Override
    public void show() {
        super.show();
        bg = new Texture("space.png");
        background = new Background(new TextureRegion(bg));

        sh = new Texture("badlogic.jpg");
        ship = new Ship(new TextureRegion(sh));

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        //почему не отрисовывается лого?
        ship.draw(batch);
        ship.update(0.5f);
        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        ship.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        sh.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        return false;
    }
}
