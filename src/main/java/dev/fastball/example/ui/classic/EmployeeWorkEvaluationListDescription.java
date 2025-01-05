package dev.fastball.example.ui.classic;

import dev.fastball.core.annotation.Field;
import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.model.IdModel;
import dev.fastball.example.common.model.WorkEvaluation;
import dev.fastball.example.common.repo.EmployeeRepository;
import dev.fastball.example.common.repo.WorkEvaluationRepository;
import dev.fastball.ui.components.form.VariableForm;
import dev.fastball.ui.components.form.config.FormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Collection;


/**
 * @author gr@fastball.dev
 * @since 2023/1/28
 */
@UIComponent
@FormConfig(readonly = true)
@RequiredArgsConstructor
public class EmployeeWorkEvaluationListDescription implements VariableForm<EmployeeWorkEvaluationListDescription.WorkEvaluationEmployee, IdModel> {
    private final EmployeeRepository employeeRepo;
    private final WorkEvaluationRepository workEvaluationRepository;

    @Override
    public WorkEvaluationEmployee loadData(IdModel param) {
        Employee employee = employeeRepo.findById(param.getId());
        WorkEvaluationEmployee workEvaluationEmployee = new WorkEvaluationEmployee();
        BeanUtils.copyProperties(employee, workEvaluationEmployee);
        workEvaluationEmployee.setFirstWorkEvaluation(workEvaluationRepository.findAll());
        return workEvaluationEmployee;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class WorkEvaluationEmployee extends Employee {
        @Field(title = "工作记录", tips = "用于展示嵌套表单列表, 当字段为集合对象时, 会自动展开为可维护的字段列表")
        private Collection<WorkEvaluation> firstWorkEvaluation;
    }
}

