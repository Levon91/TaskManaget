'use strict';

/**
 * Home controller
 */

TaskManager.app.controllers.controller('CreateUser',
    ['$scope', '$modalInstance', 'items',
        function ($scope, $modalInstance, items) {
            console.info('home controller started');

            if (storage.get(Config.USER_KEY) == undefined) {
                UserService.getUserByEmailPassword($rootScope.data.username, $rootScope.data.password, function (response) {
                    if (response == 'error') {
                        console.error(response);
                    } else {
                        $scope.user = response;
                        storage.put(Config.USER_KEY, response);
                    }
                });
            } else {
                $scope.user = storage.get(Config.USER_KEY);
            }

        }
    ]
);