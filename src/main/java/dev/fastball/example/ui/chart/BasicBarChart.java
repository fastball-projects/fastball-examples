package dev.fastball.example.ui.chart;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.GoodsType;
import dev.fastball.example.common.model.SalesStatistics;
import dev.fastball.example.common.repo.SalesStatisticsRepo;
import dev.fastball.ui.components.chart.Chart;
import dev.fastball.ui.components.chart.config.BarChartConfig;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

/**
 * @author gr@fastball.dev
 * @since 2023/1/30
 */
@UIComponent
@RequiredArgsConstructor
@BarChartConfig(
        xField = "salesVolume",
        yField = "year"
)
public class BasicBarChart implements Chart<SalesStatistics> {
    private final SalesStatisticsRepo repo;

    @Override
    public Collection<SalesStatistics> loadData() {
        return repo.findByGoodsType(GoodsType.Furniture);
    }
}
