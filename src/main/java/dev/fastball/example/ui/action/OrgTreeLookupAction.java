package dev.fastball.example.ui.action;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.core.component.LookupActionParam;
import dev.fastball.core.component.TreeLookupAction;
import dev.fastball.example.common.model.Org;
import dev.fastball.example.common.repo.OrgRepository;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

/**
 * @author gr@fastball.dev
 * @since 2023/1/10
 */
@UIComponent
@RequiredArgsConstructor
public class OrgTreeLookupAction implements TreeLookupAction<Org, Object> {

    private final OrgRepository orgRepository;

    @Override
    public Collection<Org> loadLookupItems(LookupActionParam<Object> param) {
        return orgRepository.findRootAndLoadSubOrg();
    }
}
