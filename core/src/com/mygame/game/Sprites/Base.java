package com.mygame.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygame.game.BattleCITYbygdx;
import com.mygame.game.Screen.PlayScreen;

/**
 * Created by Aspire on 14/12/2559.
 */
public class Base extends InteractiveTileObject{
    public Base(PlayScreen screen, Rectangle bounds){
        super(screen,bounds);
        fixture.setUserData(this);
        setCategoryFilter(BattleCITYbygdx.base_BIT);
    }

    @Override
    public void onBullethit() {
        Gdx.app.log("Base","collision");

        //GAMEOVER*******
    }

}