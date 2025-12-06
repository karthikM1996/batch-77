package genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String ToReadDataFromExcel(String sheetName,int rownum,int cellnum) throws IOException
	{
		
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestScrpitData.xls.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet(sheetName);
		 Row name = sheet.getRow(rownum);
		 String value = name.getCell(cellnum).getStringCellValue();
		 return value;
		 
	
	}
}
