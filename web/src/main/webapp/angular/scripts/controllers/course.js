'use strict';

angular.module('gym_management_systemApp')
    .controller('CoursesCtrl', function ($scope, $http, CoursesService, UsersService) {

        function getCourses() {

            CoursesService.getCourses(function (courses) {
                $scope.courses = courses;
            });
        }

        getCourses();

        $scope.hideAddForm = true;

        $scope.deleteCourse = function (id) {

            CoursesService.deleteCourse(id, function () {
                getCourses();
            });
        };

        $scope.showAddCourseForm = function () {

            UsersService.getCoaches(function (coachUsers) {
                $scope.coachUsers = coachUsers;
                $scope.coachUser = coachUsers[0];
            });

            $scope.hideAddForm = false;
        };

        $scope.cancelAddCourse = function () {
            $scope.hideAddForm = true;
        };

        $scope.addCourse = function (name, coachId) {

            CoursesService.addCourse(name, coachId, function () {

                getCourses();
                $scope.hideAddForm = true;

            });
        };

    });
