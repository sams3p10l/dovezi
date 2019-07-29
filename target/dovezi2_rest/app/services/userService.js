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
        return $http.get('/dovezi2/api/user/allUsers');
    }

    function getLoggedUser()
    {
        return $http.get('/dovezi2/api/user/loggedUser');
    }

    function login(user)
    {
        return $http.post('../../../src/main/java/func/user/login', user);
    }

    function register(user)
    {
        return $http.post('/dovezi2/api/user/register', user);
    }

    function kurcina() {
        return $http.get('/dovezi2/#/api/user/kurac');
    }
});