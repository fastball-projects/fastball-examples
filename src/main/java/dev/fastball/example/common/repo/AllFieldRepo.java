package dev.fastball.example.common.repo;

import dev.fastball.core.component.Range;
import dev.fastball.example.common.dict.OrgType;
import dev.fastball.example.common.model.AllDescriptionFieldModel;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

/**
 * @author gr@fastball.dev
 * @since 2023/1/30
 */
public class AllFieldRepo {

    public static final AllDescriptionFieldModel INSTANCE = AllDescriptionFieldModel.builder()
            .text("普通文本")
            .textarea("杀手滑膛受十三位世界巨富的委托，被雇佣去杀掉三个人，三人分别是流浪汉、穷画家和拾荒女孩儿。\n" +
                    "令人不解的是，他们完全处于社会底层，在社会上没有任何声望，过着几乎赤贫的生活，毫无暗杀价值。\n" +
                    "滑膛受过严格训练，冷酷、残忍，技术一流，但当他看到要杀的那个拾荒女孩儿非常像自己爱怜过的一个孩子时，就一定要雇主解释杀他们的理由。")
            .number(9527)
            .money(BigDecimal.valueOf(1.25))
            .date(new Date())
            .dateTime(new Date())
            .dateWeek(new Date())
            .dateMonth(new Date())
            .dateQuarter(new Date())
            .dateYear(new Date())
            .time(LocalTime.of(1, 2, 3))
            .dateRange(new Range<>(new Date(1000000000000L), new Date()))
            .dateTimeRange(new Range<>(new Date(1000000000000L), new Date()))
            .timeRange(new Range<>(LocalTime.of(11, 11, 11), LocalTime.of(22, 22, 22)))
            .select(OrgType.Department)
            .multipleSelect(Arrays.asList(OrgType.Group, OrgType.Team))
            .multipleSelect(Arrays.asList(OrgType.Group, OrgType.Team))
            .lookupSelect(11000001)
            .multipleLookupSelect(Arrays.asList(11000001, 11000002, 11000003, 11000004))
            .treeLookupSelect(10000121)
            .multipleTreeLookupSelect(Arrays.asList(10000011, 10000121, 10000122))
            .hoverPopup(11000001)
            .contextMenuPopup(11000002)
            .clickPopup(11000003)
            .leftDrawerPopup(11000004)
            .build();
}
