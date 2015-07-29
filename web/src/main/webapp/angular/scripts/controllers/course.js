'use strict';

angular.module('gym_management_systemApp')
    .controller('CoursesCtrl', function ($scope, $http) {

        $http.get('/web/api/courses').success(function (courses) {

            console.log("课程。。。。。。。。"+courses[0].name);
            $scope.courses = courses;
        });

        $.deleteUser = function(id){

            console.log("点击delete" + id);
            $http.delete('/web/api/courses/{id}')
                .success(function(){
                    console.log("删除成功");
            });

        }

    });