dovezi2.controller('HomeController', function($scope, userService) {

    $scope.notLoggedFlag = false;
    $scope.loggedFlag = false;
    $scope.user = {};
    $scope.loggedFn = '';

    function getLoggedUser() {
        userService.getLoggedUser().success(function (data) {
            if (data === "")
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
            location.href = '/dovezi2_rest_war_exploded/#/'
    };

    $scope.logout = function() {
        userService.logout().success(function() {
            $scope.notLoggedFlag = true;
            $scope.loggedFlag = false;
            location.href = '/dovezi2_rest_war_exploded/#/';
        });
    };

});