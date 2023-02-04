package dev.fastball.example.common.dict;

import dev.fastball.core.annotation.DictionaryItem;

/**
 * @author gr@fastball.dev
 * @since 2023/1/8
 */

public enum EmployeeType {
    @DictionaryItem(label = "正式员工")
    Staff,
    @DictionaryItem(label = "资深员工")
    SeniorStaff,
    @DictionaryItem(label = "小组负责人")
    TeamLeader,
    @DictionaryItem(label = "项目经理负责人")
    PrincipalProgramManager,
    @DictionaryItem(label = "副总监")
    VicePresident
}
