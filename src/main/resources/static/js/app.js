'use strict';

TaskManager.app = angular.module('TaskManager', [
    'ui.router',
    'angular-oauth2',
    //'ui.bootstrap',
    'TaskManager.app.controllers',
    'TaskManager.app.services',
    'TaskManager.app.directives',
    'TaskManager.app.filters'
]);