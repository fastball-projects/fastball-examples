package dev.fastball.example.ui.layout;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.ui.related.OrgEmployeeTable;
import dev.fastball.example.ui.simple.OrgDescription;
import dev.fastball.example.ui.simple.OrgTree;
import dev.fastball.ui.components.layout.LayoutComponent;
import dev.fastball.ui.components.layout.config.LeftAndTopBottom;

/**
 * @author gr@fastball.dev
 * @since 2022/12/19
 */
@UIComponent
@LeftAndTopBottom(
        left = OrgTree.class,
        top = OrgDescription.class,
        bottom = OrgEmployeeTable.class
)
public class OrgEmployeeLeftAndTopBottomLayout implements LayoutComponent {
}
