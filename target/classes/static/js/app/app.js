var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    	BASE: 'http://localhost:8080/scrapbook',
        USER_SERVICE_API : 'http://localhost:8080/scrapbook/recados/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'MessageController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, MessageService) {
                        console.log('Primeira chamada');
                        var deferred = $q.defer();
                        MessageService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

