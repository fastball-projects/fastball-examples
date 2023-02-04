package dev.fastball.example.ui.classic;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.ui.simple.OrgDescription;
import dev.fastball.example.ui.simple.OrgTree;
import dev.fastball.ui.components.layout.LayoutComponent;
import dev.fastball.ui.components.layout.config.LeftAndTopBottom;

/**
 * @author gr@fastball.dev
 * @since 2023/1/30
 */
@UIComponent
@LeftAndTopBottom(
        left = OrgTree.class,
        top = OrgDescription.class,
        bottom = OrgBasicBarChart.class
)
public class TreeChartLayout implements LayoutComponent {
}
