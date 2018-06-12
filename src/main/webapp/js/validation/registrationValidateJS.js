function validate() {
    var firstName = document.forms['form']['firstName'].value;
    var secondName = document.forms['form']['secondName'].value;
    var email = document.forms['form']['email'].value;
    var password = document.forms['form']['password'].value;
    var passwordConfirm = document.forms['form']['passwordConfirm'].value;

    var checkFirstName = checkName(firstName, 'firstName');
    var checkSecondName = checkName(secondName, 'secondName');
    var checkEmail = checkEmail(email);
    var checkPassword = checkPassword(password, passwordConfirm);

    return checkFirstName && checkSecondName && checkEmail && checkPassword;

    function checkName(name, field) {
        var patt = /^[a-zA-Zа-яёА-ЯЁ\s\-]+$/;
        if (patt.test(name)) {
            document.getElementById(field + 'Message').innerHTML = '';
            return true;
        }
        document.getElementById(field + 'Message').innerHTML = 'name should contains only letters and "-"';
        return false;
    }

    function checkEmail(mail) {
        var patt = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        if (patt.test(mail)) {
            document.getElementById('emailMessage').innerHTML = '';
            return true;
        }
        document.getElementById('emailMessage').innerHTML = 'wrong email. ex@ex.ex';
        return false;
    }

    function checkPassword(password, passwordConfirm) {
        var patt = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$/;
        if (patt.test(password)) {
            if (passwordConfirm === password) {
                document.getElementById('passwordMessage').innerHTML = '';
                document.getElementById('passwordConfirmMessage').innerHTML = '';
                return true;
            } else {
                document.getElementById('passwordMessage').innerHTML = 'passwords do not match';
                document.getElementById('passwordConfirmMessage').innerHTML = 'passwords do not match';
                return false;
            }
        } else {
            document.getElementById('passwordMessage').innerHTML = 'password must contain lowercase, uppercase letters and numbers';
            return false;
        }
    }
}