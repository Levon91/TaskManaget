'use strict';

TaskManager.app.services.service('OauthService',
    ['$http', 'OAuth', 'OAuthToken', 'Config',
        function ($http, OAuth, OAuthToken, Config) {
            var encoded = btoa(Config.CLIENT_ID + ':' + Config.CLIENT_SECRET);
            var options = {
                headers: {
                    "Authorization": "Basic " + encoded,
                    'Content-Type': 'application/x-www-form-urlencoded',
                    'accept': '*/*'
                }
            };

            this.login = function (user, callback) {
                OAuth.getAccessToken(user, options);
                callback();
            };

            this.logout = function (callback) {
                OAuth.revokeToken();
                callback();
            };

        }]);