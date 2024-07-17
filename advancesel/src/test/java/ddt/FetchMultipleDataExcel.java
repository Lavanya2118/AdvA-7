package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataExcel
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet3");
		int rolNum = sheet.getPhysicalNumberOfRows();
		int colNum = sheet.getRow(0).getPhysicalNumberOfCells();
		for(int i=0;i<rolNum;i++) {
			for(int j=0;j<colNum;j++) {
				Cell data = sheet.getRow(i).getCell(j);
				DataFormatter datas=new DataFormatter();
				System.out.println(datas.formatCellValue(data));
			}
		}
		
		
		
	}

}
