<div class="form-cell color_picker" ${elementMetaData!}>
    <script type="text/javascript" src="${request.contextPath}/plugin/org.joget.ColorPickerField/js/colourpicker.js"></script>
    <link rel="stylesheet" href="${request.contextPath}/plugin/org.joget.ColorPickerField/css/colpick.css">

    <script type="text/javascript">
        $(document).ready(function() {
            var field = "#${elementParamName!}";

            $(field).colpick({
                submit: false, // this line removes the submit button
                onChange:function(hsb,hex,rgb,el) {
                    $(el).css('background-color', '#' + hex); // Change background of the field itself
                    $(el).val('#' + hex);
                },
                onHide:function(el){
                    $(el).colpickSetColor($(el).css('background-color'));
                },
                onShow: function(el) {
                    var offset = $(el).offset();
                    $('.colpick').css({
                        'top': offset.top + $(el).outerHeight() + -150 + 'px', // Position right below the field with 5px gap
                        'left': offset.left + '690px' // Align to the left of the field
                    });
                }
            });
        });
    </script>

    <label class="label">${element.properties.label} <span class="form-cell-validator">${decoration}</span><#if error??> <span class="form-error-message">${error}</span></#if></label>

    <#if (element.properties.readonly! == 'true' && element.properties.readonlyLabel! == 'true') >
        <div class="form-cell-value"><span>${value!?html}</span></div>
        <input id="${elementParamName!}" name="${elementParamName!}" type="hidden" class="colorPicker" value="${value!?html}" />
    <#else>
        <input id="${elementParamName!}" name="${elementParamName!}" type="text" class="colorPicker" size="${element.properties.size!}" value="${value!?html}" maxlength="${element.properties.maxlength!}" <#if error??>class="form-error-cell"</#if> <#if element.properties.readonly! == 'true'>readonly</#if> />
    </#if>
</div>