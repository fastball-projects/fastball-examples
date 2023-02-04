package dev.fastball.example.ui.classic;

import dev.fastball.core.annotation.RecordAction;
import dev.fastball.core.annotation.UIComponent;
import dev.fastball.core.component.DataResult;
import dev.fastball.core.component.RecordActionFilter;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.model.UserQuerier;
import dev.fastball.example.common.repo.EmployeeRepository;
import dev.fastball.ui.components.table.SearchTable;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

/**
 * @author gr@fastball.dev
 * @since 2023/1/29
 */
@UIComponent
@RequiredArgsConstructor
public class EnableSwitchTable implements SearchTable<Employee, UserQuerier> {

    private final EmployeeRepository employeeRepo;

    @Override
    public DataResult<Employee> loadData(UserQuerier querier) {
        Collection<Employee> data = employeeRepo.findByQuerier(querier);
        return DataResult.build(data);
    }

    @RecordAction(name = "启用", recordActionFilter = EmployeeEnabledRecordActionFilter.class)
    public void enableEmployee(Employee employee) {
        employee.setEnabled(true);
        employeeRepo.save(employee);
    }

    @RecordAction(name = "禁用", recordActionFilter = EmployeeDisabledRecordActionFilter.class)
    public void disableEmployee(Employee employee) {
        employee.setEnabled(false);
        employeeRepo.save(employee);
    }

    public static class EmployeeEnabledRecordActionFilter implements RecordActionFilter<Employee> {
        @Override
        public boolean filter(Employee employee) {
            return !employee.getEnabled();
        }
    }

    public static class EmployeeDisabledRecordActionFilter implements RecordActionFilter<Employee> {
        @Override
        public boolean filter(Employee employee) {
            return employee.getEnabled();
        }
    }
}
