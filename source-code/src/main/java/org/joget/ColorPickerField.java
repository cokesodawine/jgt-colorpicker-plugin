package org.joget;

import java.util.Map;
import org.joget.apps.app.service.AppPluginUtil;
import org.joget.apps.app.service.AppUtil;
import org.joget.apps.form.model.Element;
import org.joget.apps.form.model.FormBuilderPalette;
import org.joget.apps.form.model.FormBuilderPaletteElement;
import org.joget.apps.form.model.FormData;
import org.joget.apps.form.model.FormRow;
import org.joget.apps.form.model.FormRowSet;
import org.joget.apps.form.service.FormUtil;

public class ColorPickerField extends Element implements FormBuilderPaletteElement{

    private final static String MESSAGE_PATH = "message/form/ColorPickerField";

    @Override
    public String getName() {
        return "Color Picker";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }
    
    // check on this one
    @Override
    public String getFormBuilderCategory() {
        return FormBuilderPalette.CATEGORY_CUSTOM;
    }

    @Override
    public String getLabel() {
        return AppPluginUtil.getMessage("org.joget.ColorPickerField.pluginLabel", getClassName(), MESSAGE_PATH);
    }

    @Override
    public String getDescription() {
        return AppPluginUtil.getMessage("org.joget.ColorPickerField.pluginDesc", getClassName(), MESSAGE_PATH);
    }

    @Override
    public String getPropertyOptions() {
        return AppUtil.readPluginResource(getClass().getName(), "/properties/form/colorPickerField.json", null, true, MESSAGE_PATH);
    }

    @Override
    public String renderTemplate(FormData formData, Map dataModel){
        String template = "colorPickerField.ftl";

        // set value
        String value = FormUtil.getElementPropertyValue(this, formData);
        dataModel.put("value", value);

        String html = FormUtil.generateElementHtml(this, formData, template, dataModel);
        return html;   
    }

    @Override
    public String getFormBuilderTemplate() {
        return "<label class='label'>"+getLabel()+"</label>";
    }

    @Override
    public String getFormBuilderIcon() {
        return "/images/colorPicker_icon.png";
    }

    @Override
    public int getFormBuilderPosition() {
        return 100;
    }
}
