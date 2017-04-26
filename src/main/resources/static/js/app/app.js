var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/',
    PROJECT_SERVICE_API : 'http://localhost:8080/api/project/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'ProjectController',
                controllerAs:'ctrl',
                resolve: {
                    projects: function ($q, ProjectService) {
                        console.log('Load all projects');
                        var deferred = $q.defer();
                        ProjectService.loadAllProjects().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

