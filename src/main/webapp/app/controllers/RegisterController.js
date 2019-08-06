dovezi2.controller('RegisterController', function ($scope, userService, $window) {

    $scope.user = {
        username: '',
        password: '',
        firstName: '',
        lastName: '',
        phone: '',
        email: ''
    };

    $scope.register = function (user) {
        user.username = user.username.toLowerCase();

        userService.register(user).success(function (response) {
            console.log(response);

            if (response === "User already exists")
            {
                alert("Greska, korisnik vec postoji");
            }
            else if (response === "SVE OK")
                $window.location.href = '/dovezi2_rest_war_exploded/#/';
        });
    };

    $scope.kurcina = function () {

        console.log("USO U KURCINU");

        userService.kurcina().success(function (response) {
            if (response === "KURCINA")
            {
                alert("KURCINA");
                console.log("KURAC");
            }
            else if (response === "undefined")
            {
                alert("NE RADI");
                console.log("RESPONSE UNDEFINED");
            }
        });

    };

});