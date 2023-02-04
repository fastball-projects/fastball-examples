package dev.fastball.example.common.model;

import dev.fastball.core.annotation.Field;
import dev.fastball.core.annotation.Lookup;
import dev.fastball.core.annotation.TreeLookup;
import dev.fastball.core.component.Range;
import dev.fastball.core.info.basic.ValueType;
import dev.fastball.example.common.dict.OrgType;
import dev.fastball.example.ui.action.EmployeeLookupAction;
import dev.fastball.example.ui.action.OrgTreeLookupAction;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 * @author gr@fastball.dev
 * @since 2023/1/29
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AllFormFieldModel {

    @Field(title = "文本")
    private String text;

    @Field(title = "多行文本", type = ValueType.TEXTAREA)
    private String textarea;

    @Field(title = "数字")
    private Integer number;

    @Field(title = "金额", type = ValueType.MONEY)
    private BigDecimal money;

    @Field(title = "日期")
    private Date date;

    @Field(title = "日期区间")
    private Range<Date> dateRange;

    @Field(title = "日期时间", type = ValueType.DATE_TIME)
    private Date dateTime;

    @Field(title = "日期时间区间", type = ValueType.DATE_TIME)
    private Range<Date> dateTimeRange;

    @Field(title = "周选择器", type = ValueType.DATE_WEEK)
    private Date dateWeek;

    @Field(title = "月选择器", type = ValueType.DATE_MONTH)
    private Date dateMonth;

    @Field(title = "季度选择器", type = ValueType.DATE_QUARTER)
    private Date dateQuarter;

    @Field(title = "年选择器", type = ValueType.DATE_YEAR)
    private Date dateYear;

    @Field(title = "周区间", type = ValueType.DATE_WEEK_RANGE)
    private Range<String> dateWeekRange;

    @Field(title = "月区间", type = ValueType.DATE_MONTH_RANGE)
    private Range<String> dateMonthRange;

    @Field(title = "季度区间", type = ValueType.DATE_QUARTER_RANGE)
    private Range<String> dateQuarterRange;

    @Field(title = "年区间", type = ValueType.DATE_YEAR_RANGE)
    private Range<String> dateYearRange;

    @Field(title = "时间")
    private LocalTime time;

    @Field(title = "时间区间")
    private Range<LocalTime> timeRange;

    @Field(title = "单选枚举")
    private OrgType select;

    @Field(title = "多选枚举")
    private List<OrgType> multipleSelect;

    @Field(title = "单选(后台获取数据)")
    @Lookup(value = EmployeeLookupAction.class, labelField = "name", valueField = "id")
    private Integer lookupSelect;

    @Field(title = "多选(后台获取数据)")
    @Lookup(value = EmployeeLookupAction.class, labelField = "name", valueField = "id")
    private List<Integer> multipleLookupSelect;

    @Field(title = "树状单选(后台获取数据)")
    @TreeLookup(value = OrgTreeLookupAction.class, labelField = "name", valueField = "id", childrenField = "subOrg")
    private Integer treeLookupSelect;

    @Field(title = "树状多选(后台获取数据)")
    @TreeLookup(value = OrgTreeLookupAction.class, labelField = "name", valueField = "id", childrenField = "subOrg")
    private List<Integer> multipleTreeLookupSelect;
}
