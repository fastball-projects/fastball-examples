package dev.fastball.example.ui.action;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.core.component.LookupAction;
import dev.fastball.example.common.model.Org;
import dev.fastball.example.common.repo.OrgRepository;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

/**
 * @author gr@fastball.dev
 * @since 2023/1/8
 */
@UIComponent
@RequiredArgsConstructor
public class OrgLookupAction implements LookupAction<Org, Object> {

    private final OrgRepository orgRepository;

    @Override
    public Collection<Org> loadLookupItems(Object o) {
        return orgRepository.findAll();
    }
}
