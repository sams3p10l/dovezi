(function () {
    'use strict';

    angular
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$scope' , 'userService', '$window'];
    function LoginController($scope, userService, $window)
    {
        $scope.user = {
            username : '',
            password : ''
        };

        $scope.login = function (user)
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
        }
    }
});