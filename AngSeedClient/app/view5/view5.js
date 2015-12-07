/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module('myApp.view5', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view5', {
                    templateUrl: 'view5/view5.html',
                    controller: 'View5Ctrl'
                });
            }])
        .controller('View5Ctrl', function ($scope, $http) {

            $scope.saveUser = function () {
                $scope.message = "Registration successful!";
                $http.post('api/saveUser', $scope.user).
                        success(function () {
                        });
            };
        });


