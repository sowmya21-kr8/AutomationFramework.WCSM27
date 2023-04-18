package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {
public static void main(String[] args) throws IOException {
	
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet("Organization");
	Row row=sh.getRow(1);
	Cell cel=row.createCell(7);
	cel.setCellValue("rudregowda");
	FileOutputStream fos=new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\TestData.xlsx");
	book.write(fos);
	System.out.println("data added");
	book.close();
}
}
