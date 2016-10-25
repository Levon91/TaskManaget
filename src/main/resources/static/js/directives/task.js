'use strict';

TaskManager.app.directives.directive('task',function(){
    return {
        restrict: 'E',
        scope : {
            task : '='
        },
        templateUrl: '/partials/pages/directives/task.html',

        link : function(scope, element, attrs){
            element.bind('click',function(){
            });
        },
        controller: function($scope, $rootScope) {

        }
    }
});
