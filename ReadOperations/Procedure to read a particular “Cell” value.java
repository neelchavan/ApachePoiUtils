// Procedure to read a particular “Cell” value
//  Read the excel file using FileInputStream to obtain input bytes from a file.

File fileName = new File (“Path_of_ excel_file_which_you_want_to_read”)
FileInputStream file = new FileInputStream(fileName);

// Create workbook instance holding reference to .xlsx file 

XSSFWorkbook workbook = new XSSFWorkbook(file);

// Get desired worksheet name from the workbook

XSSFSheet sheet = workbook.getSheet("Name_of_sheet_which_you_want_to_read");

//  Get the row from which you want to read the cell data

XSSFRow row = sheet.getRow(rowIndex);

// Get the Cell value by passing the column index 

XSSFCell  cell = row.getCell(colIndex);

// Print the cell value


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