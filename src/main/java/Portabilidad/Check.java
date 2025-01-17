package Portabilidad;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class Check {

    private final Robot Bot;
    private final Screen pcScreen;
    private final Pattern RecognizePopUp = new Pattern("C:\\Portabilidad_Auto_End2End\\img\\PopUp.png");
    private final Pattern activationImage = new Pattern("C:\\Portabilidad_Auto_End2End\\img\\ActivationImage.png");

    public Check() throws Exception {
        Bot = new Robot();
        pcScreen = new Screen();
    }

    public Robot getRobot() {
        return Bot;
    }

    public void generalCheck() throws Exception {

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
        //press on DropMenu
        Bot.mouseMove(452, 252);
        Bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //press on DropDownMenu
        Bot.mouseMove(455, 288);
        Bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void PressOnAC() throws Exception {
        //press on AC
        Thread.sleep(300);
        Bot.mouseMove(350, 270);
        Bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void PressOnPA() throws Exception {
        // press on PA
        Thread.sleep(300);
        Bot.mouseMove(346, 280);
        Bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void PressOnIdentificadorDeServicio() throws Exception {
        //press on Identificador de Servicio
        Bot.mouseMove(1183, 254);
        Bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(500);
    }

    public void ExecuteCheck() throws Exception {
        //press on Buscar Button
        Bot.mouseMove(1476, 464);
        Bot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        Bot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1047);
    }

    public void CheckAc() throws Exception {
        for (Row Lineas : FileLogging.getSheet()) {
            Cell LineaCell = Lineas.getCell(0);
            if (LineaCell != null) {
                String Linea = LineaCell.getStringCellValue();
                for (char digit : Linea.toCharArray()) {
                    getRobot().keyPress(KeyEvent.getExtendedKeyCodeForChar(digit));
                }
            }
            ExecuteCheck();
            if (pcScreen.has(RecognizePopUp)) {
                Lineas.createCell(1).setCellValue("No Activa");
                //Clean Error.
                Bot.mouseMove(764, 475);
                Bot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                Bot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            }
            if (pcScreen.has(activationImage) && !pcScreen.has(RecognizePopUp)) {
                Lineas.createCell(1).setCellValue("Activa");
            }
            CleanCheck();
        }
    }

    public void CheckPA() throws Exception {
        for (Row Lineas : FileLogging.getSheet()) {
            Cell LineaCell = Lineas.getCell(0);
            if (LineaCell != null) {
                String Linea = LineaCell.getStringCellValue();
                for (char digit : Linea.toCharArray()) {
                    getRobot().keyPress(KeyEvent.getExtendedKeyCodeForChar(digit));
                }
            }
            ExecuteCheck();
            if (pcScreen.has(RecognizePopUp)) {
                Lineas.createCell(1).setCellValue("No Preactivada");
                //Clean Error.
                Bot.mouseMove(764, 475);
                Bot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                Bot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            }
            if (!pcScreen.has(RecognizePopUp)) {
                Lineas.createCell(1).setCellValue("Preactivada");
            }
            CleanCheck();
        }
    }
    public void CheckIfIsNotPA() throws Exception{
        for (Row Lineas : FileLogging.getSheet()) {
            Cell LineaCell = Lineas.getCell(0);
            if (LineaCell != null) {
                String Linea = LineaCell.getStringCellValue();
                for (char digit : Linea.toCharArray()) {
                    getRobot().keyPress(KeyEvent.getExtendedKeyCodeForChar(digit));
                }
            }
            ExecuteCheck();
            if (pcScreen.has(RecognizePopUp)) {
                Lineas.createCell(2).setCellValue("No Preactivada(Not_Error)");
                //Clean Error.
                Bot.mouseMove(764, 475);
                Bot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                Bot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            }
            if (!pcScreen.has(RecognizePopUp)) {
                Lineas.createCell(2).setCellValue("Preactivada(Error)");
            }
            CleanCheck();
        }
    }

    public void CleanCheck() throws Exception {
        //Cleaning Field.
        Bot.mouseMove(1050, 254);
        Bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Bot.keyPress(KeyEvent.VK_DELETE);
        Bot.keyRelease(KeyEvent.VK_DELETE);
        Thread.sleep(200);
    }

    public void EndCheck() {
        //Press on Cerrar Button.
        Bot.mouseMove(977, 764);
        Bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}