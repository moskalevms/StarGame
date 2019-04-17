package ru.geekbrains.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.Star;

public class GameScreen extends BaseScreen {
    private Game game;

    private Texture bg;
    private Background background;


    private TextureAtlas atlas;
    private Star starList[];

    public GameScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/space.png");
        background = new Background(new TextureRegion(bg));

        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        starList = new Star[256];
        for(int i = 0; i < starList.length; i++){
            starList[i] = new Star(atlas);
        }

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        ship.resize(worldBounds);
        for (Star star : starList){
            star.resize(worldBounds);
        }
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    private void update(float delta){
        ship.update(delta);
        for (Star star : starList){
            star.update(delta);
        }
    }

    private void draw(){
        batch.begin();
        background.draw(batch);
        // ship.draw(batch);
        for (Star star : starList){
            star.draw(batch);
        }
        batch.end();

    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        sh.dispose();
        atlas.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        ship.touchDown(touch,pointer);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        return false;
    }
}
