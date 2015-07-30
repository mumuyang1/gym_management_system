'use strict';

angular.module('gym_management_systemApp')
    .controller('CoursesCtrl', function ($scope, $http, CoursesService, UsersService) {

        function getCourses() {

            CoursesService.getCourses(function (courses) {
                $scope.courses = courses;
            });
        }

        function chargeViewLayout(hideAddForm, hideUpdateForm) {

            $scope.hideAddForm = hideAddForm;
            $scope.hideUpdateForm = hideUpdateForm;
        }

        getCourses();
        chargeViewLayout(true, true);

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

            chargeViewLayout(false, true);
        };

        $scope.cancelAddCourse = function () {
            $scope.hideAddForm = true;
        };

        $scope.addCourse = function (name, coachId) {

            CoursesService.addCourse(name, coachId, function (data) {

                if (data == "hasExisted") {
                    window.alert("该课程已经存在");
                } else {
                    getCourses();
                    $scope.newCourseName = null;
                    chargeViewLayout(true, true);
                }
            });
        };

        $scope.showUpdateCourseForm = function (id) {

            chargeViewLayout(true, false);

            CoursesService.getCourse(id, function (course) {

                $scope.newCourse = course;

                UsersService.getCoaches(function (coachUsers) {

                    $scope.coachUsers = coachUsers;

                    $scope.coachUser = _.find(coachUsers, function (coachUser) {
                        return coachUser.employee.id === course.employee.id;
                    });
                });
            });
        };

        $scope.updateCourse = function (course, coachId) {

            CoursesService.updateCourse(course, coachId, function () {

                chargeViewLayout(true,true);
                getCourses();
            });

            chargeViewLayout(true, false);
        };

        $scope.cancelUpdateCourse = function () {

            chargeViewLayout(true, true);
        };

    });
