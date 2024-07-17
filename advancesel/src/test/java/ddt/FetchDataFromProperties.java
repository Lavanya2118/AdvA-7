package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromProperties
{
	public static void main(String[] args) throws IOException {
		
		//1.create a fileinputstreamobject
		FileInputStream fis= new FileInputStream("./src/test/resources/pro.properties");
		
		//2.create a property file object
				Properties p=new Properties();
				
		//3.load file
				p.load(fis);
				
		//4.fetch the data
				System.out.println(p.getProperty("url"));
				System.out.println(p.getProperty("usname"));
				System.out.println(p.getProperty("pwd"));
	}

}
