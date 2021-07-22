package cn.jonhon.communication.optical.fiber.dcp.weidu.single.easyexcel.controller;

import cn.jonhon.communication.optical.fiber.dcp.weidu.single.model.DataModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
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


}
