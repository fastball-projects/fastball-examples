package dev.fastball.example.common.model;

import dev.fastball.core.annotation.Field;
import dev.fastball.core.annotation.Lookup;
import dev.fastball.core.annotation.Popup;
import dev.fastball.core.annotation.RefComponent;
import dev.fastball.core.info.basic.PlacementType;
import dev.fastball.core.info.basic.PopupTriggerType;
import dev.fastball.core.info.basic.PopupType;
import dev.fastball.example.ui.action.EmployeeLookupAction;
import dev.fastball.example.ui.simple.EmployeeVariableDescription;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author gr@fastball.dev
 * @since 2023/1/29
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AllDescriptionFieldModel extends AllFormFieldModel {

    @Field(title = "气泡展示(悬停)")
    @Lookup(value = EmployeeLookupAction.class, labelField = "name", valueField = "id")
    @Popup(value = @RefComponent(value = EmployeeVariableDescription.class, currentFieldInput = true), popupType = PopupType.Popover, triggerType = PopupTriggerType.Hover)
    private Integer hoverPopup;

    @Field(title = "模态窗展示(右键点击)")
    @Lookup(value = EmployeeLookupAction.class, labelField = "name", valueField = "id")
    @Popup(value = @RefComponent(value = EmployeeVariableDescription.class, currentFieldInput = true), popupType = PopupType.Modal, triggerType = PopupTriggerType.ContextMenu)
    private Integer contextMenuPopup;

    @Field(title = "左侧抽屉展示(左键点击)")
    @Lookup(value = EmployeeLookupAction.class, labelField = "name", valueField = "id")
    @Popup(value = @RefComponent(value = EmployeeVariableDescription.class, currentFieldInput = true), popupType = PopupType.Drawer, placementType = PlacementType.Left)
    private Integer leftDrawerPopup;

    @Field(title = "抽屉展示(左键点击)")
    @Lookup(value = EmployeeLookupAction.class, labelField = "name", valueField = "id")
    @Popup(value = @RefComponent(value = EmployeeVariableDescription.class, currentFieldInput = true), popupType = PopupType.Drawer)
    private Integer clickPopup;
}
