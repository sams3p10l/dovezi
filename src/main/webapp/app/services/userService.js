dovezi2.factory('userService', function ($http) {

    var service = {};

    service.getAllUsers = getAllUsers;
    service.getLoggedUser = getLoggedUser;
    service.login = login;
    service.register = register;
    service.kurcina = kurcina;

    return service;

    function getAllUsers()
    {
        return $http.get('/dovezi2_rest_war_exploded/webapi/user/getAllUsers');
    }

    function getLoggedUser()
    {
        return $http.get('/dovezi2_rest_war_exploded/webapi/user/loggedUser');
    }

    function login(user)
    {
        return $http.post('/dovezi2_rest_war_exploded/webapi/user/login', user);
    }

    function register(user)
    {
        return $http.post('/dovezi2_rest_war_exploded/webapi/user/register', user);
    }

    function kurcina() {
        return $http.get('/dovezi2_rest_war_exploded/webapi/user/kurac');
    }
});