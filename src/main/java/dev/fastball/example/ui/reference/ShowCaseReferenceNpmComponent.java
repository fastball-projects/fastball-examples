package dev.fastball.example.ui.reference;

import dev.fastball.core.annotation.UIComponent;
import dev.fastball.ui.components.basic.ReferenceComponent;
import dev.fastball.ui.components.basic.config.ReferenceComponentConfig;

/**
 * @author gr@fastball.dev
 * @since 2023/1/11
 */
@UIComponent
@ReferenceComponentConfig(
        componentName = "TestComponent",
        npmPackage = "fastball-test-reference-component"
)
public class ShowCaseReferenceNpmComponent implements ReferenceComponent {
}
