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
        });
    console.log("poyy");
}]);

dovezi2.config(function ($logProvider) {
    $logProvider.debugEnabled(true)
    console.log("poyy");
});