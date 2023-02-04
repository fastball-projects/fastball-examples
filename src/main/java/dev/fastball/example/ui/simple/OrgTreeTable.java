package dev.fastball.example.ui.simple;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.core.component.DataResult;
import dev.fastball.example.common.model.Org;
import dev.fastball.example.common.repo.OrgRepository;
import dev.fastball.ui.components.table.Table;
import dev.fastball.ui.components.table.config.TableConfig;
import lombok.RequiredArgsConstructor;

/**
 * @author gr@fastball.dev
 * @since 2023/1/30
 */
@UIComponent
@RequiredArgsConstructor
@TableConfig(
        childrenFieldName = "subOrg"
)
public class OrgTreeTable implements Table<Org> {
    private final OrgRepository orgRepository;

    @Override
    public DataResult<Org> loadData() {
        return DataResult.build(orgRepository.findRootAndLoadSubOrg());
    }
}
