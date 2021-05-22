package cn.jonhon.communication.optical.fiber.dcp.weidu.single.easyexcel.controller;

import cn.jonhon.communication.optical.fiber.dcp.weidu.single.poi.model.DataModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xingxiaoshuai
 */
@RestController
public class ExcelController {


//    @GetMapping("/readByEasyExcel")
//    public String read() {
//
//
//        String  fileName = "/Users/xingxiaoshuai/Desktop/1_4_51987_21180368_WO-2103199005-2_1-Single.xlsx";
//
//
//        ExcelReader excelReader = null;
//        try {
//            excelReader = EasyExcel.read(fileName, DataModel.class, new ExcelListener()).headRowNumber(12).build();
//            ReadSheet readSheet = EasyExcel.readSheet(0).build();
//            excelReader.read(readSheet);
//        } finally {
//            if (excelReader != null) {
//                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
//                excelReader.finish();
//            }
//        }
//
//        return "success";
//    }



    @GetMapping("readByPoi")
    public String readByPoi() throws Exception {

        String  fileName = "/Users/xingxiaoshuai/Desktop/1_4_51987_21180368_WO-2103199005-2_1-Single.xlsx";



        File excelFile = new File(fileName);
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(excelFile));
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


//                    if(cell.getColumnIndex() == 4){dataModel.setTime(cell.getStringCellValue());}
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
