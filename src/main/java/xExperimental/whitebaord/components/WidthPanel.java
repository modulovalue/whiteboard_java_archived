package xExperimental.whitebaord.components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import xExperimental.whitebaord.properties.Defaults;
import xExperimental.whitebaord.properties.Properties;

/**
 * This allows a user to change the width of a Shape.
 */
public class WidthPanel extends VBox {

    Label widthLabel;
    Slider widthSlider;

    /**
     * Create a WidthPanel object.
     */
    public WidthPanel() {
	// Create the GUI.
	setAlignment(Pos.CENTER);
	widthSlider = new Slider(0.1, 100.0, Properties.getWidth());
	widthLabel = new Label("Width: " + (int) widthSlider.getValue());
	widthLabel.setTextFill(Defaults.TEXT_COLOR);

	// Setup what happens when the slider changes.
	widthSlider.valueProperty().addListener(new ChangeListener<Number>() {
	    @Override
	    public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal) {
		// Make it look good with a format.
		int val = newVal.intValue();
		widthLabel.setText("Width: " + val);
		Properties.setWidth(val);
	    }

	});

	// Add the Nodes.
	getChildren().add(widthLabel);
	getChildren().add(widthSlider);
    }

}
