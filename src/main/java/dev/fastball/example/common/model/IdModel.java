package dev.fastball.example.common.model;

import dev.fastball.core.annotation.Field;
import dev.fastball.core.annotation.SimpleQueryable;
import dev.fastball.core.component.DataRecord;
import dev.fastball.meta.basic.DisplayType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Map;

/**
 * @author Geng Rong
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class IdModel implements DataRecord {
    @Field(title = "唯一标识", display = DisplayType.Hidden)
    protected Integer id;

    @Field(display = DisplayType.Disabled)
    @SimpleQueryable.Ignore
    private Map<String, Boolean> recordActionAvailableFlags;
}
