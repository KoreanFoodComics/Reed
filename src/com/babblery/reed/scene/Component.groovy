package com.babblery.reed.scene

import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics

abstract class Component {
    /**
     * The parent of this component.
     */
    Scene parentScene

    /**
     * Create a new component with the specified parent scene.
     *
     * @param parentScene The parent of this component.
     */
    Component(Scene parentScene) {
        this.parentScene = parentScene
    }

    /**
     * Get the parent scene for this component.
     *
     * @return The parent scene for this component.
     */
    Scene getParentScene() {
        return parentScene
    }

    /**
     * Set the parent scene for this component.
     *
     * @param parentScene The new parent scene.
     */
    void setParentScene(Scene parentScene) {
        this.parentScene = parentScene
    }

    /**
     * Called every frame this component is visible.
     *
     * @param container The Slick GameContainer for this game.
     * @param g The Slick Graphics object (nearly identical to {@link java.awt.Graphics2D}).
     */
    abstract void render(GameContainer container, Graphics g)
}
