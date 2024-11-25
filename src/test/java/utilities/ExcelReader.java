package utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;

public class ExcelReader {

    /**
     * Reads data from the specified Excel sheet by name and returns it as a list of maps.
     * Each map represents a row, with column headers as keys and cell values as values.
     *
     * @param excelFilePath Path to the Excel file.
     * @param sheetName     Name of the sheet to read.
     * @return List of maps containing the data from the sheet.
     */
    public List<Map<String, String>> getData(String excelFilePath, String sheetName)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByName(excelFilePath, sheetName);
        return readSheet(sheet);
    }

    /**
     * Reads data from the specified Excel sheet by index and returns it as a list of maps.
     * Each map represents a row, with column headers as keys and cell values as values.
     *
     * @param excelFilePath Path to the Excel file.
     * @param sheetNumber   Index of the sheet to read (0-based).
     * @return List of maps containing the data from the sheet.
     */
    public List<Map<String, String>> getData(String excelFilePath, int sheetNumber)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
        return readSheet(sheet);
    }

    /**
     * Retrieves a sheet by its name from the specified Excel file.
     *
     * @param excelFilePath Path to the Excel file.
     * @param sheetName     Name of the sheet.
     * @return The Sheet object corresponding to the given name.
     */
    private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
        return getWorkBook(excelFilePath).getSheet(sheetName);
    }

    /**
     * Retrieves a sheet by its index from the specified Excel file.
     *
     * @param excelFilePath Path to the Excel file.
     * @param sheetNumber   Index of the sheet (0-based).
     * @return The Sheet object corresponding to the given index.
     */
    private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
        return getWorkBook(excelFilePath).getSheetAt(sheetNumber);
    }

    /**
     * Creates a Workbook object from the specified Excel file.
     *
     * @param excelFilePath Path to the Excel file.
     * @return The Workbook object.
     */
    private Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException {
        return WorkbookFactory.create(new File(excelFilePath));
    }

    /**
     * Reads the data from the given sheet and returns it as a list of maps.
     * Each map represents a row, with column headers as keys and cell values as values.
     *
     * @param sheet The Sheet object to read.
     * @return List of maps containing the sheet data.
     */
    private List<Map<String, String>> readSheet(Sheet sheet) {
        int totalRow = sheet.getPhysicalNumberOfRows(); // Total number of rows in the sheet.
        List<Map<String, String>> excelRows = new ArrayList<>();
        int headerRowNumber = getHeaderRowNumber(sheet); // Find the header row.
        if (headerRowNumber != -1) {
            int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum(); // Total number of columns.
            for (int currentRow = 1; currentRow <= totalRow; currentRow++) { // Start reading from row 1 (below headers).
                Row row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
                LinkedHashMap<String, String> columnMapData = new LinkedHashMap<>();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    columnMapData.putAll(getCellValue(sheet, row, currentColumn));
                }
                excelRows.add(columnMapData); // Add the row's data to the list.
            }
        }
        return excelRows;
    }

    /**
     * Determines the row number of the header row by checking for non-blank cells.
     *
     * @param sheet The Sheet object.
     * @return Row number of the header row, or -1 if no header row is found.
     */
    private int getHeaderRowNumber(Sheet sheet) {
        int totalRow = sheet.getLastRowNum();
        for (int currentRow = 0; currentRow <= totalRow; currentRow++) {
            Row row = getRow(sheet, currentRow);
            if (row != null) {
                int totalColumn = row.getLastCellNum();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    Cell cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    // Check if the cell contains any value.
                    if (cell.getCellType() != CellType.BLANK) {
                        return row.getRowNum();
                    }
                }
            }
        }
        return -1; // Return -1 if no header row is found.
    }

    /**
     * Retrieves a Row object for the specified row number.
     *
     * @param sheet     The Sheet object.
     * @param rowNumber Row number (0-based).
     * @return The Row object, or null if the row doesn't exist.
     */
    private Row getRow(Sheet sheet, int rowNumber) {
        return sheet.getRow(rowNumber);
    }

    /**
     * Reads the value of a specific cell and maps it to its corresponding header.
     *
     * @param sheet         The Sheet object.
     * @param row           The Row object.
     * @param currentColumn Column index (0-based).
     * @return A LinkedHashMap containing the header as the key and the cell value as the value.
     */
    private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
        LinkedHashMap<String, String> columnMapData = new LinkedHashMap<>();
        Cell cell = (row == null) 
            ? null 
            : row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

        // Retrieve column header.
        String columnHeaderName = sheet.getRow(sheet.getFirstRowNum())
            .getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();

        if (cell == null || cell.getCellType() == CellType.BLANK) {
            columnMapData.put(columnHeaderName, "");
        } else if (cell.getCellType() == CellType.STRING) {
            columnMapData.put(columnHeaderName, cell.getStringCellValue());
        } else if (cell.getCellType() == CellType.NUMERIC) {
            columnMapData.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            columnMapData.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
        } else if (cell.getCellType() == CellType.ERROR) {
            columnMapData.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
        }
        return columnMapData;
    }
}
