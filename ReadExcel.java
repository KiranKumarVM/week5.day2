package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] getExcel(String filename) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./Data/"+filename+".xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");
		int rowCount = ws.getLastRowNum();
		int cellCount = ws.getRow(1).getLastCellNum();
		String[][] data = new String[rowCount][cellCount];
		for(int i=1; i<=rowCount; i++)
		{
			for(int j=0; j<cellCount; j++) {
				String stringCellValue = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(stringCellValue);
				data[i-1][j]=stringCellValue;
			}
		}
		wb.close();
		return data;
	}

}
