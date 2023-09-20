package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.AssetExcel;
import com.bassure.ims.productservice.service.ExcelService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExcelServiceImpl implements ExcelService {

//    @Autowired
//    private MongoOperations mongoOperations;


    @Override
    public List<AssetExcel> uploadExcelFile(MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        List<AssetExcel> assetExcels = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet worksheet = workbook.getSheetAt(0); // Assuming you want the first sheet (index 0)

            for (Row row : worksheet) {
                if (row.getRowNum() > 0) { // Skip the header row
                    Map<String, Object> rowDataMap = new HashMap<>();
                    boolean hasNonEmptyCell = false;

                    try {
                        for (int i = 0; i <= 34; i++) {
                            Cell cell = row.getCell(i);
                            String cellValue = "";

                            if (cell != null) {
                                CellType cellType = cell.getCellType();

                                if (cellType == CellType.NUMERIC) {
                                    if (cell.getNumericCellValue() != 0) {
                                        cellValue = String.valueOf((int) cell.getNumericCellValue());
                                        hasNonEmptyCell = true;
                                    }
                                } else if (cellType == CellType.STRING) {
                                    if (!cell.getStringCellValue().isEmpty()) {
                                        cellValue = cell.getStringCellValue();
                                        hasNonEmptyCell = true;
                                    }
                                }
                            }

                            rowDataMap.put("Cell_" + i, cellValue);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    if (hasNonEmptyCell) {
                        AssetExcel asserts = getAssertExcel(rowDataMap);
                        System.out.println(asserts);
                        assetExcels.add(asserts);
                    }
                }
            }

            if (!assetExcels.isEmpty()) {
                return assetExcels;
            } else {
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static AssetExcel getAssertExcel(Map<String, Object> rowDataMap) {
        AssetExcel asserts = new AssetExcel();
        for (Map.Entry<String, Object> rowToAssert : rowDataMap.entrySet()) {

            switch (rowToAssert.getKey()) {
                case "Cell_0":
                    System.out.println(rowToAssert.getValue());
                    asserts.setEmpCode((Integer.parseInt(rowToAssert.getValue().toString())));
                    break;
                case "Cell_1":
                    System.out.println(rowToAssert.getValue());
                    asserts.setUserName((String) rowToAssert.getValue());
                    break;
                case "Cell_2":
                    System.out.println(rowToAssert.getValue());
                    asserts.setBatch((String) rowToAssert.getValue());
                    break;
                case "Cell_3":
                    System.out.println(rowToAssert.getValue());
                    asserts.setHostName((String) rowToAssert.getValue());
                    break;
                case "Cell_4":
                    System.out.println(rowToAssert.getValue());
                    asserts.setOffice365Licence((String) rowToAssert.getValue());
                    break;
                case "Cell_5":
                    System.out.println(rowToAssert.getValue());
                    asserts.setItem((String) rowToAssert.getValue());
                    break;
                case "Cell_6":
                    System.out.println(rowToAssert.getValue());
                    asserts.setMakeManufacturer((String) rowToAssert.getValue());
                    break;
                case "Cell_7":
                    System.out.println(rowToAssert.getValue());
                    asserts.setModel((String) rowToAssert.getValue());
                    break;
                case "Cell_8":
                    System.out.println(rowToAssert.getValue());
                    asserts.setLaptopTypeNumber((String) rowToAssert.getValue());
                    break;
                case "Cell_9":
                    System.out.println(rowToAssert.getValue());
                    asserts.setSerialNumber((String) rowToAssert.getValue());
                    break;
                case "Cell_10":
                    System.out.println(rowToAssert.getValue());
                    asserts.setOperatingSystem((String) rowToAssert.getValue());
                    break;
                case "Cell_11":
                    System.out.println(rowToAssert.getValue());
                    asserts.setProcessor((String) rowToAssert.getValue());
                    break;
                case "Cell_12":
                    System.out.println(rowToAssert.getValue());
                    asserts.setSystemName((String) rowToAssert.getValue());
                    break;
                case "Cell_13":
                    System.out.println(rowToAssert.getValue());
                    asserts.setHardDiskType((String) rowToAssert.getValue());
                    break;
                case "Cell_14":
                    System.out.println(rowToAssert.getValue());
                    asserts.setHardDiskCapacity((String) rowToAssert.getValue());
                    break;
                case "Cell_15":
                    System.out.println(rowToAssert.getValue());
                    asserts.setTotalRamSlots(Integer.parseInt(rowToAssert.getValue().toString()));
                    break;
                case "Cell_16":
                    System.out.println(rowToAssert.getValue());
                    asserts.setSlotsAvailable(Integer.parseInt(rowToAssert.getValue().toString()));
                    break;
                case "Cell_17":
                    System.out.println(rowToAssert.getValue());
                    asserts.setSlot1Capacity((String) rowToAssert.getValue());
                    break;
                case "Cell_18":
                    System.out.println(rowToAssert.getValue());
                    asserts.setSlot2Capacity((String) rowToAssert.getValue());
                    break;
                case "Cell_19":
                    System.out.println(rowToAssert.getValue());
                    asserts.setSlot3Capacity((String) rowToAssert.getValue());
                    break;
                case "Cell_20":
                    System.out.println(rowToAssert.getValue());
                    asserts.setSlot4Capacity((String) rowToAssert.getValue());
                    break;
                case "Cell_21":
                    System.out.println(rowToAssert.getValue());
                    asserts.setDdr((String) rowToAssert.getValue());
                    break;
                case "Cell_22":
                    System.out.println(rowToAssert.getValue());
                    asserts.setSpeed((String) rowToAssert.getValue());
                    break;
                case "Cell_23":
                    System.out.println(rowToAssert.getValue());
                    asserts.setUpdatedRamSpeed((String) rowToAssert.getValue());
                    break;
                case "Cell_24":
                    System.out.println(rowToAssert.getValue());
                    asserts.setPurchasedDate((String) rowToAssert.getValue());
                    break;
                case "Cell_25":
                    System.out.println(rowToAssert.getValue());
                    asserts.setSoldBy((String) rowToAssert.getValue());
                    break;
                case "Cell_26":
                    System.out.println(rowToAssert.getValue());
                    asserts.setVendorContactsNumber(Long.parseLong((String) rowToAssert.getValue()));
                    break;
                case "Cell_27":
                    System.out.println(rowToAssert.getValue());
                    asserts.setVendorMailID((String) rowToAssert.getValue());
                    break;
                case "Cell_28":
                    System.out.println(rowToAssert.getValue());
                    asserts.setVendorGST((String) rowToAssert.getValue());
                    break;
                case "Cell_29":
                    System.out.println(rowToAssert.getValue());
                    asserts.setBillingAddress((String) rowToAssert.getValue());
                    break;
                case "Cell_30":
                    System.out.println(rowToAssert.getValue());
                    asserts.setShippingAddress((String) rowToAssert.getValue());
                    break;
                case "Cell_31":
                    System.out.println(rowToAssert.getValue());
                    asserts.setWarrantyStatus((String) rowToAssert.getValue());
                    break;
                case "Cell_32":
                    System.out.println(rowToAssert.getValue());
                    asserts.setWarrantyFrom((String) rowToAssert.getValue());
                    break;
                case "Cell_33":
                    System.out.println(rowToAssert.getValue());
                    asserts.setWarrantyTo((String) rowToAssert.getValue());
                    break;
                case "Cell_34":
                    System.out.println(rowToAssert.getValue());
                    asserts.setTotalAmount(Double.parseDouble((String) rowToAssert.getValue()));
                    break;
                default:
                    return null;
            }
        }
        return asserts;
    }
}
