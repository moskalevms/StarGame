package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 touch; //вектор положения указателя мыши
    private Vector2 pos; //вектор положения картинки
    private Vector2 v;
    private Vector2 buf;


    @Override
    public void show() {
        super.show();
        touch = new Vector2();
        pos = new Vector2();
        v = new Vector2(0.2f,0.5f);
        buf = new Vector2();
        img = new Texture("badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        buf.set(touch);
        if (buf.sub(pos).len() > 0.5f){
        pos.add(v);
        }else{
            pos.set(touch);
        }

        batch.begin();
		batch.draw(img, pos.x, pos.y);
		batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //переворачиваем ось Y и получаем вектор touch с акутальными значениями
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        //расстояние между курсором и картикой. setLength - чтобы картинка двигалась плавно
        v.set(touch.cpy().sub(pos)).setLength(0.5f);
        System.out.println("touch.x = " + touch.x + " touch.y = " + touch.y);
        return false;
    }
}
