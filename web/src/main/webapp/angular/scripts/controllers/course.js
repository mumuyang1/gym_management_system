'use strict';

angular.module('gym_management_systemApp')
    .controller('CoursesCtrl', function ($scope, $http, CourseService) {


        function getCourses() {

            CourseService.getCourses(function (courses) {
                $scope.courses = courses;
            });
        }

        getCourses();

        $scope.deleteCourse = function (id) {

            CourseService.deleteCourse(id, function () {
                getCourses();
            });
        }

    });
