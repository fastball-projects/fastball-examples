package dev.fastball.example.ui.reference;

import dev.fastball.core.annotation.Field;
import dev.fastball.core.annotation.Popup;
import dev.fastball.core.annotation.RefComponent;
import dev.fastball.core.annotation.UIComponent;
import dev.fastball.core.component.DataResult;
import dev.fastball.meta.basic.PopupTriggerType;
import dev.fastball.meta.basic.PopupType;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.model.UserQuerier;
import dev.fastball.example.common.repo.EmployeeRepository;
import dev.fastball.ui.components.table.SearchTable;
import dev.fastball.ui.components.table.config.CopyableColumn;
import dev.fastball.ui.components.table.param.TableSearchParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author gr@fastball.dev
 * @since 2022/12/10
 */
@UIComponent
@RequiredArgsConstructor
public class PopupQRCodeEmployeeTable implements SearchTable<PopupQRCodeEmployeeTable.PopupQRCodeEmployee, UserQuerier> {

    private final EmployeeRepository employeeRepo;

    @Override
    public DataResult<PopupQRCodeEmployee> loadData(TableSearchParam<UserQuerier> querier) {
        Collection<PopupQRCodeEmployee> data = employeeRepo.findByQuerier(querier).stream().map(employee -> {
            PopupQRCodeEmployee qrCodeEmployee = new PopupQRCodeEmployee();
            BeanUtils.copyProperties(employee, qrCodeEmployee);
            return qrCodeEmployee;
        }).collect(Collectors.toList());
        return DataResult.build(data);
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class PopupQRCodeEmployee extends Employee {
        @Field(title = "证件号码, 鼠标移到字段值上", tips = "员工身份证号")
        @Pattern(message = "需要符合身份证校验规则", regexp = "^(\\d{18}|\\d{15}|\\d{17}x)$")
        @NotNull(message = "certificate number can not be null")
        @CopyableColumn
        @Popup(value = @RefComponent(value = AntDesignQRCodeComponent.class, propsKey = "value", currentFieldInput = true), popupType = PopupType.Popover, triggerType = PopupTriggerType.Hover)
        private String certificateNumber;
    }

}
