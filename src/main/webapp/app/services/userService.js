dovezi2.factory('userService', function ($http) {

    var service = {};

    service.getAllUsers = getAllUsers;
    service.getLoggedUser = getLoggedUser;
    service.login = login;
    service.register = register;
    service.logout = logout;
    service.getCustomer = getCustomer;
    service.getCustomers = getCustomers;
    service.getAdmins = getAdmins;
    service.getDeliverers = getDeliverers;

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

    function logout() {
        return $http.get('/dovezi2_rest_war_exploded/webapi/user/logout');
    }

    function getCustomer(username) {
        return $http.get('/dovezi2_rest_war_exploded/webapi/user/customers/' + username);
    }

    function getCustomers() {
        return $http.get('/dovezi2_rest_war_exploded/webapi/user/customers');
    }

    function getAdmins() {
        return $http.get('/dovezi2_rest_war_exploded/webapi/user/admins');
    }

    function getDeliverers() {
        return $http.get('/dovezi2_rest_war_exploded/webapi/user/deliverers');
    }
});