package utils;

import org.testng.Assert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileReader {
	public Properties properties;
	
	public FileReader(String file){
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);
		properties = new Properties();
		try {
			if (file.contains(".properties")){
				properties.load(inputStream);
			}
			else {
				properties.load(new InputStreamReader(inputStream, "UTF-8"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getValue(String key){
		return properties.getProperty(key)==null ? null :convertUTF(properties.getProperty(key));
	}
	
	public String getAnyVal(String key){
		return System.getProperty(key)!=null ? System.getProperty(key)
				: getValue(key);
	}
	public  static String convertUTF(String origin){
		String convert = null;
		try {
			convert = new String(origin.getBytes("ISO-8859-1"), "UTF-8");
		}
		catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
		
		return convert;
	}
	
	public Properties getProperties() {
		return this.properties;
	}
	
	public static Object[][] dataProviderFile(String filePath) {
		List<String> list = listReader(filePath);
		Object[][] objects = new Object[list.size()][1];
		
		for(int i = 0; i < list.size(); ++i) {
			objects[i][0] = list.get(i);
		}
		
		return objects;
	}
	public static List<String> listReader(String fileLocation) {
		ArrayList myList = new ArrayList();
		
		try {
			BufferedReader in = new BufferedReader(new java.io.FileReader("src/test/resources/properties/" + fileLocation));
			
			String str;
			while((str = in.readLine()) != null) {
				myList.add(str);
			}
			
			in.close();
		} catch (IOException var4) {
			Assert.assertTrue(false, "Catch an exception " + var4);
		}
		
		return myList;
	}
}
