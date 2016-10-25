'use strict';

/**
 * Task controller
 */

TaskManager.app.controllers.controller('task',
    ['$rootScope', '$scope', 'UserService', 'ProjectService', '$state', 'Config', 'storage',
        function ($rootScope, $scope, UserService, ProjectService, $state, Config, storage) {
            console.info('task controller started');

            $scope.task = {};

            ($scope.getUsers = function () {
                UserService.getUsers(function (response) {
                    console.info(response);
                    $scope.users = response.data;
                });
            })();

            ($scope.getProjects = function () {
                ProjectService.getProjects(function (response) {
                    console.info(response);
                    $scope.projects = response.data;
                });
            })();

        }
    ]
);