package dev.fastball.example.common.repo;


import dev.fastball.example.common.dict.EmployeeType;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.model.UserQuerier;
import dev.fastball.ui.components.table.param.SortOrder;
import dev.fastball.ui.components.table.param.TableSearchParam;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author gr@fastball.dev
 * @since 2023/1/8
 */
@Component
public class EmployeeRepository extends MockRepo<Employee> {
    public Collection<Employee> findByQuerier(UserQuerier querier) {
        if (querier == null || querier.getName() == null) {
            return data.values();
        }
        return data.values().stream()
                .filter(employee -> employee.getName().toLowerCase().contains(querier.getName()))
                .collect(Collectors.toList());
    }

    public Collection<Employee> findByQuerier(TableSearchParam<UserQuerier> searchParam) {
        UserQuerier querier = searchParam.getSearch();
        Stream<Employee> employeeStream = data.values().stream();
        if (searchParam.getKeyword() != null) {
            employeeStream = employeeStream.filter(employee -> employee.getName().toLowerCase().contains(searchParam.getKeyword()) || employee.getCertificateNumber().toLowerCase().contains(searchParam.getKeyword()));
        }
        if (querier != null && querier.getName() != null) {
            employeeStream = employeeStream.filter(employee -> employee.getName().toLowerCase().contains(querier.getName()));
        }
        SortOrder ageSortOrder = searchParam.getSortFields().get("age");
        if (ageSortOrder == SortOrder.Ascend) {
            employeeStream = employeeStream.sorted(Comparator.comparingInt(Employee::getAge));
        } else if (ageSortOrder == SortOrder.Descend) {
            employeeStream = employeeStream.sorted(Comparator.comparingInt(Employee::getAge).reversed());
        }
        return employeeStream.collect(Collectors.toList());
    }

    public Collection<Employee> findByQuerierAndOrgId(UserQuerier querier, Integer orgId) {
        Stream<Employee> employeeStream = data.values().stream();
        if (querier.getName() != null) {
            employeeStream = employeeStream.filter(employee -> employee.getName().toLowerCase().contains(querier.getName()));
        }
        if (orgId != null) {
            employeeStream = employeeStream.filter(employee -> Objects.equals(employee.getOrgId(), orgId));
        }
        return employeeStream.collect(Collectors.toList());
    }

    @Override
    protected int initMaxId() {
        return 11100000;
    }

    @Override
    protected Employee[] initData() {
        return new Employee[]{
                Employee.builder().id(11000001).orgId(10000001).enabled(true).certificateNumber("64052119651205421X").name("张三").type(EmployeeType.VicePresident).age(32).build(),
                Employee.builder().id(11000002).orgId(10000011).enabled(true).certificateNumber("140226198211033200").name("李四").type(EmployeeType.PrincipalProgramManager).age(18).build(),
                Employee.builder().id(11000003).orgId(10000012).enabled(false).certificateNumber("350724198910010714").name("法外狂徒").type(EmployeeType.SeniorStaff).age(38).build(),
                Employee.builder().id(11000004).orgId(10000012).enabled(false).certificateNumber("632522196509281602").name("奈法利安").type(EmployeeType.TeamLeader).age(199).build(),
                Employee.builder().id(11000005).orgId(10000012).enabled(true).certificateNumber("632324195607195908").name("酒剑仙").type(EmployeeType.SeniorStaff).age(130).build(),
                Employee.builder().id(11000006).orgId(10000121).enabled(true).certificateNumber("210711196202061818").name("某 Java 开发").type(EmployeeType.Staff).age(35).build(),
                Employee.builder().id(11000007).orgId(10000121).enabled(false).certificateNumber("140581199910011815").name("某架构师").type(EmployeeType.Staff).age(25).build(),
                Employee.builder().id(11000008).orgId(10000122).enabled(true).certificateNumber("110001201101010209").name("罗老师").type(EmployeeType.Staff).age(50).build()
        };
    }
}
