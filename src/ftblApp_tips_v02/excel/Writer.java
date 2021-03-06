package ftblApp_tips_v02.excel;

import ftblApp_tips_v02.localization.Messages;
import ftblApp_tips_v02.main.Maths;
import org.apache.poi.ss.usermodel.Cell;    //C:\Users\79057\IdeaProjects\tips_v2\poi-4.1.2
import org.apache.poi.xssf.usermodel.*;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Writer
{
    public static void _writeToExcel(String txtf_date_toWrite,
                                     String guid,
                                     String txtf_federation_toWrite,
                                     String txtf_champ_toWrite,
                                     String txtf_admin_toWrite,
                                     String txtf_games_toWrite,
                                     String txtf_division_toWrite)
            throws Exception
    {
        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        Maths mths = new Maths();
        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet( ""+mths._currentDateTime());

        //Create row object
        XSSFRow row;

        //This data needs to be written (Object[])
        Map< String, Object[] > newInfo = new TreeMap<>();
        newInfo.put( "1", new Object[] {
                "Идентификатор записи:",
                null,
                null,
                null,
                guid });

        newInfo.put( "2", new Object[] {
                "Дата и время создания отчета:",
                null,
                null,
                null,
                mths._currentDateTime() });

        newInfo.put( "3", new Object[] {
                null,
                "Дата",
                null,
                "Федерация",
                null,
                "Чемпионат",
                null,
                "Дивизион",
                null,
                "Игры",
                null,
                "Админ",
                null, });

        newInfo.put( "4", new Object[] {
                null,
                txtf_date_toWrite,
                null,
                txtf_federation_toWrite,
                null,
                txtf_champ_toWrite,
                null,
                txtf_division_toWrite,
                null,
                txtf_games_toWrite,
                null,
                txtf_admin_toWrite,
                null});

        newInfo.put( "5", new Object[] {
                null,
                "test1 2 3 444 0,5%%",
                null,
                "hellow"});

        //Iterate over data and write to sheet
        Set< String > keyid = newInfo.keySet();
        int rowid = 0;

        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object [] objectArr = newInfo.get(key);
            int cellid = 0;

            for (Object obj : objectArr){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        //Write the workbook in file system
        String filePath = "C:/ftbl/test/";
        String fileName = "Report "+ mths._currentDateTime()+".xlsx";
        FileOutputStream out = new FileOutputStream(new File(filePath+fileName));

        workbook.write(out);
        out.close();
        JOptionPane.showMessageDialog(null, Messages.textInfoConfirmSaveOk+guid);
    }
}