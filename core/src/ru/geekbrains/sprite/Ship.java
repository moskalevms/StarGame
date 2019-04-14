package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;

public class Ship extends Sprite {

    private Vector2 touch = new Vector2(); //вектор положения указателя мыши
    private Vector2 pos  = new Vector2(); //вектор положения картинки
    private Vector2 v = new Vector2(0.2f,0.5f) ;
    private Vector2 buf = new Vector2();

    public Ship(TextureRegion region) {
        super(region);
    }

    @Override
    public void update(float delta){
        buf.set(touch);
        if(buf.sub(pos).len() > delta) {
            pos.add(v);
        }else{
            pos.set(touch);
        }

    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        v.set(touch.cpy().sub(pos)).setLength(0.5f);
        return super.touchDown(touch, pointer);
    }
}
