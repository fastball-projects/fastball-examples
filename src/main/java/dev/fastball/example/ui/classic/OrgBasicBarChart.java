package dev.fastball.example.ui.classic;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.example.common.model.GoodsType;
import dev.fastball.example.common.model.Org;
import dev.fastball.example.common.model.SalesStatistics;
import dev.fastball.example.common.repo.SalesStatisticsRepo;
import dev.fastball.ui.components.chart.VariableChart;
import dev.fastball.ui.components.chart.config.ChartConfig;
import dev.fastball.ui.components.chart.config.ChartType;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

/**
 * @author gr@fastball.dev
 * @since 2023/1/30
 */
@UIComponent
@RequiredArgsConstructor
@ChartConfig(
        type = ChartType.Bar,
        xField = "salesVolume",
        yField = "year"
)
public class OrgBasicBarChart implements VariableChart<SalesStatistics, Org> {
    private final SalesStatisticsRepo repo;

    @Override
    public Collection<SalesStatistics> loadData(Org org) {
        if (org == null || org.getId() == null) {
            return repo.findByGoodsType(GoodsType.Food);
        }
        return repo.findByGoodsType(GoodsType.values()[org.getId() % GoodsType.values().length]);
    }
}
