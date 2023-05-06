package dev.fastball.example.ui.layout;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.ui.related.OrgEmployeeTable;
import dev.fastball.example.ui.simple.EmployeeForm;
import dev.fastball.example.ui.simple.OrgDescription;
import dev.fastball.ui.components.layout.LayoutComponent;
import dev.fastball.ui.components.layout.config.TopAndBottom;

/**
 * @author gr@fastball.dev
 * @since 2023/1/26
 */
@UIComponent
@TopAndBottom(
        top = OrgDescription.class,
        bottom = OrgEmployeeTable.class,
        interlocking = true
)
public class EmployeeTopAndBottomLayout implements LayoutComponent {
}
