'use strict';

angular.module('crudApp').factory('MessageService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllUsers: loadAllUsers,
                getAllUsers: getAllUsers,
                getUser: getUser,
                createUser: createUser,
                updateUser: updateUser,
                removeUser: removeUser
            };

            return factory;

            function loadAllUsers() {
                console.log('Carregando todas as mensagens');
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Todas as mensagem carregadas');
                            $localStorage.message = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Erro ao carregar mensagens');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllUsers(){
                return $localStorage.message;
            }

            function getUser(id) {
                console.log('Carregando mensagem :'+id);
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Mensagem carregada com sucesso :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Erro ao carregar a mensagem :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createUser(user) {
                console.log('Criando mensagem');
                var deferred = $q.defer();
                $http.post(urls.USER_SERVICE_API, user)
                    .then(
                        function (response) {
                            loadAllUsers();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Erro ao criar a mensagem : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateUser(message, id) {
                console.log('Atualizando mensagem  '+id);
                var deferred = $q.defer();
                $http.put(urls.USER_SERVICE_API + id, message)
                    .then(
                        function (response) {
                            loadAllUsers();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Erroao atualizar mensagem :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeUser(id) {
                console.log('Removendo mensagem '+id);
                var deferred = $q.defer();
                $http.delete(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllUsers();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Erro ao remover a mensagem :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);