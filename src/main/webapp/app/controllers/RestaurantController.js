dovezi2.controller('RestaurantController', function ($scope, userService) {

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
        
    };

});