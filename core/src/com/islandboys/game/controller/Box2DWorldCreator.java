package com.islandboys.game.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.islandboys.game.model.Bricks;
import com.islandboys.game.model.Coins;
import com.islandboys.game.model.Dor;
import com.islandboys.game.model.Fire;
import com.islandboys.game.model.Flame;
import com.islandboys.game.model.GameInfo;
import com.islandboys.game.model.HellDog;
import com.islandboys.game.model.Hud;
import com.islandboys.game.model.Key;
import com.islandboys.game.model.Ogre;
import com.islandboys.game.model.Orc;
import com.islandboys.game.model.Skeleton;
import com.islandboys.game.model.Spike;
import com.islandboys.game.model.Undead;
import com.islandboys.game.view.PlayScreen;

import javax.swing.KeyStroke;


/**
 * Box2DWorldCreator Class
 *
 */
public class Box2DWorldCreator {

    protected  Hud hud;


    private Array<Ogre> ogres;
    private Array<Flame> flames;
    private Array<Skeleton>skeletons;
    private Array<Orc>orcs;
    private Array<Undead>undeads;
    private Array<HellDog>dog;


    /**
     *  Box2DWorldCreator  Constructor
     * @param screen
     * @param hud
     */
    public Box2DWorldCreator(PlayScreen screen,Hud hud ) {
        this.hud=hud;
        CreatGroundBody(screen.getWorld(),screen.getMap());
        createBodys(screen);


    }


    /**
     *  Ground Creator
     * @param world
     * @param map
     */
    public void CreatGroundBody(World world, TiledMap map){

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        //ground bdx
        for (MapObject object : map.getLayers().get(GameInfo.GROUND).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;

            bdef.position.set((rect.getX() + rect.getWidth() / 2) / GameInfo.PIXEL_METER, (rect.getY() + rect.getHeight() / 2) / GameInfo.PIXEL_METER);
            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2 / GameInfo.PIXEL_METER, rect.getHeight() / 2 / GameInfo.PIXEL_METER);
            fdef.shape = shape;
            body.createFixture(fdef);

        }

    }



    /**
     *  Body-s Creator in the game world
     * @param screen
     */
    public void createBodys(PlayScreen screen) {

        //plat bdx
        for (MapObject object : screen.getMap().getLayers().get(GameInfo.BRICKS).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new Bricks(screen,rect,hud);

        }

        //spikes bdx
        for (MapObject object : screen.getMap().getLayers().get(GameInfo.SPIKE).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new Spike(screen,rect,hud);

        }

        //fire bdx
        for (MapObject object : screen.getMap().getLayers().get(GameInfo.FIRE).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new Fire(screen,rect,hud);

        }

        //coins bdx
        for (MapObject object : screen.getMap().getLayers().get(GameInfo.COINS).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new Coins(screen, rect,hud);

        }

        //key bdx
        for (MapObject object : screen.getMap().getLayers().get(GameInfo.KEY).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new Key(screen, rect,hud);

        }

        //dor bdx
        for (MapObject object : screen.getMap().getLayers().get(GameInfo.DOR).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new Dor(screen, rect,hud);

        }




        //ogres bdx
        ogres=new Array<Ogre>();
        for (MapObject object : screen.getMap().getLayers().get(GameInfo.OGRES).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

           ogres.add(new Ogre(screen,rect.getX()/GameInfo.PIXEL_METER,rect.getY()/GameInfo.PIXEL_METER));

        }

        //flames bdx
        flames=new Array<Flame>();
        for (MapObject object : screen.getMap().getLayers().get(GameInfo.FLAME).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            flames.add(new Flame(screen,rect.getX()/GameInfo.PIXEL_METER,rect.getY()/GameInfo.PIXEL_METER));

        }

        //Skeleton
        skeletons=new Array<Skeleton>();
        for (MapObject object : screen.getMap().getLayers().get(GameInfo.SKELETON).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            skeletons.add(new Skeleton(screen,rect.getX()/GameInfo.PIXEL_METER,rect.getY()/GameInfo.PIXEL_METER));

        }

        //Orcs
       orcs=new Array<Orc>();
        for (MapObject object : screen.getMap().getLayers().get(GameInfo.ORCS).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            orcs.add(new Orc(screen,rect.getX()/GameInfo.PIXEL_METER,rect.getY()/GameInfo.PIXEL_METER));

        }

        //UND
        undeads=new Array<Undead>();
        for (MapObject object : screen.getMap().getLayers().get(GameInfo.UNDEAD).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            undeads.add(new Undead(screen,rect.getX()/GameInfo.PIXEL_METER,rect.getY()/GameInfo.PIXEL_METER));

        }


        //dog
        dog=new Array<HellDog>();
        for (MapObject object : screen.getMap().getLayers().get(GameInfo.HELLD).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

           dog.add(new HellDog(screen,rect.getX()/GameInfo.PIXEL_METER,rect.getY()/GameInfo.PIXEL_METER));

        }


    }

    /**
     *  Get ogres in the game world
     *  @return ogres
     */
    public Array<Ogre> getOgres() {
        return ogres;
    }


    /**
     *  Get flames in the game world
     *  @return flames
     */
    public Array<Flame> getFlames() {
        return flames;
    }


    /**
     *  Get Skeletons in the game world
     *  @return skeletons
     */
    public Array<Skeleton> getSkeletons() {
        return skeletons;
    }


    /**
     *  Get orcs in the game world
     *  @return orcs
     */
    public Array<Orc> getOrcs() {
        return orcs;
    }


    /**
     *  Get Undead in the game world
     *  @return undead
     */
    public Array<Undead> getUndeads() {
        return undeads;
    }


    /**
     *  Get helldogs in the game world
     *  @return dog
     */
    public Array<HellDog> getHelldog() {
        return dog;
    }




}
