'use strict';

angular.module('crudApp').controller('MessageController',
    ['MessageService', '$scope',  function( MessageService, $scope) {

        var self = this;
        self.message = {};
        self.messagess=[];

        self.submit = submit;
        self.getAllUsers = getAllUsers;
        self.createUser = createUser;
        self.updateUser = updateUser;
        self.removeUser = removeUser;
        self.editUser = editUser;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Enviando pacote');
            if (self.message.id === undefined || self.message.id === null) {
                console.log('Salvando nova mensagem', self.message);
                createUser(self.message);
            } else {
                updateUser(self.message, self.message.id);
                console.log('Mensagem atualizada com id ', self.message.id);
            }
        }

        function createUser(message) {
            console.log('Criando mensagem');
            MessageService.createUser(message)
                .then(
                    function (response) {
                        console.log('mensagem criada com sucesso');
                        self.successMessage = 'mensagem criada com sucesso';
                        self.errorMessage='';
                        self.done = true;
                        self.message={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Erro ao criar mensagem');
                        self.errorMessage = 'Erro ao criar mensagem: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateUser(message, id){
            console.log('Atualizando mensagem');
            MessageService.updateUser(message, id)
                .then(
                    function (response){
                        console.log('Mensagem atualizada com sucesso');
                        self.successMessage='Mensagem atualizada com sucesso';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Erro ao atualizar mensagem');
                        self.errorMessage='Erro ao atualizar mensagem '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeUser(id){
            console.log('Deletando mensagem com id '+id);
            MessageService.removeUser(id)
                .then(
                    function(){
                        console.log('mensagem '+id + ' deletada com sucesso');
                    },
                    function(errResponse){
                        console.error('Erro ao deletar a mensagem '+id +', Erro :'+errResponse.data);
                    }
                );
        }


        function getAllUsers(){
            return MessageService.getAllUsers();
        }

        function editUser(id) {
            self.successMessage='';
            self.errorMessage='';
            MessageService.getUser(id).then(
                function (message) {
                    self.message = message;
                },
                function (errResponse) {
                    console.error('Erro ao deletar a mensagem ' + id + ', Erro :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.message={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);