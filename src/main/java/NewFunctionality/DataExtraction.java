package NewFunctionality;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataExtraction {

    private final Sheet RevisionSheet;
    private final LinkedList<LinkedList<String>> AllData = new LinkedList<>();

    public LinkedList<LinkedList<String>> GetAllData() {
        return AllData;
    }

    public DataExtraction() throws Exception {
        File RevisionFile = new File("C:\\Portabilidad_Auto_End2End\\data\\operation.xlsx");
        try (FileInputStream EnterToFile = new FileInputStream(RevisionFile);
             Workbook operationSheet = new XSSFWorkbook(EnterToFile)) {
            RevisionSheet = operationSheet.getSheet("Table1");
        }
    }

    public void ExtractNumeroMovil() {
        LinkedList<String> NumeroMovil = new LinkedList<>();
        Pattern LineaPattern = Pattern.compile("^7.?\\d{8}|^6.?\\d{8}");
        for (Row row : RevisionSheet) {
            for (Cell cell : row) {
                Matcher MatchNumber = LineaPattern.matcher(cell.toString());
                if (MatchNumber.find()) {
                    NumeroMovil.add(cell.toString());
                }
            }
        }
        AllData.addFirst(NumeroMovil);
    }

    public void ExtractNumeroDeCuenta() {
        Matcher matchAccountNum;
        LinkedList<String> Accounts = new LinkedList<>();
        Pattern AccountNum = Pattern.compile("^\\d{8}$");
        for (Row row : RevisionSheet) {
            for (Cell cell : row) {
                matchAccountNum = AccountNum.matcher(cell.toString());
                if (matchAccountNum.find()) {
                    Accounts.add(matchAccountNum.group());
                }
            }
        }
        AllData.add(1, Accounts);
    }
    public void ExtractSfid(){
        LinkedList<String> Sfid = new LinkedList<>();
        for(Row row : RevisionSheet){
            for(Cell cell : row){
                if(cell.toString().matches("(\\w?\\d+[A-Z]$)") && !cell.toString().matches("^[XYZ]\\d{7}[A-Z0-9]$")){
                    Sfid.add(cell.toString());
                }
            }
        }
        AllData.add(2 , Sfid);
    }
}
