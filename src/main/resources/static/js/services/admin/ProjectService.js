'use strict';

TaskManager.app.services.service('ProjectService',
    ['$http', 'Config',
        function ($http, Config) {

            this.create = function (project, callback) {
                $http({
                    method: 'POST',
                    url: Config.BASE_URL + '/projects',
                    data: project,
                    headers: {'Content-Type': 'application/json'}
                }).then(function (response) {
                    callback(response);
                }, function (response) {
                    callback(response);
                });
            };

            this.getProjects = function (callback) {
                $http({
                    method: 'GET',
                    url: Config.BASE_URL + '/projects'
                }).then(function (response) {
                    callback(response);
                }, function (response) {
                    callback(response);
                });
            };

        }
    ]
);