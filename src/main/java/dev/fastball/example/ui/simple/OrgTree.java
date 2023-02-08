package dev.fastball.example.ui.simple;

import dev.fastball.core.annotation.*;
import dev.fastball.core.component.DataResult;
import dev.fastball.example.common.model.Org;
import dev.fastball.example.common.repo.OrgRepository;
import dev.fastball.ui.components.tree.Tree;
import dev.fastball.ui.components.tree.config.TreeConfig;
import lombok.RequiredArgsConstructor;

/**
 * @author gr@fastball.dev
 * @since 2022/12/10
 */
@UIComponent
@RequiredArgsConstructor
@TreeConfig(
        titleField = "name",
        childrenField = "subOrg",
        defaultExpandAll = true
)
@RecordViewActions(@ViewAction(key = "edit", name = "编辑", popup = @Popup(value = @RefComponent(EmployeeForm.class))))
public class OrgTree implements Tree<Org> {

    private final OrgRepository orgRepository;

    @Override
    public DataResult<Org> loadData() {
        return DataResult.build(orgRepository.findRootAndLoadSubOrg());
    }

    @RecordAction(name = "删除")
    public void deleteEmployee(Org org) {
        orgRepository.delete(org);
    }
}
