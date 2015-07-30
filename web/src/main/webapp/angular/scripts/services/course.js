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

        this.addCourse = function (name, coachId, callback) {

            $http.post('/web/api/courses/', {'name': name, 'employee': {id: coachId}})
                .success(function (data) {
                    callback(data);
                });
        };

        this.updateCourse = function (id, name, coachId) {

            $http.put('/web/api/courses/' + id, {'id': id, 'name': name, 'employee': {id: coachId}})
                .success(function (data) {
                    callback(data);
                });
        };


        this.getCourse = function (id,callback) {
            $http.get('/web/api/courses/'+id).success(function (course) {

                callback(course);
            });
        }
    });

