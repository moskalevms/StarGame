package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.EnemyPool;

public class EnemyShip extends Sprite {

    private Rect worldBounds;
    private Vector2 v = new Vector2();
    private int damage;
    private TextureRegion enemyShipRegion;

    public EnemyShip() {
        regions = new TextureRegion[1];
    }

    public EnemyShip(TextureAtlas atlas) {
        this.enemyShipRegion = atlas.findRegion("enemy1");
        regions = new TextureRegion[1];
    }

    public void set(
            TextureRegion region,
            Vector2 pos0,
            Vector2 v0,
            float height,
            Rect worldBounds,
            int damage
    ) {

        this.regions[0] = region;
        this.pos.set(pos0);
        this.v.set(v0);
        setHeightProportion(height);
        this.worldBounds = worldBounds;
        this.damage = damage;
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if (isOutside(worldBounds)) {
            destroy();
        }
    }

    public int getDamage() {
        return damage;
    }

}
