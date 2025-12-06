package genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String toReadDataFromExcel(String sheetname, int rownum, int cellnum) throws IOException
	{
		
		 FileInputStream f=new FileInputStream("D:\\karthik_workspace\\karthikproject\\src\\test\\resources\\kscript.xls.xlsx");
	     Workbook wb = WorkbookFactory.create(f);
	     String data = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	     return data;
		
	}

}
