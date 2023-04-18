package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consist of generic method realated to excel file
 * @author sowmya
 *
 */

public class ExcelFileUtility {
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws IOException
	 */
	public String readDataFromExcelSheet(String sheetName, int rowNum, int cellNum) throws IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		Cell cel=row.getCell(cellNum);
		String value=cel.getStringCellValue();
		return value;
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeIntoExcel(String sheetName,int rowNum,int cellNum,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetName);
		Row row=sh.createRow(rowNum);
		Cell cel=row.createCell(cellNum);
		cel.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IConstantsUtility.excelFilePath);
		book.write(fos);
		book.close();
	}

	
	
	public Object[][] readDataFromExcelToDataProvider(String sheetName) throws Exception, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
}
