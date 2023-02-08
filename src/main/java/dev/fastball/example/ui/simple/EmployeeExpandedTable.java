package dev.fastball.example.ui.simple;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.core.component.DataResult;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.repo.EmployeeRepository;
import dev.fastball.ui.components.table.Table;
import dev.fastball.ui.components.table.config.TableConfig;
import lombok.RequiredArgsConstructor;

/**
 * @author gr@fastball.dev
 * @since 2023/1/30
 */
@UIComponent
@RequiredArgsConstructor
@TableConfig(
        rowExpandedComponent = EmployeeDescription.class
)
public class EmployeeExpandedTable implements Table<Employee> {
    private final EmployeeRepository employeeRepository;

    @Override
    public DataResult<Employee> loadData() {
        return DataResult.build(employeeRepository.findAll());
    }
}
