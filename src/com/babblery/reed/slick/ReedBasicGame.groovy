package com.babblery.reed.slick

import com.babblery.reed.engine.ReedGameController
import com.babblery.reed.launcher.ReedLauncher
import org.newdawn.slick.BasicGame
import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics

/**
 * Wraps Slick's {@link BasicGame} functionality with Groovy code,
 * and provides a simple game interface for the game logic scripts.
 */
class ReedBasicGame extends BasicGame {
    ReedGameController gameController

    /**
     * Create a new game.
     *
     * @param windowTitle The title of the game window.
     */
    public ReedBasicGame(String windowTitle) {
        super(windowTitle)
    }

    @Override
    void init(GameContainer container) {
        ClassLoader parent = ReedLauncher.classLoader
        GroovyClassLoader loader = new GroovyClassLoader(parent)
        Class groovyClass = loader.parseClass(new File("data/Test.groovy"))

        Object controllerObject = groovyClass.newInstance()
        assert controllerObject instanceof ReedGameController, "the game's controller class must implement ReedGameController"

        gameController = (ReedGameController) controllerObject
        gameController.init(container)
    }

    @Override
    void update(GameContainer container, int delta) {
        gameController.update(container, delta)
    }

    @Override
    void render(GameContainer container, Graphics g) {
        gameController.render(container, g)
    }
}
