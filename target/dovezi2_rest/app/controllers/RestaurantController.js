dovezi2.controller('RestaurantController', function ($scope, userService) {

    $scope.loadedUser = "";

    initUser();

    function initUser() {
        userService.getLoggedUser().success(function (data) {
            $scope.loadedUser = data.username;

        });
    }

});