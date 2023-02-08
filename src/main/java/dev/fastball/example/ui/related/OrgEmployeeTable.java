package dev.fastball.example.ui.related;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.core.component.DataResult;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.model.Org;
import dev.fastball.example.common.model.UserQuerier;
import dev.fastball.example.common.repo.EmployeeRepository;
import dev.fastball.ui.components.table.VariableSearchTable;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

/**
 * @author gr@fastball.dev
 * @since 2022/12/10
 */
@UIComponent
@RequiredArgsConstructor
public class OrgEmployeeTable implements VariableSearchTable<Employee, UserQuerier, Org> {

    private final EmployeeRepository employeeRepo;

    @Override
    public DataResult<Employee> loadData(UserQuerier querier, Org org) {
        Collection<Employee> data = employeeRepo.findByQuerierAndOrgId(querier, org != null ? org.getId() : null);
        return DataResult.build(data);
    }
}
