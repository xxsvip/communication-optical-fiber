package cn.jonhon.communication.optical.fiber.dcp.weidu.single.poi.controller;

import cn.jonhon.communication.optical.fiber.dcp.weidu.single.model.DataModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xingxiaoshuai
 */
@RestController
public class ExcelPoiController {


    @GetMapping("readByPoi")
    public String readByPoi() throws Exception {


        List<File> fileList = new ArrayList<>();


        File directory = new File("/Users/xingxiaoshuai/Desktop/");
        for (File file : directory.listFiles()) {
            String fileName = file.getName();
            if(fileName.endsWith("xlsx")  && fileName.split("_").length == 6){
                fileList.add(file);
            }
        }

        List<File> sortedList = fileList.stream().sorted(Comparator.comparing(File::lastModified).reversed()).collect(Collectors.toList());

        File targetFile = sortedList.get(1);
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(targetFile));
        XSSFSheet sheet = wb.getSheetAt(0);


        List<DataModel> list = new ArrayList<>();

        for (Row row : sheet) {
            //从第13行开始进行读取
            if(row.getRowNum()>=12) {
                DataModel dataModel = new DataModel();
                for (Cell cell : row) {


                    if(cell.getColumnIndex() == 0){dataModel.setSn(cell.getStringCellValue());}
                    if(cell.getColumnIndex() == 2){dataModel.setSn_customer(cell.getStringCellValue());}
                    if(cell.getColumnIndex() == 3){
                        Date date = DateUtil.getJavaDate(cell.getNumericCellValue());
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        dataModel.setDate(sdf.format(date));
                    }
                    if(cell.getColumnIndex() == 4){
                            Date date = DateUtil.getJavaDate(cell.getNumericCellValue());
                            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                            dataModel.setTime(sdf.format(date));
                    }
                    if(cell.getColumnIndex() == 6){dataModel.setStatus(cell.getStringCellValue());}
                    if(cell.getColumnIndex() == 7){dataModel.setRoc(cell.getNumericCellValue());}
                    if(cell.getColumnIndex() == 8){dataModel.setAo(cell.getNumericCellValue());}
                    if(cell.getColumnIndex() == 9){dataModel.setFiberHeight(cell.getNumericCellValue());}
                    if(cell.getColumnIndex() == 10){dataModel.setAa(cell.getNumericCellValue());}

                    list.add(dataModel);
                }
            }
        }


        for (DataModel dataModel : list) {
            System.out.println(dataModel);
        }




        return "poi";

    }

}
