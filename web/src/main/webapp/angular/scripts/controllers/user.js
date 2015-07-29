'use strict';

angular.module('gym_management_systemApp')
    .controller('UsersCtrl', function ($scope,$http) {

        //$scope.$emit('to-parent-productManageActive');
        //
        //
        //function refresh() {
        //    categoryManageService.getCategories(function (data) {
        //        $scope.categories = data;
        //    });
        //}
        //
        //refresh();
        //
        //function showCharge(add, change, clickDelete) {
        //    $scope.clickAddCategory = add;
        //    $scope.clickChangeCategory = change;
        //    $scope.clickDelete = clickDelete;
        //}

        $http.get('/web/api/users').success(function (users) {
            console.log(users[0].employee+"----------");
            $scope.users = users;
        });


    });