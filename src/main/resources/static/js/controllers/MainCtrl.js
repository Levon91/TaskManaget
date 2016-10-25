'use strict';

/**
 * Main controller
 */

TaskManager.app.controllers.controller('main',
    ['$rootScope', '$scope', 'OauthService', 'OAuth', '$state', 'Config', '$timeout', 'storage',
        function ($rootScope, $scope, OauthService, OAuth, $state, Config, $timeout, storage) {
            console.info('main controller started');

            $scope.logout = function () {
                OauthService.logout(function() {
                    $timeout(function () {
                        $state.go(Config.routes.login.name);
                    }, 100);
                });
            };

            if (storage.get(Config.USER_KEY) != undefined) {
                $rootScope.user = storage.get(Config.USER_KEY);
                if(OAuth.isAuthenticated()) {
                    console.info('authenitacted');
                } else {
                    console.info('not authenitacted');
                    storage.remove(Config.USER_KEY);
                    storage.remove(Config.USER_KEY);
                }
            }

        //    ******************************    //
        }
    ]
);