package cn.jonhon.communication.optical.fiber.dcp.weidu.single.easyexcel.listener;

import cn.jonhon.communication.optical.fiber.dcp.weidu.single.easyexcel.model.DataModel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author xingxiaoshuai
 */
@Slf4j
public class ExcelListener extends AnalysisEventListener<DataModel> {


    @Getter
    @Setter
    private List<DataModel> datas = new ArrayList<>();

    @Override
    public void invoke(DataModel dataModel, AnalysisContext analysisContext) {
        if(Objects.equals("Fail",dataModel.getStatus())){


        }
//        analysisContext.readRowHolder().
//        System.out.println(dataModel);
        datas.add(dataModel);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("{}条数据，开始存储数据库！", datas.size());
        log.info("所有数据解析完成！");
    }
}
