dovezi2.factory('userService', function ($http) {

    var service = {};

    service.getAllUsers = getAllUsers;
    service.getLoggedUser = getLoggedUser;
    service.login = login;
    service.register = register;

    return service;

    function getAllUsers()
    {
        return $http.get('../../../src/main/java/func/user/allUsers');
    }

    function getLoggedUser()
    {
        return $http.get('../../../src/main/java/func/user/loggedUser');
    }

    function login(user)
    {
        return $http.post('../../../src/main/java/func/user/login', user);
    }

    function register(user)
    {
        return $http.post('../../../src/main/java/func/user/loggedUser', user);
    }
});