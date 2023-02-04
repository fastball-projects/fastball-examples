package dev.fastball.example.ui.related;

import dev.fastball.core.annotation.RecordAction;
import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.Org;
import dev.fastball.example.common.repo.OrgRepository;
import dev.fastball.ui.components.form.VariableForm;
import lombok.RequiredArgsConstructor;

/**
 * @author gr@fastball.dev
 * @since 2022/12/14
 */
@UIComponent
@RequiredArgsConstructor
public class OrgCreateForm implements VariableForm<Org, Org> {

    private final OrgRepository orgRepository;

    @RecordAction(name = "提交")
    public void submit(Org org) {
        orgRepository.save(org);
    }

    @Override
    public Org loadData(Org parent) {
        Org org = new Org();
        org.setParentId(parent.getId());
        return org;
    }
}
