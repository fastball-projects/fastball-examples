package dev.fastball.example.ui.classic;

import dev.fastball.core.annotation.*;
import dev.fastball.core.component.DataResult;
import dev.fastball.core.component.RecordActionFilter;
import dev.fastball.core.info.basic.PopupType;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.model.UserQuerier;
import dev.fastball.example.common.repo.EmployeeRepository;
import dev.fastball.example.ui.simple.EmployeeForm;
import dev.fastball.ui.components.table.SearchTable;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Objects;

/**
 * @author gr@fastball.dev
 * @since 2023/1/26
 */
@UIComponent
@RequiredArgsConstructor
@ViewActions(@ViewAction(key = "new", name = "新增员工", popup = @Popup(value = @RefComponent(EmployeeForm.class), popupType = PopupType.Modal)))
@RecordViewActions(@ViewAction(key = "edit", name = "编辑", popup = @Popup(value = @RefComponent(EmployeeForm.class))))
public class CrudTable implements SearchTable<Employee, UserQuerier> {

    private final EmployeeRepository employeeRepo;

    @Override
    public DataResult<Employee> loadData(UserQuerier querier) {
        Collection<Employee> data = employeeRepo.findByQuerier(querier);
        return DataResult.build(data);
    }

    @RecordAction(name = "删除", recordActionFilter = StaticEmployeeFilter.class)
    public void deleteEmployee(Employee employee) {
        employeeRepo.delete(employee);
    }

    public static class StaticEmployeeFilter implements RecordActionFilter<Employee> {
        @Override
        public boolean filter(Employee employee) {
            return !Objects.equals(employee.getId(), 11000007);
        }
    }
}
