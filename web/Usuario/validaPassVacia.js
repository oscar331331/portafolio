
    function validapassvacia(){
        var pas1 = $("#pass1").val();
        var pas2 = $("#pass2").val();
        if(pas1===pas2){
            if(pas1.length > 5){
                if (pas1.indexOf(' ') > -1) {
                    alert("La contraseña no pueden contener espacios.");
                    $("#pass1").focus();
                    return false;
                  }
                  else
                      return true;
            }
            else if (pas1.length === 0)
                return true;
            else {
                alert('La contraseña debe tener minimo 6 caracteres.');
                $("#pass1").focus();
                return false;
            }
        }
        else {
            alert('Las contraseñas no coinciden.');
            $("#pass1").focus();
            return false;
        }
    }