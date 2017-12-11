<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Recados </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.message.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="autor">Autor</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.message.autor" id="autor" class="username form-control input-sm" placeholder="Autor" required ng-maxlength="50"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="contato">Contato</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.message.contato" id="contato" class="form-control input-sm" placeholder="Email" required ng-maxlength="75"/>
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="titulo">Título</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.message.titulo" id="titulo" class="form-control input-sm" placeholder="Titulo" required ng-maxlength="150"/>
	                        </div>
	                    </div>
	                </div>
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="mensagem">Mensagem</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.message.mensagem" id="mensagem" class="form-control input-sm" placeholder="Mensagem" required ng-maxlength="255"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.message.id ? 'Criar' : 'Atualizar'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Limpar</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Lista de Recados </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover" id="data">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>Autor</th>
		                <th>Contato</th>
		                <th>Titulo</th>
		                <th>Mensagem</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllUsers()">
		                <td>{{u.id}}</td>
		                <td>{{u.autor}}</td>
		                <td>{{u.titulo}}</td>
		                <td>{{u.contato}}</td>
		                <td>{{u.mensagem}}</td>
		                <td><button type="button" ng-click="ctrl.editUser(u.id)" class="btn btn-success custom-width">Editar</button></td>
		                <td><button type="button" ng-click="ctrl.removeUser(u.id)" class="btn btn-danger custom-width">Deletar</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>
