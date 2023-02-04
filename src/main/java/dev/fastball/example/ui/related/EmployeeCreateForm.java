package dev.fastball.example.ui.related;

import dev.fastball.core.annotation.RecordAction;
import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.model.Org;
import dev.fastball.example.common.repo.EmployeeRepository;
import dev.fastball.ui.components.form.VariableForm;
import lombok.RequiredArgsConstructor;

/**
 * @author gr@fastball.dev
 * @since 2022/12/14
 */
@UIComponent
@RequiredArgsConstructor
public class EmployeeCreateForm implements VariableForm<Employee, Org> {

    private final EmployeeRepository employeeRepository;

    @RecordAction(name = "提交")
    public void submit(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee loadData(Org org) {
        Employee employee = new Employee();
        if (org != null) {
            employee.setOrgId(org.getId());
        }
        return employee;
    }
}
