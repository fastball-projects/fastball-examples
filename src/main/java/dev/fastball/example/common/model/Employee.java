package dev.fastball.example.common.model;

import dev.fastball.core.annotation.*;
import dev.fastball.core.info.basic.PlacementType;
import dev.fastball.core.info.basic.PopupType;
import dev.fastball.example.common.dict.EmployeeType;
import dev.fastball.example.ui.simple.EmployeeDescription;
import dev.fastball.example.ui.action.OrgLookupAction;
import dev.fastball.ui.components.table.config.CopyableColumn;
import dev.fastball.ui.components.table.config.SortableColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.*;

/**
 * @author gr@fastball.dev
 * @since 2023/1/8
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends BasicModel {

    @Field(title = "姓名123", tips = "员工真实姓名, 用来演示常见文本类型")
    @Size(min = 2, max = 16, message = "员工姓名长度必须在 [2 - 16] 之间")
    @NotNull(message = "员工姓名不可为空")
    @CopyableColumn
    private String name;

    @Field(title = "证件号码", tips = "员工身份证号")
    @Pattern(message = "需要符合身份证校验规则", regexp = "^(\\d{18}|\\d{15}|\\d{17}x)$")
    @CopyableColumn
    private String certificateNumber;

    @Field(title = "年龄", tips = "员工的年龄, 用来演示数字类型")
    @Min(value = 18, message = "age >= 18")
    @Max(value = 199, message = "age < 199")
    @SortableColumn
    private int age;

    @Field(title = "员工类型", tips = "员工的类型, 用来演示词典类")
    @NotNull(message = "员工类型不可为空")
    private EmployeeType type;

    @Field(title = "是否启用", tips = "用来演示布尔类型")
    @BooleanDisplay(trueLabel = "启用", falseLabel = "禁用")
    private Boolean enabled;

    @Field(title = "所属组织", tips = "员工所属的组织机构, 用来演示动态数据选择")
    @Lookup(value = OrgLookupAction.class, labelField = "name", valueField = "id")
    @Popup(value = @RefComponent(EmployeeDescription.class), width = 720, popupType = PopupType.Drawer, placementType = PlacementType.Left)
    private Integer orgId;
}
