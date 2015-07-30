'use strict';

angular.module("gym_management_systemApp")
    .service('CoursesService', function ($http) {

        this.getCourses = function (callback) {
            $http.get('/web/api/courses').success(function (courses) {

                callback(courses);
            });
        };

        this.deleteCourse = function (id, callback) {

            $http.delete('/web/api/courses/' + id)
                .success(function () {
                    callback();
                });
        };

        this.addCourse = function (name, coachId,callback) {

            $http.post('/web/api/courses/',{'name':name,'employee':{id:coachId}})
                .success(function () {
                    callback();
                });
        };
    });
