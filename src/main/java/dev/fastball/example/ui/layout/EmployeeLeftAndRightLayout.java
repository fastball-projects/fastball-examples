package dev.fastball.example.ui.layout;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.ui.related.OrgEmployeeTable;
import dev.fastball.example.ui.simple.OrgTree;
import dev.fastball.ui.components.layout.LayoutComponent;
import dev.fastball.ui.components.layout.config.LeftAndRight;

/**
 * @author gr@fastball.dev
 * @since 2022/12/19
 */
@UIComponent
@LeftAndRight(
        left = OrgTree.class,
        right = OrgEmployeeTable.class
)
public class EmployeeLeftAndRightLayout implements LayoutComponent {
}
