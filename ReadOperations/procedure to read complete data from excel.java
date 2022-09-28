// Procedure to read complete data from excel
// Read the Excel file using FileInputStream to obtain input bytes from a file

File fileName = new File (�Path_of_ excel_file_which_you_want_to_read�)
FileInputStream file = new FileInputStream(fileName);

// Create workbook instance holding reference to .xlsx file 

XSSFWorkbook workbook = new XSSFWorkbook(file);

// Get desired worksheet name from the workbook

XSSFSheet sheet = workbook.getSheet("Name_of_sheet_which_you_want_to_read");

// Get the last row number 

int rowsCount = sheet.getLastRowNum();

//  5)  Get the last cell number

int colsCount = sheet.getRow(1).getLastCellNum();

//  6) Use a for loop to iterate the row

// outer for loop to iterate each row
for (int outer = 0; outer <= rowCount; outer++) {
  XSSFRow rows = sheet.getRow(outer);
	// inner for loop to iterate each cell
	for (int inner = 0; inner < colsCount; inner++) {
		XSSFCell cell = rows.getCell(inner);
		  switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				default:
					break;
				}
				System.out.print(" | ");
		}
		System.out.println();
}