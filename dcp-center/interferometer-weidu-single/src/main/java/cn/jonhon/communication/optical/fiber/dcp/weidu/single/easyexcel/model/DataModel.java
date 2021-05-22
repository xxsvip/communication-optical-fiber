package cn.jonhon.communication.optical.fiber.dcp.weidu.single.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author xingxiaoshuai
 */
@Data
public class DataModel {


    @ExcelProperty(index = 0)
    private String sn;

    @ExcelProperty(index = 2)
    private String sn_customer;

    @ExcelProperty(index = 3)
    private String date;

    @ExcelProperty(index = 4)
    private String time;

    @ExcelProperty(index = 6)
    private String status;

    @ExcelProperty(index = 7)
    private Double roc;

    @ExcelProperty(index = 8)
    private Double ao;

    @ExcelProperty(index = 9)
    private Double fiberHeight;

    @ExcelProperty(index = 10)
    private Double aa;


}
