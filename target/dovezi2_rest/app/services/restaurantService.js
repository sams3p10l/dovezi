dovezi2.factory('restaurantService', function ($http) {

    var restService = {};

    restService.getAllRestaurants = function () {
        return $http.get('/dovezi2_rest_war_exploded/webapi/restaurants/restorani');
    };

    restService.getRestaurantByName = function (name) {
        return $http.get('/dovezi2_rest_war_exploded/webapi/restaurants/restorani/' + name);
    };

    return restService;
});