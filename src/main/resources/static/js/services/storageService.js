'use strict';

TaskManager.app.services.service('storage', ['ipCookie', function (ipCookie) {

    this.put = function (key, value) {
        ipCookie(key, value);
    };

    this.get = function (key) {
        return ipCookie(key);
    };

    this.remove = function (key) {
        ipCookie.remove(key);
    };


}]);