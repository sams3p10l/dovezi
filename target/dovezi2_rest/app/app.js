var dovezi2 = angular.module('dovezi2', ['ngRoute']);

dovezi2.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix('');

    $routeProvider
        .when('/', {
            controller: 'HomeController',
            templateUrl: 'pages/home.html'
        })
        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'pages/login.html'
        })
        .when('/registration', {
            controller: 'RegisterController',
            templateUrl: 'pages/register.html'
        })
        .when('/user/customers/:username', {
            controller: 'CustomerController',
            templateUrl: 'pages/userProfile.html'
        })
        .when('/restaurants', {
            controller: 'RestaurantController',
            templateUrl: 'pages/restaurants.html'
        })
        .when('/user/admins/:username', {
            controller: 'AdminController',
            templateUrl: 'pages/adminPage.html'
        })
}]);



dovezi2.config(function ($logProvider) {
    $logProvider.debugEnabled(true)
});