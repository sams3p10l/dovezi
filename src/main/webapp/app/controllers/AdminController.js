dovezi2.controller('AdminController', function ($scope, $window, userService, restaurantService) {

    function initUser() {
        userService.getLoggedUser().success(function (data) {
            $scope.user = data;
        });
    }

    $scope.categories = ['DOMACA_KUHINJA', 'ROSTILJ','KINESKI_RESTORAN','INDIJSKI_RESTORAN','POSLASTICARNICA','PICERIJA'];
    $scope.users =['ADMINISTRATOR','KUPAC','DOSTAVLJAC'];
    $scope.vehicles = ['BICIKL', 'AUTOMOBIL', 'SKUTER'];
    $scope.itemTypes = ['HRANA', 'PICE'];

    $scope.showUsersFlag = false;
    $scope.showRestaurantsFlag = false;
    $scope.showVehiclesFlag = false;
    $scope.showDataFlag = true;
    $scope.deleteFoodFlag = false;
    $scope.deleteDrinkFlag = false;

    $scope.func = '';
    $scope.username = '';

    initUser();

    $scope.personalData = function () {
        userService.getLoggedUser().success(function () {
            $scope.showDataFlag = true;
            $scope.showRestaurantsFlag = false;
            $scope.showUsersFlag = false;
            $scope.showVehiclesFlag = false;
        });
    };

    $scope.getUsers = function (user) {
        if(user === 'ADMINISTRATOR'){
            userService.getAdmins().success(function (data) {
                $scope.korisnici = data;
                $scope.showUsersFlag = true;
            });
        }
        else if (user === 'KUPAC'){
            userService.getCustomers().success(function (data) {
                $scope.korisnici = data;
                $scope.showUsersFlag = true;
            });
        }
        else if (user === 'DOSTAVLJAC'){
            userService.getDeliverers().success(function (data) {
                $scope.korisnici = data;
                $scope.showUsersFlag = true;
            });
        }
    };

    $scope.showUsers = function () {
        $scope.showUsersFlag = true;
        $scope.showRestaurantsFlag = false;
        $scope.showVehiclesFlag = false;
        $scope.showDataFlag = false;
    };

});