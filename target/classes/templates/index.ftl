<!DOCTYPE html>

<html lang="en" ng-app="crudApp">
    <head>
        <title>${title}</title>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/app.css" rel="stylesheet"/>
        
    </head>
    <body>

        <div ui-view></div>
        <script src="js/lib/angular.min.js" ></script>
       	<script src="js/lib/angular-ui-router.min.js" ></script>
        <script src="js/lib/localforage.min.js" ></script>
        <script src="js/lib/ngStorage.min.js"></script>
        <script src="js/app/app.js"></script>
        <script src="js/app/MessageService.js"></script>
        <script src="js/app/MessageController.js"></script><!-- jquery -->
		<script src="http://code.jquery.com/jquery-1.11.0.min.js">
		<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js">
    </body>
</html>