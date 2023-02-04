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
        componentName = "QRCode",
        npmPackage = "antd",
        defaultComponent = false
)
public class AntDesignQRCodeComponent implements ReferenceComponent {
}
