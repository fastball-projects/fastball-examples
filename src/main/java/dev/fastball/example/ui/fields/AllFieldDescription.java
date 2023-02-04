package dev.fastball.example.ui.fields;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.AllDescriptionFieldModel;
import dev.fastball.example.common.repo.AllFieldRepo;
import dev.fastball.ui.components.description.VariableDescription;
import lombok.RequiredArgsConstructor;

/**
 * @author gr@fastball.dev
 * @since 2023/1/29
 */
@UIComponent
@RequiredArgsConstructor
public class AllFieldDescription implements VariableDescription<AllDescriptionFieldModel, Object> {
    @Override
    public AllDescriptionFieldModel loadData(Object o) {
        return AllFieldRepo.INSTANCE;
    }
}
