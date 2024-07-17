package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 

public class FetchingDataFromExcel 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Cell cell1 = wb.getSheet("Sheet1").getRow(0).getCell(0);
		Cell cell2 = wb.getSheet("Sheet1").getRow(2).getCell(1);
		Cell cell3 = wb.getSheet("Sheet1").getRow(3).getCell(3);
		DataFormatter data= new DataFormatter();
		System.out.println(data.formatCellValue(cell1));
		System.out.println(data.formatCellValue(cell2));
		System.out.println(data.formatCellValue(cell3));
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		String url = wb.getSheet("Sheet1").getRow(5).getCell(1).getStringCellValue();
		driver.get(url);
		
	}

}
