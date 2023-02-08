package dev.fastball.example.common.model;

import dev.fastball.core.annotation.Field;
import dev.fastball.core.annotation.Lookup;
import dev.fastball.core.info.basic.DisplayType;
import dev.fastball.core.info.basic.ValueType;
import dev.fastball.example.ui.action.EmployeeLookupAction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author gr@fastball.dev
 * @since 2023/1/9
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WorkEvaluation extends BasicModel {

    @Field(title = "相应员工", display = DisplayType.Hidden)
    @Lookup(value = EmployeeLookupAction.class, labelField = "name", valueField = "id")
    private Integer employeeId;

    @Field(title = "开始时间")
    private Date startedAt;

    @Field(title = "结束时间")
    private Date endedAt;

    @Field(title = "工作内容", type = ValueType.TEXTAREA)
    private String workContent;
}
