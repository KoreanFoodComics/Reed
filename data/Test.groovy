import com.babblery.reed.engine.ReedGameController
import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics
import org.newdawn.slick.Color

class Test implements ReedGameController {
    @Override
    void init(GameContainer container) {
        println "This Groovy script was dynamically loaded and compiled by Reed!"

        container.setVSync(true)
    }

    @Override
    void update(GameContainer container, int delta) {

    }

    @Override
    void render(GameContainer container, Graphics g) {
        g.setColor(Color.white);
        g.drawRect(0, 0, 100, 100)
    }
}