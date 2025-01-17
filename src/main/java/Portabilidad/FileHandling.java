package Portabilidad;

import java.awt.event.KeyEvent;

public class FileHandling extends Check {


    public FileHandling() throws Exception {
    }

    public void RenameFile() throws Exception{
        String FileName = "Operation";
        Thread.sleep(1000);
        getRobot().keyPress(KeyEvent.VK_F2);
        getRobot().keyRelease(KeyEvent.VK_F2);
        Thread.sleep(500);
        for (char letter : FileName.toCharArray()) {
            getRobot().keyPress(KeyEvent.getExtendedKeyCodeForChar(letter));
        }
        getRobot().keyPress(KeyEvent.VK_ENTER);
        getRobot().keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(100);
        getRobot().keyPress(KeyEvent.VK_CONTROL);
        getRobot().keyPress(KeyEvent.VK_X);
        getRobot().keyRelease(KeyEvent.VK_CONTROL);
        getRobot().keyRelease(KeyEvent.VK_X);
    }
    public void MoveFile() throws Exception {
        String[] Cd = {"cmd", "/c", "cd C:\\Portabilidad_Auto_End2End\\data && start ."};
        ProcessBuilder proc = new ProcessBuilder();
        proc.command(Cd);
        proc.start();
        Thread.sleep(2000);
        getRobot().keyPress(KeyEvent.VK_CONTROL);
        getRobot().keyPress(KeyEvent.VK_V);
        getRobot().keyRelease(KeyEvent.VK_CONTROL);
        getRobot().keyRelease(KeyEvent.VK_V);
        Thread.sleep(300);
        getRobot().keyPress(KeyEvent.VK_ENTER);
        getRobot().keyRelease(KeyEvent.VK_ENTER);
    }
}