dovezi2.controller('AdminController', function ($scope, $window, userService, restaurantService) {

    function initUser() {
        userService.getLoggedUser().success(function (data) {
            $scope.user = data;
        });
    }

    $scope.categories = ['DOMACA_KUHINJA', 'ROSTILJ','KINESKI_RESTORAN','INDIJSKI_RESTORAN','POSLASTICARNICA','PICERIJA'];
    $scope.categoriesModal = ['DOMACA_KUHINJA', 'ROSTILJ','KINESKI_RESTORAN','INDIJSKI_RESTORAN','POSLASTICARNICA','PICERIJA'];
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

    $scope.restaurant = {
        naziv: '',
        adresa: '',
        kategorija: '',
        id: ''
    };

    $scope.restaurantAdd = {
        naziv: '',
        adresa: '',
        kategorija: '',
        id: ''
    };

    $scope.restaurantEdit = {
        naziv: '',
        adresa: '',
        kategorija: '',
        id: ''
    };

    $scope.personalData = function () {
        userService.getLoggedUser().success(function () {
            $scope.showDataFlag = true;
            $scope.showRestaurantsFlag = false;
            $scope.showUsersFlag = false;
            $scope.showVehiclesFlag = false;
        });
    };

    $scope.getUsers = function (pUser) {
        if(pUser === 'ADMINISTRATOR'){
            userService.getAdmins().success(function (data) {
                $scope.korisnici = data;
                $scope.showUsersFlag = true;
            });
        }
        else if (pUser === 'KUPAC'){
            userService.getCustomers().success(function (data) {
                $scope.korisnici = data;
                $scope.showUsersFlag = true;
            });
        }
        else if (pUser === 'DOSTAVLJAC'){
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

    $scope.showRestaurants = function() {
        $scope.showUsersFlag = false;
        $scope.showRestaurantsFlag = true;
        $scope.showVehiclesFlag = false;
        $scope.showDataFlag = false;

        restaurantService.getAllRestaurants().success(function (data) {
            $scope.restaurants = data;
        })
    };

    $scope.modalEditUser = function (pUser) {
        $scope.func = pUser.uloga;
        $scope.korisnik = pUser;
    };

    $scope.editUser = function (pUser) {
        pUser.uloga = $scope.func;
        $scope.username = pUser.username;

        if (pUser.uloga === "ADMINISTRATOR"){
            userService.setAdminFunction(pUser.uloga, pUser.username).success(function (data) {
                $scope.showUsersFlag = true;
            })
        }
        else if (pUser.uloga === "KUPAC"){
            userService.setCustomerFunction(pUser.uloga, pUser.username).success(function (data) {
                $scope.showUsersFlag = true;
            })
        }
        else if (pUser.uloga === "DOSTAVLJAC"){
            userService.setDelivererFunction(pUser.uloga, pUser.username).success(function (data) {
                $scope.showUsersFlag = true;
            })
        }
    };

    $scope.addRestaurant = function (rest) {
        restaurantService.addRestaurant(rest).success(function (data) {
            alert(data);
        });
    };

    $scope.showMenu = function (rest) {

    };

    $scope.modalEditRestaurant = function (rest) {
        $scope.oldId = rest.id;
        $scope.restaurantEdit = rest;
    };

    $scope.modalDeleteRestaurant = function (rest) {
        $scope.restaurant = rest;
    };

    $scope.editRestaurant0 = function (id) {
                restaurantService.editRestaurant(id, $scope.restaurantEdit).success(function (data) {
            alert(data);
        });
    };

    $scope.deleteRestaurant = function (id) {
        restaurantService.deleteRestaurant(id).success(function (data) {
            alert(data);
        });
    };

});