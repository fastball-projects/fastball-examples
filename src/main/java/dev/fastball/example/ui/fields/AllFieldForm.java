package dev.fastball.example.ui.fields;

import dev.fastball.core.annotation.RecordAction;
import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.AllFormFieldModel;
import dev.fastball.example.common.repo.AllFieldRepo;
import dev.fastball.ui.components.form.VariableForm;
import dev.fastball.ui.components.form.config.FormConfig;
import lombok.RequiredArgsConstructor;

/**
 * @author gr@fastball.dev
 * @since 2023/1/29
 */
@UIComponent
@RequiredArgsConstructor
@FormConfig(showReset = false)
public class AllFieldForm implements VariableForm<AllFormFieldModel, Object> {
    @Override
    public AllFormFieldModel loadData(Object o) {
        return AllFieldRepo.INSTANCE;
    }

    @RecordAction(name = "abc")
    public void abc(AllFormFieldModel model) {
        System.out.println(model);
    }
}
