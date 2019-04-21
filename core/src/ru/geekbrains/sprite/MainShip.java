package ru.geekbrains.sprite;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class MainShip extends Sprite {

    private Rect worldBounds;

    private Vector2 v0 = new Vector2(0.5f, 0);
    private Vector2 v = new Vector2();

      public MainShip(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"), 1,2,2);
        setHeightProportion(0.15f);
      }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.mulAdd(v,delta);
    }

    //позиционирование корабля на экране
    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
        setBottom(worldBounds.getBottom() + 0.05f);
        setHeightProportion(0.15f);
    }


    public boolean keyDown(int keycode) {
        System.out.println("keyDown keycode = " + keycode);
        switch (keycode){
            case Input.Keys.A:
            case Input.Keys.LEFT:
                moveLeft();
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                moveRight();
                break;
        }
        return false;
    }

    public boolean keyUp(int keycode) {
        switch (keycode){
            case Input.Keys.A:
            case Input.Keys.LEFT:
            case Input.Keys.D:
            case Input.Keys.RIGHT:
               stop();
               break;
        }
        return false;
    }


    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
          if(touch.x < worldBounds.pos.x){
              moveLeft();
          }else{
              moveRight();
          }
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
          stop();
        return false;
    }

    private void moveRight(){
          v.set(v0);
    }

    private void moveLeft(){
        v.set(v0).rotate(180);
    }

    private void stop(){
          v.setZero();
    }
}
