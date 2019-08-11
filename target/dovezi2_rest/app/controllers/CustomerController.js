dovezi2.controller('CustomerController', function ($scope, userService, orderService) {

    function initUser() {
        userService.getLoggedUser().success(function (data) {
            $scope.user = data;
        });
    }
    initUser();

    $scope.user = {};
    $scope.price = 0;
    $scope.orderDescription = '';

    $scope.showDataFlag = false;
    $scope.showCartFlag = false;
    $scope.showFavoritesFlag = false;

    $scope.personalData = function () {
        userService.getLoggedUser.success(function (data) {
            $scope.showDataFlag = true;
            $scope.showCartFlag = false;
            $scope.showFavoritesFlag = false;
        });
    };

    $scope.korpa = function(){

    };
});