package com.mygame.game.Tool;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.*;
import com.mygame.game.BattleCITYbygdx;
import com.mygame.game.Sprites.*;

import static com.mygame.game.BattleCITYbygdx.base_BIT;
import static com.mygame.game.BattleCITYbygdx.tank_BIT;

/**
 * Created by Aspire on 13/12/2559.
 */
public class WorldContacListener implements ContactListener{
    private float stateTime=0f;

    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;

        if(fixA.getUserData() == "Bull" || fixB.getUserData() == "Bull"){
            Fixture bull = fixA.getUserData() == "Bull" ? fixA:fixB;
            Fixture object = bull == fixA ? fixB : fixA;

            if(object.getUserData() instanceof InteractiveTileObject){
                ((InteractiveTileObject) object.getUserData()).onBullethit();
            }
        }
        switch (cDef){
            case BattleCITYbygdx.enemy_body_BIT | BattleCITYbygdx.bullet_BIT:
                if (fixA.getFilterData().categoryBits == BattleCITYbygdx.enemy_body_BIT){
                    Gdx.app.log("A","collision");
                    ((Enemy)fixA.getUserData()).hitOnBody();
                    Gdx.app.log("aa","collision");
                    //((Bullet)fixB.getUserData()).hitOnBody();
                    Gdx.app.log("aaa","collision");
                    //((Enemy)fixA.getUserData()).hitOnBody();
                    break;

                }else if (fixB.getFilterData().categoryBits == BattleCITYbygdx.enemy_BIT){
                    Gdx.app.log("B","collision");
                    ((Enemy)fixB.getUserData()).hitOnBody();
                 //   ((Bullet)fixA.getUserData()).hitOnBody();
                    break;
                }  break;
            case BattleCITYbygdx.tank_BIT | BattleCITYbygdx.bullet_BIT:
                if(fixA.getFilterData().categoryBits == tank_BIT)
                    ((Tank)fixA.getUserData()).hit();
                else ((Tank)fixB.getUserData()).hit();
                break;

            case BattleCITYbygdx.base_BIT | BattleCITYbygdx.bullet_BIT:
                if(fixA.getFilterData().categoryBits == base_BIT)
                    ((Base)fixA.getUserData()).onBullethit();
                else ((Base)fixB.getUserData()).onBullethit();

                //break;                                                                //ใส่ break แล้วไม่เด้ง

            case BattleCITYbygdx.enemy_body_BIT | BattleCITYbygdx.brick_BIT:                  //ชนกับ brick ก่อนถึงเข้าเงื่อนไข
                if (fixA.getFilterData().categoryBits == BattleCITYbygdx.enemy_body_BIT){
                    ((Enemy)fixA.getUserData()).reversVelocity(true,false);
                    //Gdx.app.log("A","enemy");

                }else{
                    ((Enemy) fixB.getUserData()).reversVelocity(true, false);
                    //Gdx.app.log("B","brick");
                    break;
                }
            case BattleCITYbygdx.enemy_body_BIT | BattleCITYbygdx.tank_BIT:
                if (fixA.getFilterData().categoryBits == BattleCITYbygdx.enemy_body_BIT){
                    ((Enemy)fixA.getUserData()).reversVelocity(true,false);
                    Gdx.app.log("A","hit tank");
                    break;
                }else{
                    ((Enemy) fixB.getUserData()).reversVelocity(true, false);
                    Gdx.app.log("B","hit tank");
                    break;
                }
            case BattleCITYbygdx.enemy_body_BIT | BattleCITYbygdx.water_BIT:
                if (fixA.getFilterData().categoryBits == BattleCITYbygdx.enemy_body_BIT){
                    ((Enemy)fixA.getUserData()).reversVelocity(true,false);
                    //Gdx.app.log("A","hit water");
                    break;
                }else{
                    ((Enemy) fixB.getUserData()).reversVelocity(true, false);
                    //Gdx.app.log("B","hit water");
                    break;
                }
            case BattleCITYbygdx.enemy_body_BIT | BattleCITYbygdx.metal_BIT:
                if (fixA.getFilterData().categoryBits == BattleCITYbygdx.enemy_body_BIT){
                    ((Enemy)fixA.getUserData()).reversVelocity(true,false);
                    //Gdx.app.log("A","hit metal");
                    break;
                }else{
                    ((Enemy) fixB.getUserData()).reversVelocity(true, false);
                    //Gdx.app.log("B","hit matel");
                    break;
                }




        }

    }

    @Override
    public void endContact(Contact contact) {
     /*   Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;
        Gdx.app.log("ee","collision");
        switch (cDef) {
            case BattleCITYbygdx.enemy_body_BIT | BattleCITYbygdx.bullet_BIT:
                if (fixA.getFilterData().categoryBits == BattleCITYbygdx.enemy_body_BIT) {
                    if (fixB.getFilterData().categoryBits == BattleCITYbygdx.bullet_BIT) {
                        Gdx.app.log("fixB","collision");
                        ((Bullet) fixB.getUserData()).hitOnBody();

                    } else if (fixB.getFilterData().categoryBits == BattleCITYbygdx.bullet_BIT) {
                        ((Bullet) fixB.getUserData()).hitOnBody();
                    }
                }

        }*/
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
