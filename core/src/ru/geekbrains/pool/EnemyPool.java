package ru.geekbrains.pool;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.sprite.EnemyShip;

public class EnemyPool extends SpritesPool {
    @Override
    protected Sprite newObject() {
        return new EnemyShip();
    }
}
