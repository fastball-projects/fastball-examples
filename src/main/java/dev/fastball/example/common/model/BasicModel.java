package dev.fastball.example.common.model;

import dev.fastball.core.annotation.Field;
import dev.fastball.core.annotation.SimpleQueryable;
import dev.fastball.core.component.DataRecord;
import dev.fastball.meta.basic.DisplayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.Map;

/**
 * @author gr@fastball.dev
 * @since 2023/1/8
 */
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BasicModel extends IdModel {

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
