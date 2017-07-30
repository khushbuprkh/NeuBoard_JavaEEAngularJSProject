var navigate = angular.module('navigate', ['ngRoute']);

navigate.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
  when('/addCourses', {
    templateUrl: 'addCourses.jsp',
    /*controller: 'Controller'*/
  }).
  when('/viewCourses', {
    templateUrl: 'viewCourses.jsp',
    /*controller: 'Controller'*/
  }).
    when('/addUser', {
    templateUrl: 'addUser.jsp',
    /*controller: 'Controller'*/
  }).
  otherwise({
    redirectTo: '/list'
  });

}]);
