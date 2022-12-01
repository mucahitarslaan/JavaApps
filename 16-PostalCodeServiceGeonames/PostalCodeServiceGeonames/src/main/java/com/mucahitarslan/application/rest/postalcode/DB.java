package com.mucahitarslan.application.rest.postalcode;

import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCode;
import com.mucahitarslan.application.rest.postalcode.geonames.json.dto.PostalCodeDTO;
import com.mucahitarslan.application.rest.postalcode.mapper.IPostalCodeInfoMapper;
import com.mucahitarslan.application.rest.postalcode.mapper.IPostalCodeMapper;
import com.mucahitarslan.application.rest.postalcode.service.PostalCodeAppService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Component
public class DB implements ApplicationRunner
{
    private final PostalCodeAppService postalCodeAppService;
    private final IPostalCodeMapper postalCodeMapper;

    public DB(PostalCodeAppService postalCodeAppService, IPostalCodeMapper postalCodeMapper) {
        this.postalCodeAppService = postalCodeAppService;
        this.postalCodeMapper = postalCodeMapper;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        addDatas();
    }

    public void addDatas() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("pk_20220810.xlsx");
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();

        while (iterator.hasNext())
        {
            try {
                String iteratorStr = iterator.next().getCell(0).getStringCellValue();
                List<PostalCodeDTO> pCode = postalCodeAppService.findPostalCodeInfoByPostalCode(iteratorStr);
                System.out.println("işlem başladı");
                for (PostalCodeDTO pc : pCode)
                {
                    postalCodeAppService.saveDatas(postalCodeMapper.toPostalCodeInfo(pc));
                    System.out.println("Eklendi" + pc.adminCode1);
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("işlem bitti");
    }
}
