'use strict';

TaskManager.app.config(function ($stateProvider, $urlRouterProvider, Config) {

    // For any unmatched url, redirect to /login
    $urlRouterProvider.otherwise(Config.routes.login.name);

     //Now set up the states
    for(var stateName in Config.routes) {
        var routParams = Config.routes[stateName];
        $stateProvider.state(stateName, routParams);
    }

});