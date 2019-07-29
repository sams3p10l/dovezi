dovezi2.controller('RegisterController', function ($scope, userService, $window) {

    $scope.user = {
        username: '',
        password: '',
        firstName: '',
        lastName: '',
        phone: '',
        email: ''
    };

    $scope.registration = function (user) {
        user.username = user.username.toLowerCase();

        userService.register(user).success(function (response) {
            if (response.data === "User already exists")
            {
                alert("Greska, korisnik vec postoji");
            }
            else
                $window.location.href = '/dovezi2/#/';
        });
    };

    $scope.kurcina = function () {

        console.log("USO U KURCINU");

        userService.kurcina().success(function (response) {
            if (response.data === "KURCINA")
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