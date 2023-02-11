package edu.wpi.first.smartdashboard.gui.elements;

import edu.wpi.first.smartdashboard.gui.elements.bindings.AbstractValueWidget;
import edu.wpi.first.smartdashboard.properties.BooleanProperty;
import edu.wpi.first.smartdashboard.properties.ColorProperty;
import edu.wpi.first.smartdashboard.properties.NumberProperty;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class Slider extends AbstractValueWidget {

    public static final DataType[] TYPES = { DataType.NUMBER };
    public static final String NAME = "Slider";

    public final BooleanProperty editable = new BooleanProperty(this, "Editable", true);
    public final ColorProperty background = new ColorProperty(this, "Background");
    public final NumberProperty min = new NumberProperty(this, "Minimum", 0);
    public final NumberProperty max = new NumberProperty(this, "Maximum", 100);

    private JSlider valueField;

    public void init() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JLabel nameLabel = new JLabel(getFieldName());
        valueField = new EditableNumberValueSlider("gamer");
        valueField.setMinimum(0);
        valueField.setMaximum(100);

        update(background, valueField.getBackground());

        add(nameLabel);
        add(valueField);
    }

    @Override
    public void propertyChanged(Property property) {
        if (property == background) {
            valueField.setBackground(background.getValue());
        } else if (property == min) {
            valueField.setMinimum(min.getValue().intValue());
        } else if (property == max) {
            valueField.setMaximum(max.getValue().intValue());
        }
    }

}
