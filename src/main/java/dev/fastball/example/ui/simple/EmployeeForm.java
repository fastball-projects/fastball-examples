package dev.fastball.example.ui.simple;

import dev.fastball.core.annotation.RecordAction;
import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.repo.EmployeeRepository;
import dev.fastball.ui.components.form.Form;
import dev.fastball.ui.components.form.config.FormConfig;
import lombok.RequiredArgsConstructor;

/**
 * @author gr@fastball.dev
 * @since 2022/12/14
 */
@UIComponent
@RequiredArgsConstructor
@FormConfig(column = 4)
public class EmployeeForm implements Form<Employee> {

    private final EmployeeRepository employeeRepository;

    @RecordAction(name = "提交")
    public void submit(Employee employee) {
        employeeRepository.save(employee);
    }
}
