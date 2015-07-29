'use strict';

angular.module("gym_management_systemApp")
    .service('CourseService', function ($http) {

        this.getCourses = function (callback) {
            $http.get('/web/api/courses').success(function (courses) {

                console.log("进入service方法");
                callback(courses);
            });
        };
    });
