package dev.fastball.example.ui.simple;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.repo.EmployeeRepository;
import dev.fastball.ui.components.description.VariableDescription;
import lombok.RequiredArgsConstructor;

/**
 * @author gr@fastball.dev
 * @since 2023/1/10
 */
@UIComponent
@RequiredArgsConstructor
public class EmployeeVariableDescription implements VariableDescription<Employee, Integer> {
    private final EmployeeRepository employeeRepo;

    @Override
    public Employee loadData(Integer id) {
        return employeeRepo.findById(id);
    }
}
