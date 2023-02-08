package dev.fastball.example.ui.simple;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.core.component.DataResult;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.model.UserQuerier;
import dev.fastball.example.common.repo.EmployeeRepository;
import dev.fastball.ui.components.table.SearchTable;
import dev.fastball.ui.components.table.config.TableConfig;
import dev.fastball.ui.components.table.param.TableSearchParam;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

/**
 * @author gr@fastball.dev
 * @since 2022/12/10
 */
@UIComponent
@RequiredArgsConstructor
@TableConfig(keywordSearch = true)
public class EmployeeWrapperTable implements SearchTable<Employee, TableSearchParam<UserQuerier>> {

    private final EmployeeRepository employeeRepo;

    @Override
    public DataResult<Employee> loadData(TableSearchParam<UserQuerier> searchParam) {
        Collection<Employee> data = employeeRepo.findByQuerier(searchParam);
        return DataResult.build(data);
    }
}
