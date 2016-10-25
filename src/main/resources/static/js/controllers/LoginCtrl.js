'use strict';

/**
 * Login controller
 */

TaskManager.app.controllers.controller('login',
    ['$rootScope', '$scope', '$state', 'OauthService', 'Config', '$timeout', 'storage', 'UserService',
        function ($rootScope, $scope, $state, OauthService, Config, $timeout, storage, UserService) {

            $rootScope.isLoading = false;

            $rootScope.data = {
                username: 'admin@mail.ru',
                password: 'admin'
            };

            $scope.login = function () {
                $rootScope.isLoading = true;
                OauthService.login($rootScope.data, function (user) {

                    $timeout(function () {
                        UserService.getUserByEmailPassword($rootScope.data.username, $rootScope.data.password, function (user) {

                            $rootScope.isLoading = false;

                            if (user == 'error') {
                                console.error(user);
                                $rootScope.error = "Incorrect email or password";
                            } else {
                                //$scope.user = user;
                                storage.put(Config.USER_KEY, user);
                                if (user.admin) {
                                    $state.go(Config.routes.admin_home);
                                } else {
                                    $state.go(Config.routes.home);
                                }
                            }
                            console.info(user);
                        });
                    }, 1500);

                });

            };
        }
    ]
);