Procedure to read a particular Column from excel :

//  Read the excel file using FileInputStream to obtain input bytes from a file.

File fileName = new File (“Path_of_ excel_file_which_you_want_to_read”)
FileInputStream file = new FileInputStream(fileName);

// Create workbook instance holding reference to .xlsx file 

XSSFWorkbook workbook = new XSSFWorkbook(file);

// Get desired worksheet name from the workbook
 
XSSFSheet sheet = workbook.getSheet("Name_of_sheet_which_you_want_to_read");

//  Using foreach loop iterate over each row 

for (Row row : sheet) {
    // Using foreach loop iterate over each Cell of row
    for (Cell cell : row) {
        // Compare the column index for which you want print the values
        // if match found print the cell value
        if (cell.getColumnIndex() == columnIndex) {

            switch (cell.getCellType()) {
                case STRING:
                    System.out.println("|" + cell.getStringCellValue() + "|");
                    break;
                case NUMERIC:
                    System.out.println("|" + cell.getNumericCellValue() + "|");
                    break;
                case BOOLEAN:
                    System.out.println("|" + cell.getBooleanCellValue() + "|");
                    break;
                default:
                    break;
            }
        }
    }
}