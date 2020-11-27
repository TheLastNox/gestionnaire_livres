
(function ($) {
    "use strict";

    
    var input = $('.validate-input .input100');
    
    $('#checkbox').on('click', function(){
        for(let i=0; i<input.length; i++) {
			if($(input[i]).attr('name') == 'memberId') {
                $(this).is(':checked') ? $(input[i]).attr('type', 'text') : $(input[i]).attr('type', 'password');
            }
        }
    });
    

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'password' || $(input).attr('name') == 'memberId') {
            if($(input).val().trim().match(/[A-Z0-9]+/g) == null || $(input).val().length != 6) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    
    

})(jQuery);