package dev.fastball.example.ui.simple;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.model.IdModel;
import dev.fastball.example.common.repo.EmployeeRepository;
import dev.fastball.ui.components.form.VariableForm;
import dev.fastball.ui.components.form.config.FormConfig;
import lombok.RequiredArgsConstructor;

/**
 * @author gr@fastball.dev
 * @since 2023/1/10
 */
@UIComponent
@FormConfig(readonly = true)
@RequiredArgsConstructor
public class EmployeeVariableDescription implements VariableForm<Employee, IdModel> {
    private final EmployeeRepository employeeRepo;

    @Override
    public Employee loadData(IdModel param) {
        return employeeRepo.findById(param.getId());
    }
}
