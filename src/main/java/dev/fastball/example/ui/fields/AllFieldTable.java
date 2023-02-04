package dev.fastball.example.ui.fields;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.core.component.DataResult;
import dev.fastball.example.common.model.AllDescriptionFieldModel;
import dev.fastball.example.common.repo.AllFieldRepo;
import dev.fastball.ui.components.table.Table;

import java.util.Collections;

/**
 * @author gr@fastball.dev
 * @since 2023/1/30
 */
@UIComponent
public class AllFieldTable implements Table<AllDescriptionFieldModel> {
    @Override
    public DataResult<AllDescriptionFieldModel> loadData() {
        return DataResult.build(Collections.singletonList(AllFieldRepo.INSTANCE));
    }
}
