package dev.fastball.example.ui.classic;

import dev.fastball.core.annotation.Field;
import dev.fastball.core.annotation.RecordAction;
import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.model.WorkEvaluation;
import dev.fastball.example.common.repo.EmployeeRepository;
import dev.fastball.ui.components.form.Form;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;


/**
 * @author gr@fastball.dev
 * @since 2023/1/28
 */
@UIComponent
@RequiredArgsConstructor
public class EmployeeWorkEvaluationNestedForm implements Form<EmployeeWorkEvaluationNestedForm.WorkEvaluationEmployee> {

    private final EmployeeRepository employeeRepo;

    @RecordAction(name = "保存")
    public void save(WorkEvaluationEmployee employee) {
        employeeRepo.save(employee);
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class WorkEvaluationEmployee extends Employee {
        @Field(title = "首次工作记录, 用于展示嵌套表单")
        private WorkEvaluation firstWorkEvaluation;
    }
}

