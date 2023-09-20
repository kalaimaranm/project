package com.bassure.ims.productservice.serviceImplementation;

import com.bassure.ims.productservice.entity.Customer;
import com.bassure.ims.productservice.entity.Sequence;
import com.bassure.ims.productservice.repository.CustomerRepo;
import com.bassure.ims.productservice.service.ExcelService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private MongoOperations mongo;

    @Autowired
    private MongoOperations mongoOperations;

    public long generateSequence(String seqName) {
        Query query = new Query(Criteria.where("_id").is(seqName));
        Update update = new Update().inc("seq", 1);
        Sequence sequence = mongoOperations.findAndModify(query, update, Sequence.class);
        return sequence.getSeq();
    }

    @Override
    public String uploadExcelFile(MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        List<Customer> customers = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {

            Sheet worksheet = workbook.getSheetAt(3);

            worksheet.forEach(row -> {
                if (row.getRowNum() > 0) {
                    Cell cell1 = row.getCell(0);
                    Cell cell2 = row.getCell(1);
                    Cell cell3 = row.getCell(2);
                    Cell cell4 = row.getCell(3);

                    if (cell1 != null && cell1.getCellType() == CellType.NUMERIC
                            && cell2 != null && cell2.getCellType() == CellType.STRING
                            && cell3 != null && cell3.getCellType() == CellType.STRING
                            && cell4 != null && cell4.getCellType() == CellType.NUMERIC) {

                        Customer customerBuilder = Customer.builder()
                                .customerId((int) cell1.getNumericCellValue())
                                .firstName(cell2.getStringCellValue())
                                .country(cell3.getStringCellValue())
                                .phone((long) cell4.getNumericCellValue())
                                .build();
                        customers.add(customerBuilder);
                    }
                }
            });
            if (!customers.isEmpty()) {
                customerRepo.saveAll(customers);
                return "customer saved successfully";
            } else {
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
