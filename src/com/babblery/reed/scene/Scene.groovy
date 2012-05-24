package com.babblery.reed.scene

import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics

class Scene {
    private List<Component> components;

    void render(GameContainer container, Graphics g) {
        components.each {
            component -> component.render(container, g)
        }
    }
}