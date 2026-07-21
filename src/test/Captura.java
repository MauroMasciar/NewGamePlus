package test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Captura {

    public void ca() {
        try {
            Robot robot = new Robot();

            Rectangle pantalla = new Rectangle(
                    Toolkit.getDefaultToolkit().getScreenSize());

            BufferedImage imagen = robot.createScreenCapture(pantalla);

            ImageIO.write(imagen, "png", new File("captura.png"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        System.out.println("captura tomada");
    }
}