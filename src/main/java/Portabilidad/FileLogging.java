package Portabilidad;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileLogging extends Check {
    private final File OpenFile;
    private final Workbook OpenSheet;
    private static Sheet LineasSheet;
    private final Desktop desktop;


    public FileLogging() throws Exception {
        OpenFile = new File("C:\\Portabilidad_Auto_End2End\\data\\OperationSheet.xlsx");
        FileInputStream handleFile = new FileInputStream(OpenFile);
        OpenSheet = new XSSFWorkbook(handleFile);
        LineasSheet = OpenSheet.getSheet("Result");
        desktop = Desktop.getDesktop();
    }

    public static Sheet getSheet(){
        return LineasSheet;
    }
    public void SaveFile() throws Exception{
        FileOutputStream SaveFile= new FileOutputStream(OpenFile);
        OpenSheet.write(SaveFile);
    }
    public void CloseFile()throws Exception{
        OpenSheet.close();
    }
    public void ShowFile() throws Exception{
        if (desktop.isSupported(Desktop.Action.OPEN)) {
            desktop.open(OpenFile);
        }
    }
}
