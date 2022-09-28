//  Procedure to write data into an excel file

// Create new records to update in excel file 
Object[][] dataToWrite = {
  {"rowData", "rowData","rowData"},
  {"rowData","rowData","rowData"}
};

//  Create file object of existing excel file
File fileName = new File("NAME_OF_THE_EXCEL_FILE");

//  Create input stream to read contents to
FileInputStream file = new FileInputStream(fileName);

//  Create workbook from input stream
XSSFWorkbook workbook = new XSSFWorkbook(file);

//  Reading first sheet of excel file
XSSFSheet sheet = workbook.getSheet("Name_of_sheet_which_you_want_to_read");

//  Getting the last row number of existing records
int rowCount = sheet.getLastRowNum();

//  Iterating through dataToWrite to update
for (Object[] data : dataToWrite) {
                 
//Creating new row from the next row count
Row row = sheet.createRow(++rowCount);
 
int columnCount = 0;
 
//Iterating informations
for (Object info : data) {     
  //Creating new cell and setting the value
  Cell cell = row.createCell(columnCount++);
  if (info instanceof String) {
    cell.setCellValue((String) info);
  } else if (info instanceof Integer) {
    cell.setCellValue((Integer) info);
}
}

//  Close input stream
inputStream.close();

//  Creating output stream and writing the updated workbook
FileOutputStream os = new FileOutputStream(fileName);
workbook.write(os);

//  Close the workbook and output stream
workbook.close();
os.close();
