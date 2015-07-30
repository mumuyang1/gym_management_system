'use strict';

angular.module('gym_management_systemApp')
    .controller('UsersCtrl', function ($scope, $http) {

        $http.get('/web/api/users').success(function (users) {
            $scope.users = users;
        });

    });