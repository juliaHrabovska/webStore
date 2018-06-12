$(function () {

        var isEmailValid = false;
        var isPassValid = false;
        var isNameValid = false;

        $('#login').on('click', function () {
            $('input').each(function () {

                var formGroup = $(this).parents('.form-group');
                var check = false;

                if ((this.name) === ("email")) {
                    check = checkEmail(this.value);
                } else if ((this.name) === ("password")) {
                    check = checkPassword(this.value);
                }

                if (check) {
                    formGroup.addClass('has-success').removeClass('has-error');
                } else {
                    formGroup.addClass('has-error').removeClass('has-success');
                }
            });

            if (isPassValid && isEmailValid) {
                return true;
            } else {
                return false;
            }
        });

        function checkEmail(mail) {
            var patt = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            if (patt.test(mail)) {
                isEmailValid = true;
                return true;
            }
            return false;
        }

        function checkPassword(value) {
            if (value.length >= 6) {
                isPassValid = true;
                return true;
            }
            return false;
        }
})
;