package genericlib;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * the below method is used to fetch data from Property File
 */

public class ExcelUtil
{
	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis= new FileInputStream(IConstant.propertyFilePath);
		Properties p= new Properties();
		p.load(fis);
		return p.getProperty(key);
	}

/**
 * the below method is used to fetch the data from Excel File
 */
	public String getDataFromExcelFile(String sheetname, int rowNum, int colNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(IConstant.excelFilePath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		return sheet.getRow(rowNum).getCell(colNum).toString();
	}
	
	public String getDataFromExcelDF(String sheetname, int rowNum, int colNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(IConstant.excelFilePath);
		Workbook wb= WorkbookFactory.create(fis);
		Cell data = wb.getSheet(sheetname).getRow(rowNum).getCell(colNum);
		DataFormatter result= new DataFormatter();
		return result.formatCellValue(data);
	}
	
	public static String getCurrentTime() {
		LocalDateTime dateTime= LocalDateTime.now();
		String date = dateTime.toString().replace(":", "-");
		return date;
	}

	
	
}

