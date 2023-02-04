package dev.fastball.example.ui.simple;

import dev.fastball.core.annotation.RecordAction;
import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.repo.EmployeeRepository;
import dev.fastball.ui.components.form.Form;
import lombok.RequiredArgsConstructor;

/**
 * @author gr@fastball.dev
 * @since 2022/12/14
 */
@UIComponent
@RequiredArgsConstructor
public class EmployeeForm implements Form<Employee> {

    private final EmployeeRepository employeeRepository;

    @RecordAction(name = "提交")
    public void submit(Employee employee) {
        employeeRepository.save(employee);
    }
}
