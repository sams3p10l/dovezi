dovezi2.controller('CustomerController', function ($scope, userService) {

    function initUser() {
        userService.getLoggedUser().success(function (data) {
            $scope.loadedUser = data;
        });
    }
    initUser();

    $scope.loadedUser = {};
    $scope.price = 0;
    $scope.orderDescription = '';

    $scope.showDataFlag = true;
    $scope.showCartFlag = false;
    $scope.showFavoritesFlag = false;

    $scope.personalData = function () {
        userService.getLoggedUser().success(function () {
            $scope.showDataFlag = true;
            $scope.showCartFlag = false;
            $scope.showFavoritesFlag = false;
        });
    };

    $scope.korpa = function(){

    };
});