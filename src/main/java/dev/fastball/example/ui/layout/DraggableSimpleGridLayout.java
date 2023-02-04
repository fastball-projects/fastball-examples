package dev.fastball.example.ui.layout;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.ui.chart.*;
import dev.fastball.ui.components.layout.LayoutComponent;
import dev.fastball.ui.components.layout.config.GridCell;
import dev.fastball.ui.components.layout.config.GridLayout;

/**
 * @author gr@fastball.dev
 * @since 2023/1/30
 */
@UIComponent
@GridLayout(
        draggable = true,
        resizable = true,
        cells = {
                @GridCell(x = 0, y = 0, width = 3, component = BasicColumnChart.class),
                @GridCell(x = 3, y = 0, width = 3, component = MultipleLineChart.class),
                @GridCell(x = 6, y = 0, width = 3, component = BasicAreaChart.class),
                @GridCell(x = 9, y = 0, width = 3, component = BasicLineChart.class),
                @GridCell(x = 0, y = 6, height = 12, component = MultipleColumnChart.class),
                @GridCell(x = 6, y = 6, component = MultipleAreaChart.class),
                @GridCell(x = 6, y = 12, component = MultipleBarChart.class),
                @GridCell(x = 0, y = 18, width = 12, component = BasicBarChart.class)
        }
)
public class DraggableSimpleGridLayout implements LayoutComponent {
}
