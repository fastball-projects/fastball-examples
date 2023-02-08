package dev.fastball.example.ui.simple;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.model.WorkEvaluation;
import dev.fastball.example.common.repo.WorkEvaluationRepository;
import dev.fastball.ui.components.timeline.VariableTimeline;
import dev.fastball.ui.components.timeline.config.TimelineConfig;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

/**
 * @author gr@fastball.dev
 * @since 2023/1/9
 */
@UIComponent
@TimelineConfig(
        keyField = "id",
        leftField = "startedAt",
        rightField = "workContent"
)
@RequiredArgsConstructor
public class EmployeeWorkEvaluationTimeline implements VariableTimeline<WorkEvaluation, Employee> {

    private final WorkEvaluationRepository repo;

    @Override
    public Collection<WorkEvaluation> loadData(Employee employee) {
        if (employee == null || employee.getId() == null) {
            return repo.findAll();
        }
        return repo.findByEmployeeId(employee.getId());
    }
}
