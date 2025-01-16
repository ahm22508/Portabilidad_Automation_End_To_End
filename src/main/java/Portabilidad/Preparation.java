package Portabilidad;

import org.sikuli.script.Location;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Preparation {

    private final Robot Bot;
    private final Screen pcScreen;

    public Preparation() throws Exception{
        Bot = new Robot();
        pcScreen = new Screen();
    }

    public void prepareSystem() throws  Exception{
        int i = 2;
        String FakeLine = "666666666";
        while (i > 0) {
            Pattern ClarifyImage = new Pattern("C:\\Portabilidad_Auto_End2End\\img\\Clarify.png");
            Bot.keyPress(KeyEvent.VK_WINDOWS);
            Bot.keyPress(KeyEvent.VK_TAB);
            pcScreen.wait(ClarifyImage, 10);
            Location LocationImage = pcScreen.find(ClarifyImage).getTarget();
            Location adjustedLocation = new Location(LocationImage.getX(), LocationImage.getY() + 50);
            adjustedLocation.click();
            Bot.keyRelease(KeyEvent.VK_WINDOWS);
            Bot.keyRelease(KeyEvent.VK_TAB);

            //Press on Select
            Thread.sleep(500);
            Bot.mouseMove(226, 37);
            Bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            //press on Servicios
            Thread.sleep(500);
            Bot.mouseMove(246, 654);
            Bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            //press on Identificador de Servicio
            Bot.mouseMove(1183, 254);
            Bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(500);
            for(char digit : FakeLine.toCharArray()){
                Bot.keyPress(KeyEvent.getExtendedKeyCodeForChar(digit));
            }
            //Press on Buscar
            Bot.mouseMove(1476, 464);
            Bot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            Bot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            //Press on OK
            Thread.sleep(500);
            Bot.mouseMove(764, 475);
            Bot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            Bot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            //Press on Cerrar Button.
            Bot.mouseMove(977, 764);
            Bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            i--;
        }
    }
}