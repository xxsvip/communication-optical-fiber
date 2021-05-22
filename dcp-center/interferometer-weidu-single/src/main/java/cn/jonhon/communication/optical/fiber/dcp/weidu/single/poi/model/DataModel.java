package cn.jonhon.communication.optical.fiber.dcp.weidu.single.poi.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author xingxiaoshuai
 */
@Data
public class DataModel {

    private String sn;

    private String sn_customer;

    private String date;

    private String time;

    private String status;

    private Double roc;

    private Double ao;

    private Double fiberHeight;

    private Double aa;


}
