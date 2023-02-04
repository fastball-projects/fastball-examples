package dev.fastball.example.ui;

import dev.fastball.core.annotation.RecordAction;
import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.Org;
import dev.fastball.example.common.repo.OrgRepository;
import dev.fastball.ui.components.form.Form;
import lombok.RequiredArgsConstructor;

/**
 * @author gr@fastball.dev
 * @since 2022/12/14
 */
@UIComponent
@RequiredArgsConstructor
public class OrgForm implements Form<Org> {

    private final OrgRepository orgRepository;

    @RecordAction(name = "提交")
    public void submit(Org org) {
        orgRepository.save(org);
    }
}
