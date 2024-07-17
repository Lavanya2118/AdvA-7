package ddt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InsertDataInProperty
{
	public static void main(String[] args) throws IOException 
	{
		Properties p= new Properties();
		p.setProperty("url", "https://demowebshoptricentis.com/");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/prop1.properties");
		p.store(fos, "prop1");
		System.out.println("values is insert");
		
	}

}
