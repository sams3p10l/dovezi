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

        userService.register(user).success(function (data) {
            if (data === "User already exists")
            {
                alert("Greska, korisnik vec postoji");
            }
            else
                $window.location.href = '/dovezi2/#/';
        });
    };

});