'use strict';

/**
 * Register controller
 */

TaskManager.app.controllers.controller('register',
    ['$rootScope', "$scope", 'UserService', '$state', 'Config',
        function ($rootScope, $scope, UserService, $state, Config) {
            console.info('registration controller started');

            $scope.user = {
                firstName : '',
                lastName : '',
                email : '',
                password : ''
            };
            $scope.re_password = '';

            $scope.register = function () {
                UserService.create($scope.user, function (response) {
                    if (response) {
                        $rootScope.success = "Your registration copulated successfully, please activate check your email.";
                        $state.go(Config.routes.login.name);
                    } else {
                        $rootScope.error = "Error please try again.";
                    }
                });
            };

            $scope.isEmailExist = function () {
                UserService.isEmailExist($scope.user.email, function (response) {
                    if (response.status != 404) {
                        $scope.errors.email = 'Email already exist.';
                    }
                });
            }

        }
    ]
);