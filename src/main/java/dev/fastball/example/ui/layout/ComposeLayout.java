package dev.fastball.example.ui.layout;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.ui.simple.OrgTree;
import dev.fastball.ui.components.layout.LayoutComponent;
import dev.fastball.ui.components.layout.config.LeftAndRight;

/**
 * @author gr@fastball.dev
 * @since 2023/1/10
 */
@UIComponent
@LeftAndRight(
        left = OrgTree.class,
        right = EmployeeTopAndBottomLayout.class
)
public class ComposeLayout implements LayoutComponent {
}
