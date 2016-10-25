'use strict';

/**
 * User controller
 */

TaskManager.app.controllers.controller('user',
    ['$rootScope', '$scope', 'UserService', '$state', 'Config', 'storage',
        function ($rootScope, $scope, UserService, $state, Config, storage) {
            console.info('user controller started');

            $scope.errors = {};
            $scope.user = {
                firstName: '',
                lastName: '',
                email: '',
                password: ''
            };
            $scope.re_password = '';

            $scope.create = function () {
                UserService.create($scope.user, function (response) {
                    if (response) {
                        $rootScope.success = "Success.";
                        $state.go(Config.routes.admin_home);
                    } else {
                        $rootScope.error = "Error please try again.";
                    }
                });
            };

            $scope.isEmailExist = function () {
                UserService.isEmailExist($scope.user.email, function (response) {
                    if (response.data.code != 404) {
                        $scope.errors.email = 'Email already exist.';
                    }
                });
            }

        }
    ]
);