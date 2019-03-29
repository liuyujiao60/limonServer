package com.limon.common.viewobject;

import com.limon.core.util.DateUtil;
import com.limon.core.util.RelativeDateFormatUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateVo {

    private String dateStr;
    private String dayStr;
    private Long time;
    private String relative;

    public DateVo(long timeStampe){
        Date date=new Date(timeStampe);
        this.dayStr=DateUtil.getStringDayByDate(date);
        this.dateStr=DateUtil.getStringDateByDate(date);
        this.time=timeStampe;
        this.relative= RelativeDateFormatUtil.format(date);
    }
}
