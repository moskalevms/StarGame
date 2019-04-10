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
    private Vector2 newPos;

    @Override
    public void show() {
        super.show();
        touch = new Vector2();
        pos = new Vector2();
        v = new Vector2(0.2f,0.5f);
        img = new Texture("badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        pos.add(v);
        batch.begin();
		batch.draw(img, pos.x, pos.y);
        newPos = pos.cpy().sub(touch); //нашел вектор между курсором и картинкой
        System.out.println("newPos.x = " + newPos.x + "newPos.y = " + newPos.y);
        newPos.len();
        System.out.println("newPos.len() = " + newPos.len()); //нашел длину вектора между курсором и картинкой
        newPos.nor();
        //имею расстояние между курсором и картинкой и направление от курсора к картинке
        //теперь нужно переместить картинку к кусрору.
        //то есть чтобы вектор pos двигался со скоростью v в коoрдинаты touch на вычисленное растояние по найденному направлению
        pos.set(newPos);
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
        System.out.println("touch.x = " + touch.x + " touch.y = " + touch.y);
        return false;
    }
}
