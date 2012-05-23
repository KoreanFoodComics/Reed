package com.babblery.reed.launcher

import com.babblery.reed.slick.ReedBasicGame
import org.newdawn.slick.AppGameContainer
import org.newdawn.slick.Game

import java.lang.reflect.Field

class ReedLauncher {
    static void main(String[] args) {
        String os = System.getProperty("os.name")
        System.out.println("Attempting to add the natives for your platform (" + os + ") to the classpath.")

        os = os.toLowerCase()

        try {
            if (os.contains("win")) {
                addToClasspath("native/natives-win32")
            } else if (os.contains("mac")) {
                addToClasspath("native/natives-mac")
            } else if (os.contains("linux")) {
                addToClasspath("native/natives-linux")
            } else {
                throw new RuntimeException("No natives are available for your platform!")
            }
        } catch (IOException ioe) {
            ioe.printStackTrace()
        }

        Game game = new ReedBasicGame("GAME")
        AppGameContainer container = new AppGameContainer(game)

        container.start()
    }

    /**
     * Add the specified path to the Java classpath.
     *
     * @param path The path to add.
     * @throws IOException If there was an error adding it to the classpath.
     */
    private static void addToClasspath(String path) throws IOException {
        try {
            Field field = ClassLoader.class.getDeclaredField("usr_paths")
            field.setAccessible(true)
            String[] paths = (String[]) field.get(null)

            for (String existingPath : paths) {
                if (path == existingPath) {
                    return
                }
            }

            String[] tmp = new String[paths.length + 1]
            System.arraycopy(paths, 0, tmp, 0, paths.length)
            tmp[paths.length] = path
            field.set(null, tmp)
            System.setProperty("java.library.path", System.getProperty("java.library.path") + File.pathSeparator + path)
        } catch (IllegalAccessException e) {
            throw new IOException("Failed to get permissions to set library path!", e)
        } catch (NoSuchFieldException e) {
            throw new IOException("Failed to get field handle to set library path!", e)
        }
    }
}
