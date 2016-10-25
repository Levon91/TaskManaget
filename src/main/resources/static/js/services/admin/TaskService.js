'use strict';

TaskManager.app.services.service('TaskService',
    ['$http', 'Config',
        function ($http, Config) {

            this.create = function (task, callback) {
                $http({
                    method: 'POST',
                    url: Config.BASE_URL + '/tasks',
                    data: user,
                    headers: {'Content-Type': 'application/json'}
                }).then(function (response) {
                    callback(response);
                }, function (response) {
                    callback(response);
                });
            };

        }
    ]
);