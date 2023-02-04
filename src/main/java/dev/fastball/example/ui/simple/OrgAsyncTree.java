package dev.fastball.example.ui.simple;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.core.component.DataResult;
import dev.fastball.example.common.model.Org;
import dev.fastball.example.common.repo.OrgRepository;
import dev.fastball.ui.components.tree.AsyncTree;
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
        childrenField = "subOrg"
)
public class OrgAsyncTree implements AsyncTree<Org> {

    private final OrgRepository orgRepository;

    @Override
    public DataResult<Org> loadData(Org parent) {
        if (parent == null) {
            return DataResult.build(orgRepository.findRoot());
        }
        return DataResult.build(orgRepository.findByParentId(parent.getId()));
    }
}
