package dev.fastball.example.ui.action;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.core.component.LookupAction;
import dev.fastball.core.component.LookupActionParam;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

/**
 * @author gr@fastball.dev
 * @since 2023/1/8
 */
@UIComponent
@RequiredArgsConstructor
public class EmployeeLookupAction implements LookupAction<Employee, Object> {

    private final EmployeeRepository repo;

    @Override
    public Collection<Employee> loadLookupItems(LookupActionParam<Object> param) {
        return repo.findAll();
    }
}
