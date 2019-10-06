dovezi2.factory('restaurantService', function ($http) {

    var restService = {};

    restService.getAllRestaurants = function () {
        return $http.get('/dovezi2_rest_war_exploded/webapi/restaurants/restorani');
    };

    restService.getRestaurantByName = function (name) {
        return $http.get('/dovezi2_rest_war_exploded/webapi/restaurants/restorani/ime=' + name);
    };

    restService.getRestaurantsByCategory = function (cat) {
        return $http.get('/dovezi2_rest_war_exploded/webapi/restaurants/restorani/kategorija=' + cat);
    };

    restService.getRestaurantsByAddress = function (adr) {
        return $http.get('/dovezi2_rest_war_exploded/webapi/restaurants/restorani/adresa=' + adr);
    };

    restService.addRestaurant = function (rest) {
        return $http.post('/dovezi2_rest_war_exploded/webapi/restaurants/add', rest);
    };

    restService.deleteRestaurant = function (id) {
        return $http.put('/dovezi2_rest_war_exploded/webapi/restaurants/delete=' + id);
    };

    restService.editRestaurant = function (id, rest) {
        return $http.put('/dovezi2_rest_war_exploded/webapi/restaurants/edit=' + id, rest);
    };

    restService.getFoods = function (name) {
        return $http.get('/dovezi2_rest_war_exploded/webapi/restaurants/restorani/' + name + '/meals');
    };

    restService.getDrinks = function (name) {
        return $http.get('/dovezi2_rest_war_exploded/webapi/restaurants/restorani/' + name + '/drinks');
    };

    return restService;
});