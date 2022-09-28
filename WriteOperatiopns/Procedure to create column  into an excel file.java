// Procedure to create column  into an excel file

// Create new records to update in excel file 
List<Object> colValues = new ArrayList<Object>();
  colValues.add("Area (Km2)");
  colValues.add("3287000");
  colValues.add("54394");
  colValues.add("30688");
  colValues.add("302068");

//  Create file object of existing excel file
File fileName = new File("NAME_OF_THE_EXCEL_FILE");

//  Create input stream to read contents to
FileInputStream file = new FileInputStream(fileName);

//  Create workbook from input stream
XSSFWorkbook workbook = new XSSFWorkbook(file);

//  Reading first sheet of excel file
XSSFSheet sheet = workbook.getSheet("Name_of_sheet_which_you_want_to_read");

// Get all the rows
Iterator<Row> iterator = sheet.iterator();

// Iterating through colValues to add columns and its values.
//Iterate over column values which you want to add
for (Object colValue : colValues) {
  while (iterator.hasNext()) {
  Row currentRow = iterator.next();

// Create a new Cell in row
  Cell cell = currentRow.createCell(currentRow.getLastCellNum(), CellType.STRING);

// Set Cell value
  cell.setCellValue((String) colValue);
  break;
}
}

// Close input stream
inputStream.close();

// Creating output stream and writing the updated workbook
FileOutputStream os = new FileOutputStream(fileName);
workbook.write(os);

// Close the workbook and output stream
workbook.close();
os.close();