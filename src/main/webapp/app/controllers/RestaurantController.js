dovezi2.controller('RestaurantController', function ($scope, $routeParams, userService, restaurantService) {

    $scope.loadedUser = "";
    $scope.list = [];

    initUser();

    function initUser() {
        userService.getLoggedUser().success(function (data) {
            $scope.loadedUser = data.username;
        });
    }

    $scope.categories = ['DOMACA', 'ROSTILJ', 'KINESKA', 'INDIJSKA', 'POSLASTICARNICA', 'PICERIJA', 'SVE'];

    $scope.getCategory = function (localCategory) {
        if(localCategory === "SVE")
        {
            restaurantService.getAllRestaurants().success(function (data) {
                $scope.restaurants = data;
                console.log($scope.restaurants);
            });
        }
    };

});