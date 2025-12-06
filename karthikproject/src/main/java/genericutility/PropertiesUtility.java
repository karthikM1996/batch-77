package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	
	public String toReadTheDataFromPropertiesfile(String key) throws Exception
	{
		
		FileInputStream fis=new FileInputStream("D:\\karthik_workspace\\karthikproject\\src\\test\\resources\\commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
	}

}
