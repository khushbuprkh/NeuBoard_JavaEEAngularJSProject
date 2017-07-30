var pageLogin = angular.module('pageLogin', []);

pageLogin.controller('LoginController', ['$scope', function($scope) {

  $scope.register = function() {
    $scope.message = 'Welcome ' + $scope.user.firstname;
  };

}]);