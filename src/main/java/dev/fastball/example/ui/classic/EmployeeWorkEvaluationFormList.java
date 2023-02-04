package dev.fastball.example.ui.classic;

import dev.fastball.core.annotation.Field;
import dev.fastball.core.annotation.RecordAction;
import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.model.UserQuerier;
import dev.fastball.example.common.model.WorkEvaluation;
import dev.fastball.example.common.repo.EmployeeRepository;
import dev.fastball.ui.components.form.Form;
import dev.fastball.ui.components.form.VariableForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.List;


/**
 * @author gr@fastball.dev
 * @since 2023/1/28
 */
@UIComponent
@RequiredArgsConstructor
public class EmployeeWorkEvaluationFormList implements Form<EmployeeWorkEvaluationFormList.WorkEvaluationEmployee> {

    private final EmployeeRepository employeeRepo;

    @RecordAction(name = "保存")
    public void save(WorkEvaluationEmployee employee) {
        employeeRepo.save(employee);
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class WorkEvaluationEmployee extends Employee {
        @Field(title = "工作记录", tips = "用于展示嵌套表单列表, 当字段为集合对象时, 会自动展开为可维护的字段列表")
        private List<WorkEvaluation> firstWorkEvaluation;
    }
}

