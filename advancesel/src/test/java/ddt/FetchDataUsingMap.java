package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class FetchDataUsingMap
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet5");
		int row = sheet.getLastRowNum();
		System.out.println(row);
		
	    LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
	    for(int i=0;i<row;i++) {
	    	String key = sheet.getRow(i).getCell(0).toString();
	    	String value = sheet.getRow(i).getCell(1).toString();	
	    	map.put(key, value);
	    	}
	    for(Entry<String, String>m:map.entrySet()) 
	    {
	    System.out.println(m.getKey()+":"+m.getValue());
		
	}
	}

}
