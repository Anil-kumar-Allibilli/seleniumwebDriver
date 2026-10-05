package day41DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertyFile {

	public static void main(String[] args) throws IOException 
	{
		//create property file
		Properties prop = new Properties();
		
		//location of property file
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "\\TestDataFolder\\config.properties");
		
		prop.load(fi); //loads property file means it Reads a property list (key and element pairs) from the input byte stream. 
		
		//read data from property file 
		String browser = prop.getProperty("browser");
		
		//read keys from property file 
		Set<String> listifKyes = prop.stringPropertyNames();   //or //Set<Object> listifKyes = prop.keySet();
		System.out.println(listifKyes);
		
		//read values 
		Collection<Object> values = prop.values();
		System.out.println(values);
		fi.close();
	}

}
