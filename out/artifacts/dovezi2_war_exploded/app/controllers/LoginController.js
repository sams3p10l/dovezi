dovezi2.controller('LoginController', function ($scope, userService, $window) {

    $scope.user = {
        username : '',
        password : ''
    };

    $scope.loginCnt = function (user)
    {
        userService.login(user).success(function (data) {
            if (data.username === undefined || data.password === undefined) {}
            else
            {
                if(data.uloga === "KUPAC"){
                    $window.location.href = '/dovezi2/#';
                }
                if(data.uloga === "ADMINISTRATOR"){
                    $window.location.href = '/dovezi2/#';
                }
                if(data.uloga === "DOSTAVLJAC"){
                    $window.location.href = '/dovezi2/#';
                }
            }
        });
    };

});