'use strict';

angular.module('gym_management_systemApp')
    .controller('CoursesCtrl', function ($scope, $http) {

        $http.get('/web/api/courses').success(function (courses) {

            console.log("课程。。。。。。。。"+courses[0].name);
            $scope.courses = courses;
        });

    });