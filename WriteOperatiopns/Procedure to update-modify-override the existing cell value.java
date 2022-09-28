// Procedure to update/modify/override the existing cell value
// Creating file object of existing excel file

File fileName = new File("NAME_OF_THE_EXCEL_FILE");

//  Creating input stream
FileInputStream file = new FileInputStream(fileName);

//  Creating workbook from input stream
XSSFWorkbook workbook = new XSSFWorkbook(file);

//  Reading first sheet of excel file
XSSFSheet sheet =  workbook.getSheet("Name_of_sheet_which_you_want_to_read");

//  Get the Cell number using getRow and getCell
XSSFCell cell2Update = sheet.getRow(rowIndex).getCell(colIndex);

//  Update the cell 
cell2Update.setCellValue(data);

//  Close input stream
inputStream.close();

//  Creating output stream and writing the updated workbook
FileOutputStream os = new FileOutputStream(fileName);
workbook.write(os);

//  Close the workbook and output stream
workbook.close();
os.close();