Procedure to read a particular row from excel

// Read the excel file using FileInputStream to obtain input bytes from a file.

File fileName = new File (“Path_of_ excel_file_which_you_want_to_read”)
FileInputStream file = new FileInputStream(fileName);

// Create workbook instance holding reference to .xlsx file 

XSSFWorkbook workbook = new XSSFWorkbook(file);

// Get desired worksheet name from the workbook

XSSFSheet sheet = workbook.getSheet("Name_of_sheet_which_you_want_to_read");

// Get the desired row 

XSSFRow row = sheet.getRow(rowIndex);

// Iterate over over each cell using foreach loop and print the value using the right method based on the data type

for (Cell cell : row) {
    switch (cell.getCellType()) {
        case STRING:
            System.out.print(cell.getStringCellValue() + "|");
            break;
        case NUMERIC:
            System.out.print(cell.getNumericCellValue() + "|");
            break;
        case BOOLEAN:
            System.out.print(cell.getBooleanCellValue() + "|");
            break;
        default:
            break;
    }
}
