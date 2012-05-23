package com.babblery.reed.engine

import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics

interface ReedGameController {
    /**
     * Called when the game is being initialized, before Reed sets things up.
     *
     * @param container The Slick GameContainer for this game.
     */
    void init(GameContainer container)

    /**
     * Called every game tick (default 20 times per second).
     *
     * @param container The Slick GameContainer for this game.
     * @param delta The time that has passed since the last tick.
     */
    void update(GameContainer container, int delta)

    /**
     * Called every frame. You should avoid rendering much here, adding objects to a scene and using screens are much
     * better methods.
     *
     * @param container The Slick GameContainer for this game.
     * @param g The Slick Graphics object (nearly identical to {@link java.awt.Graphics2D}).
     */
    void render(GameContainer container, Graphics g)
}
