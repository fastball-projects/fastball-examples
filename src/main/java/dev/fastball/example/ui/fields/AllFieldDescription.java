package dev.fastball.example.ui.fields;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.AllDescriptionFieldModel;
import dev.fastball.example.common.repo.AllFieldRepo;
import dev.fastball.ui.components.description.VariableDescription;
import dev.fastball.ui.components.form.VariableForm;
import dev.fastball.ui.components.form.config.FormConfig;
import lombok.RequiredArgsConstructor;

/**
 * @author gr@fastball.dev
 * @since 2023/1/29
 */
@UIComponent
@FormConfig(readonly = true)
@RequiredArgsConstructor
public class AllFieldDescription implements VariableForm<AllDescriptionFieldModel, Object> {
    @Override
    public AllDescriptionFieldModel loadData(Object o) {
        return AllFieldRepo.INSTANCE;
    }
}
