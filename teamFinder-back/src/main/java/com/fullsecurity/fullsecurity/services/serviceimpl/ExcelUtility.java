//package com.fullsecurity.fullsecurity.services.serviceimpl;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import com.fullsecurity.fullsecurity.models.ExcelTest;
//import com.fullsecurity.fullsecurity.repository.ExcelRepository;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.web.multipart.MultipartFile;
//
//public class ExcelUtility {
//    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//    //    static String[] HEADERs = { "ID", "Student Name", "Email", "Mobile No." };
//    static String SHEET = "Sheet1";
//
//    public static boolean hasExcelFormat(MultipartFile file) {
//        if (!TYPE.equals(file.getContentType())) {
//            return false;
//        }
//        return true;
//    }
//
//
//    public static List<ExcelTest> excelToStuList(InputStream is) {
//        try {
//            Workbook workbook = new XSSFWorkbook(is);
//            Sheet sheet = workbook.getSheet(SHEET);
//            Iterator<Row> rows = sheet.iterator();
//            List<ExcelTest> stuList = new ArrayList<ExcelTest>();
//            int rowNumber = 0;
//            while (rows.hasNext()) {
//                Row currentRow = rows.next();
//                // skip header
//                if (rowNumber == 0) {
//                    rowNumber++;
//                    continue;
//                }
//                System.out.println("current row number " + currentRow.getRowNum()); // get row number
//                ExcelTest stu = new ExcelTest();
//                for (int cellIdx = 0; cellIdx < currentRow.getLastCellNum(); cellIdx++) {
//                    Cell currentCell = currentRow.getCell(cellIdx, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//                    System.out.println("current cell " + currentCell.getCellType());
//                    switch (cellIdx) {
//                        case 0:
//                            if (currentCell.getCellType() != CellType.BLANK) {
//                                stu.setNid(currentCell.getStringCellValue());
//                            } else {
//                                throw new IllegalArgumentException("Cell at row " + (currentRow.getRowNum() + 1) + " and column " + (cellIdx + 1) + " is empty or not a string value.");
//                            }
//                            break;
//                        case 1:
//                            if (currentCell.getCellType() != CellType.BLANK) {
//                                stu.setFirstName(currentCell.getStringCellValue());
//                            } else {
//                                throw new IllegalArgumentException("Cell at row " + (currentRow.getRowNum() + 1) + " and column " + (cellIdx + 1) + " is empty or not a string value.");
//                            }
//                            break;
//                        case 2:
//                            if (currentCell.getCellType() != CellType.BLANK) {
//                                stu.setLastName(currentCell.getStringCellValue());
//                            } else {
//                                throw new IllegalArgumentException("Cell at row " + (currentRow.getRowNum() + 1) + " and column " + (cellIdx + 1) + " is empty or not a string value.");
//                            }
//                            break;
//                        case 3:
//                            if (currentCell.getCellType() != CellType.BLANK) {
//                                stu.setPosition(currentCell.getStringCellValue());
//                            } else {
//                                throw new IllegalArgumentException("Cell at row " + (currentRow.getRowNum() + 1) + " and column " + (cellIdx + 1) + " is empty or not a string value.");
//                            }
//                            break;
//                        default:
//                            break;
//                    }
//                }
//                stuList.add(stu);
//            }
//            workbook.close();
//            return stuList;
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to parse Excel file: " + e.getMessage());
//        }
//    }
//}