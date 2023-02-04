package dev.fastball.example.common.dict;

import dev.fastball.core.annotation.DictionaryItem;

/**
 * @author gr@fastball.dev
 * @since 2023/1/8
 */

public enum OrgType {
    @DictionaryItem(label = "集团公司", color = "#FF6633")
    Group,
    @DictionaryItem(label = "有限责任公司", color = "#3333FF")
    Company,
    @DictionaryItem(label = "部门", color = "#33CC99")
    Department,
    @DictionaryItem(label = "小组", color = "#66CC00")
    Team
}
