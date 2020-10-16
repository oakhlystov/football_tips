package ftblApp_tips_v02.excel;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Writer
{
    public static void writeToExcel(String text1, String text2, String text3, String requiredDate) throws Exception
    {
        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet( "Report");

        //Create row object
        XSSFRow row;

        //This data needs to be written (Object[])
        Map< String, Object[] > empinfo = new TreeMap<>();
        empinfo.put( "1", new Object[] {
                text1, text2, text3 });

        empinfo.put( "2", new Object[] {
                "tp01", "Gopal", "Technical Manager" });

        empinfo.put( "3", new Object[] {
                "tp02", "Manisha", "Proof Reader" });

        empinfo.put( "4", new Object[] {
                "tp03", "Masthan", "Technical Writer" });

        empinfo.put( "5", new Object[] {
                "tp04", "Satish", "Technical Writer" });

        empinfo.put( "6", new Object[] {
                "tp05", "Krishna", "Technical Writer" });

        //Iterate over data and write to sheet
        Set< String > keyid = empinfo.keySet();
        int rowid = 0;

        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object [] objectArr = empinfo.get(key);
            int cellid = 0;

            for (Object obj : objectArr){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        //String filename = "Writesheet.xlsx";
        //Write the workbook in file system
        String fileName = "Report "+requiredDate+".xlsx";
        String filePath = "C:/ftbl/test/";
        FileOutputStream out = new FileOutputStream(
                new File(filePath+fileName));

        workbook.write(out);
        out.close();
        System.out.println("Writesheet.xlsx written successfully");
    }
}