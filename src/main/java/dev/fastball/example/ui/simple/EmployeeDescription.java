package dev.fastball.example.ui.simple;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.core.annotation.ViewAction;
import dev.fastball.core.annotation.ViewActions;
import dev.fastball.meta.basic.ViewActionType;
import dev.fastball.example.common.model.Employee;
import dev.fastball.ui.components.description.Description;
import dev.fastball.ui.components.form.Form;

/**
 * @author gr@fastball.dev
 * @since 2023/1/10
 */
@UIComponent
@ViewActions(actions = @ViewAction(key = "print", name = "打印", type = ViewActionType.Print))
public class EmployeeDescription implements Form<Employee> {
}
