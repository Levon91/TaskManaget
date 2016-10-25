'use strict';

TaskManager.app.services.service('UserService',
    ['$http', 'Config',
        function ($http, Config) {

            this.create = function (user, callback) {
                $http({
                    method: 'POST',
                    url: Config.BASE_URL + '/users',
                    data: user,
                    headers: {'Content-Type': 'application/json'}
                }).then(function (response) {
                    callback(response);
                }, function (response) {
                    callback(response);
                });
            };

            this.isEmailExist = function (email, callback) {
                $http({
                    method: 'POST',
                    url: Config.BASE_URL + '/users/exist/' + email,
                    headers: {'Content-Type': 'application/json'}
                }).then(function (response) {
                    callback(response);
                }, function (response) {
                    callback(response);
                });
            };

            this.getUserByEmailPassword = function (email, password, callback) {
                $http({
                    method: 'POST',
                    url: Config.BASE_URL + '/users/me',
                    headers: {'Content-Type': 'application/json'},
                    //headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                    //headers: {'Content-Type': 'multipart/form-data'},
                    params: {email: email, password: password},
                    async: true
                    //data: {email: email, password: password}
                }).then(function (response) {
                    if (response.hasOwnProperty('error')) {
                        callback('error');
                    } else {
                        callback(response.data);
                    }
                }, function (response) {
                    callback('error');
                });
            };

            this.getUsers = function (callback) {
                $http({
                    method: 'GET',
                    url: Config.BASE_URL + '/users'
                }).then(function (response) {
                    callback(response);
                }, function (response) {
                    callback(response);
                });
            };

        }
    ]
);