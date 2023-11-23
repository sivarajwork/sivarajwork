package Heliosz_Service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class Campaign_Name_Excel_File {

	public static void main(String[] args) throws IOException {
		
		//obtaining input bytes from a file  
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\sivaraj\\eclipse-workspace\\API_Test\\target\\Campaign_Name_Data.xlsx"));  
		//creating workbook instance that refers to .xls file  
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		int Sheets = wb.getNumberOfSheets();
		
		//System.out.println(Sheets);
		
		for(int i=0;i<Sheets;i++) {
			
			if(wb.getSheetName(i).equalsIgnoreCase("Campaign_Name_Data")) {
				
				XSSFSheet sheet = wb.getSheetAt(i);
				
				Iterator<Row> row = sheet.iterator();
				 
				Row firstrow = row.next();
				
				Iterator<Cell> cell_value = firstrow.cellIterator();
				
				int k=0;
				int coloumn = 0;
				
				while(cell_value.hasNext()) {
					
					Cell next = cell_value.next();
					if(next.getStringCellValue().equalsIgnoreCase("CampaignName"))
					
					{
						coloumn=k;
						
					}
					
					k++;
					
				}
				
				System.out.println(coloumn);
				
				while(row.hasNext()) {
					
					Row next_value = row.next();
					
					if(next_value.getCell(coloumn).getStringCellValue().equalsIgnoreCase("Paid Search_Brand A_Triad_Face_43178")){
						
						
					}
				}
			}
			
		}
		
	}

}
