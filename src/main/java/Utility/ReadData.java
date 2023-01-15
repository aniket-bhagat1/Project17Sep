package Utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {

	public static String readPropertiesFile(String value) throws Exception {
		Properties p = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\amard\\eclipse-workspace\\Project17Sep\\TestData\\config.properties");
		p.load(file);
		return p.getProperty(value);
	}
	public static String readExcelFile(int row, int col) throws Exception, Exception {
		FileInputStream file = new FileInputStream("C:\\Users\\amard\\eclipse-workspace\\Project17Sep\\TestData\\Book1.xlsx");
		 Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
		 String value = excel.getRow(row).getCell(col).getStringCellValue();
		 return value;
	}
}
