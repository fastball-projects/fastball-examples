package dev.fastball.example.common.repo;

import dev.fastball.example.common.model.GoodsType;
import dev.fastball.example.common.model.SalesStatistics;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author gr@fastball.dev
 * @since 2023/1/30
 */
@Component
public class SalesStatisticsRepo {
    private static final Random random = new Random();

    private final List<SalesStatistics> data = Arrays.asList(SalesStatistics.builder().year("2011").salesVolume(getRandomNumber()).goodsType(GoodsType.Food).build(), SalesStatistics.builder().year("2012").salesVolume(getRandomNumber()).goodsType(GoodsType.Food).build(), SalesStatistics.builder().year("2013").salesVolume(getRandomNumber()).goodsType(GoodsType.Food).build(), SalesStatistics.builder().year("2014").salesVolume(getRandomNumber()).goodsType(GoodsType.Food).build(), SalesStatistics.builder().year("2015").salesVolume(getRandomNumber()).goodsType(GoodsType.Food).build(), SalesStatistics.builder().year("2016").salesVolume(getRandomNumber()).goodsType(GoodsType.Food).build(), SalesStatistics.builder().year("2017").salesVolume(getRandomNumber()).goodsType(GoodsType.Food).build(), SalesStatistics.builder().year("2018").salesVolume(getRandomNumber()).goodsType(GoodsType.Food).build(), SalesStatistics.builder().year("2019").salesVolume(getRandomNumber()).goodsType(GoodsType.Food).build(), SalesStatistics.builder().year("2020").salesVolume(getRandomNumber()).goodsType(GoodsType.Food).build(), SalesStatistics.builder().year("2021").salesVolume(getRandomNumber()).goodsType(GoodsType.Food).build(), SalesStatistics.builder().year("2022").salesVolume(getRandomNumber()).goodsType(GoodsType.Food).build(), SalesStatistics.builder().year("2023").salesVolume(getRandomNumber()).goodsType(GoodsType.Food).build(), SalesStatistics.builder().year("2011").salesVolume(getRandomNumber()).goodsType(GoodsType.Furniture).build(), SalesStatistics.builder().year("2012").salesVolume(getRandomNumber()).goodsType(GoodsType.Furniture).build(), SalesStatistics.builder().year("2013").salesVolume(getRandomNumber()).goodsType(GoodsType.Furniture).build(), SalesStatistics.builder().year("2014").salesVolume(getRandomNumber()).goodsType(GoodsType.Furniture).build(), SalesStatistics.builder().year("2015").salesVolume(getRandomNumber()).goodsType(GoodsType.Furniture).build(), SalesStatistics.builder().year("2016").salesVolume(getRandomNumber()).goodsType(GoodsType.Furniture).build(), SalesStatistics.builder().year("2017").salesVolume(getRandomNumber()).goodsType(GoodsType.Furniture).build(), SalesStatistics.builder().year("2018").salesVolume(getRandomNumber()).goodsType(GoodsType.Furniture).build(), SalesStatistics.builder().year("2019").salesVolume(getRandomNumber()).goodsType(GoodsType.Furniture).build(), SalesStatistics.builder().year("2020").salesVolume(getRandomNumber()).goodsType(GoodsType.Furniture).build(), SalesStatistics.builder().year("2021").salesVolume(getRandomNumber()).goodsType(GoodsType.Furniture).build(), SalesStatistics.builder().year("2022").salesVolume(getRandomNumber()).goodsType(GoodsType.Furniture).build(), SalesStatistics.builder().year("2023").salesVolume(getRandomNumber()).goodsType(GoodsType.Furniture).build(), SalesStatistics.builder().year("2011").salesVolume(getRandomNumber()).goodsType(GoodsType.Tobacco).build(), SalesStatistics.builder().year("2012").salesVolume(getRandomNumber()).goodsType(GoodsType.Tobacco).build(), SalesStatistics.builder().year("2013").salesVolume(getRandomNumber()).goodsType(GoodsType.Tobacco).build(), SalesStatistics.builder().year("2014").salesVolume(getRandomNumber()).goodsType(GoodsType.Tobacco).build(), SalesStatistics.builder().year("2015").salesVolume(getRandomNumber()).goodsType(GoodsType.Tobacco).build(), SalesStatistics.builder().year("2016").salesVolume(getRandomNumber()).goodsType(GoodsType.Tobacco).build(), SalesStatistics.builder().year("2017").salesVolume(getRandomNumber()).goodsType(GoodsType.Tobacco).build(), SalesStatistics.builder().year("2018").salesVolume(getRandomNumber()).goodsType(GoodsType.Tobacco).build(), SalesStatistics.builder().year("2019").salesVolume(getRandomNumber()).goodsType(GoodsType.Tobacco).build(), SalesStatistics.builder().year("2020").salesVolume(getRandomNumber()).goodsType(GoodsType.Tobacco).build(), SalesStatistics.builder().year("2021").salesVolume(getRandomNumber()).goodsType(GoodsType.Tobacco).build(), SalesStatistics.builder().year("2022").salesVolume(getRandomNumber()).goodsType(GoodsType.Tobacco).build(), SalesStatistics.builder().year("2023").salesVolume(getRandomNumber()).goodsType(GoodsType.Tobacco).build(), SalesStatistics.builder().year("2011").salesVolume(getRandomNumber()).goodsType(GoodsType.Commodity).build(), SalesStatistics.builder().year("2012").salesVolume(getRandomNumber()).goodsType(GoodsType.Commodity).build(), SalesStatistics.builder().year("2013").salesVolume(getRandomNumber()).goodsType(GoodsType.Commodity).build(), SalesStatistics.builder().year("2014").salesVolume(getRandomNumber()).goodsType(GoodsType.Commodity).build(), SalesStatistics.builder().year("2015").salesVolume(getRandomNumber()).goodsType(GoodsType.Commodity).build(), SalesStatistics.builder().year("2016").salesVolume(getRandomNumber()).goodsType(GoodsType.Commodity).build(), SalesStatistics.builder().year("2017").salesVolume(getRandomNumber()).goodsType(GoodsType.Commodity).build(), SalesStatistics.builder().year("2018").salesVolume(getRandomNumber()).goodsType(GoodsType.Commodity).build(), SalesStatistics.builder().year("2019").salesVolume(getRandomNumber()).goodsType(GoodsType.Commodity).build(), SalesStatistics.builder().year("2020").salesVolume(getRandomNumber()).goodsType(GoodsType.Commodity).build(), SalesStatistics.builder().year("2021").salesVolume(getRandomNumber()).goodsType(GoodsType.Commodity).build(), SalesStatistics.builder().year("2022").salesVolume(getRandomNumber()).goodsType(GoodsType.Commodity).build(), SalesStatistics.builder().year("2023").salesVolume(getRandomNumber()).goodsType(GoodsType.Commodity).build());

    public Collection<SalesStatistics> findAll() {
        return data;
    }

    public Collection<SalesStatistics> findByGoodsType(GoodsType goodsType) {
        return data.stream().filter(record -> record.getGoodsType() == goodsType).collect(Collectors.toList());
    }

    private int getRandomNumber() {
        int number = random.nextInt() / 99999;
        return number > 0 ? number : -number;
    }
}
