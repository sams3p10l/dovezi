dovezi2.controller('HomeController', function($scope, userService) {

    $scope.notLoggedFlag = true;
    $scope.loggedFlag = false;
    $scope.user = {};
    $scope.loggedFn = '';

    function getLoggedUser() {
        userService.getLoggedUser().success(function (data) {
            if (data === undefined)
            {
                $scope.notLoggedFlag = true;
                $scope.loggedFlag = false;
            }
            else
            {
                $scope.notLoggedFlag = false;
                $scope.loggedFlag = true;
                $scope.user = data;
            }
        });
    }

    getLoggedUser();

    $scope.goToProfile = function () {
        if($scope.user.role === "ADMINISTRATOR")
            location.href = '/dovezi2/#/'
    };

    $scope.logout = function() {
        userService.logout().success(function() {
            $scope.notLoggedFlag = true;
            $scope.loggedFlag = false;
            location.href = '/dovezi2/#/';
        });
    };

});