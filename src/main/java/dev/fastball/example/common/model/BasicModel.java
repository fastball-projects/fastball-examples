package dev.fastball.example.common.model;

import dev.fastball.core.annotation.Field;
import dev.fastball.core.component.DataRecord;
import dev.fastball.core.component.DefaultDataRecord;
import dev.fastball.core.info.basic.DisplayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author gr@fastball.dev
 * @since 2023/1/8
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BasicModel extends DefaultDataRecord {
    @Field(title = "唯一标识", display = DisplayType.Hidden)
    protected Integer id;

    /**
     * 创建时间
     */
    @Field(title = "创建时间", display = DisplayType.Hidden)
    protected Date createdAt;

    /**
     * 最后一次修改时间
     */
    @Field(title = "最后更新时间", display = DisplayType.Hidden)
    protected Date updatedAt;
}
