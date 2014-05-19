(function($){

    function _init(){
        _initValidate();
        _initEvent();
    }



    function _initValidate(){

        $('#form-signin').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                name: {
                    validators: {
                        notEmpty: {
                            message: 'The name is required and cannot be empty'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: 'The password is required and cannot be empty'
                        }
                    }
                }
            }

        });

    }

    function _initEvent(){

    }


    _init();

})(jQuery);