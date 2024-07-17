package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataInExcel
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		wb.getSheet("Sheet2").createRow(0).createCell(0).setCellValue("automation");
		wb.getSheet("Sheet2").createRow(4).createCell(6).setCellValue("selenium");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/exceldata.xlsx");
		wb.write(fos);
		wb.close();	
		
		System.out.println(wb.getSheet("Sheet2").getRow(0).getCell(0).getStringCellValue());
	}

}
