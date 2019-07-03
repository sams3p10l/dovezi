var dovezi = angular.module('dovezi', ['ngRoute']);

dovezi.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
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
}]);

dovezi.config(function ($logProvider) {
    $logProvider.debugEnabled(true)
});