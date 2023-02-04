package dev.fastball.example.common.repo;

import dev.fastball.example.common.model.WorkEvaluation;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author gr@fastball.dev
 * @since 2023/1/8
 */
@Component
public class WorkEvaluationRepository extends MockRepo<WorkEvaluation> {
    public Collection<WorkEvaluation> findByEmployeeId(Integer employeeId) {
        if (employeeId == null) {
            return Collections.emptyList();
        }
        return data.values().stream().filter(workEvaluation -> Objects.equals(workEvaluation.getEmployeeId(), employeeId)).collect(Collectors.toList());
    }

    @Override
    protected int initMaxId() {
        return 12100000;
    }

    @Override
    protected WorkEvaluation[] initData() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return new WorkEvaluation[]{
                    WorkEvaluation.builder().id(12000001).employeeId(11000007).startedAt(dateFormat.parse("2018-01-31")).endedAt(dateFormat.parse("2019-07-01")).workContent("完成电商系统架构设计").build(),
                    WorkEvaluation.builder().id(12000002).employeeId(11000007).startedAt(dateFormat.parse("2019-08-25")).endedAt(dateFormat.parse("2020-05-31")).workContent("完成电商系统核心研发").build(),
                    WorkEvaluation.builder().id(12000003).employeeId(11000007).startedAt(dateFormat.parse("2020-07-01")).endedAt(dateFormat.parse("2021-07-31")).workContent("完成营销系统核心设计与研发").build(),
                    WorkEvaluation.builder().id(12000004).employeeId(11000007).startedAt(dateFormat.parse("2021-08-01")).endedAt(dateFormat.parse("2022-01-01")).workContent("设计捅破天科技").build(),
                    WorkEvaluation.builder().id(12000005).employeeId(11000007).startedAt(dateFormat.parse("2022-12-01")).endedAt(dateFormat.parse("2022-01-01")).workContent("罹患新冠").build(),
                    WorkEvaluation.builder().id(12000006).employeeId(11000007).startedAt(dateFormat.parse("2023-01-10")).workContent("身体恢复").build()
            };
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
