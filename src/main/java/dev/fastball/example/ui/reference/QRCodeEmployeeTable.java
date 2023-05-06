package dev.fastball.example.ui.reference;

import dev.fastball.core.annotation.DisplayComponent;
import dev.fastball.core.annotation.Field;
import dev.fastball.core.annotation.RefComponent;
import dev.fastball.core.annotation.UIComponent;
import dev.fastball.core.component.DataResult;
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
public class QRCodeEmployeeTable implements SearchTable<QRCodeEmployeeTable.QRCodeEmployee, UserQuerier> {

    private final EmployeeRepository employeeRepo;

    @Override
    public DataResult<QRCodeEmployee> loadData(TableSearchParam<UserQuerier> querier) {
        Collection<QRCodeEmployee> data = employeeRepo.findByQuerier(querier).stream().map(employee -> {
            QRCodeEmployee qrCodeEmployee = new QRCodeEmployee();
            BeanUtils.copyProperties(employee, qrCodeEmployee);
            return qrCodeEmployee;
        }).collect(Collectors.toList());
        return DataResult.build(data);
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class QRCodeEmployee extends Employee {
        @Field(title = "证件号码, 使用外部组件转化为二维码", tips = "员工身份证号")
        @Pattern(message = "需要符合身份证校验规则", regexp = "^(\\d{18}|\\d{15}|\\d{17}x)$")
        @NotNull(message = "certificate number can not be null")
        @CopyableColumn
        @DisplayComponent(value = @RefComponent(value = AntDesignQRCodeComponent.class, propsKey = "value", currentFieldInput = true))
        private String certificateNumber;
    }
}
