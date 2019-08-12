dovezi2.controller('CustomerController', function ($scope, userService) {

    function initUser() {
        userService.getLoggedUser().success(function (data) {
            $scope.loadedUserUsername = data.username;

            setData();
        });
    }

    function setData() {
        userService.getCustomer($scope.loadedUserUsername).success(function (userData) {
            $scope.loadedUser = userData;
        });
    }

    initUser();

    $scope.loadedUser = {};
    $scope.loadedUserUsername = '';
    $scope.price = 0;
    $scope.orderDescription = '';

    $scope.showDataFlag = true;
    $scope.showCartFlag = false;
    $scope.showFavoritesFlag = false;

    $scope.personalData = function () {
        userService.getCustomer($scope.loadedUser.username).success(function () {
            $scope.showDataFlag = true;
            $scope.showCartFlag = false;
            $scope.showFavoritesFlag = false;
        });
    };

    $scope.korpa = function(){

    };
});