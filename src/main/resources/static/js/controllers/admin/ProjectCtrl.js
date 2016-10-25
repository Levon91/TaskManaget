'use strict';

/**
 * Task controller
 */

TaskManager.app.controllers.controller('project',
    ['$rootScope', '$scope', 'ProjectService', '$state', 'Config',
        function ($rootScope, $scope, ProjectService, $state, Config) {
            console.info('project controller started');

            $scope.project = {};

            $scope.create = function () {
                ProjectService.create($scope.project, function (response) {
                    if (response.data.status) {
                        $state.go(Config.routes.admin_home);
                    } else {
                        $scope.error = response.data.message;
                    }
                });
            };

        }
    ]
);