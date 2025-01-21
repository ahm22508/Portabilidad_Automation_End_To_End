package NewFunctionality;

public class Main {


    public static void main(String[] args) throws Exception {
//        GetFile getFile = new GetFile();
//        FileHandling FileHandling = new FileHandling();
        DataExtraction dataExtraction = new DataExtraction();
//    getFile.GetIdCase();
//    getFile.GetDriver();
//    getFile.GoToVCTool();
//    getFile.InitiateVCTool();
//    Thread.sleep(1500);
//    getFile.EnterToCases();
//    getFile.IntroduceCase();
//    getFile.GetSpecificCase();
//    getFile.DownloadFile();
//    getFile.ShowFile();
//    Thread.sleep(500);
//    getFile.Exit();
//    FileHandling.RenameFile();
//    FileHandling.MoveFile();
//    FileHandling.OpenFile();
//    FileHandling.SearchToSheet();
//    FileHandling.TransformFileToText();
//    FileHandling.UpdateAndSaveFile();
        dataExtraction.ExtractNumeroMovil();
        dataExtraction.ExtractNumeroDeCuenta();
        dataExtraction.ExtractSfid();
        for(String s : dataExtraction.GetAllData().get(2)){
            System.out.println(s);
        }
    }
}
