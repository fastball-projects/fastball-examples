package dev.fastball.example.common.model;

import dev.fastball.core.annotation.Field;
import dev.fastball.core.annotation.Lookup;
import dev.fastball.core.annotation.MainField;
import dev.fastball.core.annotation.TreeLookup;
import dev.fastball.core.info.basic.DisplayType;
import dev.fastball.example.common.dict.OrgType;
import dev.fastball.example.ui.action.OrgLookupAction;
import dev.fastball.example.ui.action.OrgTreeLookupAction;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gr@fastball.dev
 * @since 2023/1/8
 */
@Data
@MainField("name")
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Org extends BasicModel {

    @Field(title = "名称", tips = "组织名称`")
    @Size(min = 6, max = 64, message = "组织名称长度需要在 [6 - 64] 区间")
    @NotNull(message = "组织名称不能为空")
    private String name;

    @Field(title = "组织编码")
    @Pattern(regexp = "^(([0-9]){3}-)*([0-9]){3}$", message = "组织编码需要满足 3 位数字以横杠分隔的格式, 例如: 123-456-789")
    @NotNull(message = "组织编码不能为空")
    private String orgNumber;

    @Field(title = "部门类型", tips = "部门的类型")
    @NotNull(message = "组织类型不能为空")
    private OrgType type;

    @Field(title = "所属部门")
    @Lookup(value = OrgLookupAction.class, labelField = "name", valueField = "id")
    private Integer parentId;

    @Field(title = "子部门", display = DisplayType.Hidden)
    @TreeLookup(value = OrgTreeLookupAction.class, labelField = "name", valueField = "id", childrenField = "subOrg")
    private List<Org> subOrg = new ArrayList<>();

    public Org(Org org) {
        this.id = org.id;
        this.createdAt = org.createdAt;
        this.updatedAt = org.updatedAt;
        this.name = org.name;
        this.orgNumber = org.orgNumber;
        this.type = org.type;
        this.parentId = org.parentId;
    }
}
