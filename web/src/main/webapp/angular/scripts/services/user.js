'use strict';

angular.module("gym_management_systemApp")
    .service('UsersService', function ($http) {

        this.getUsers = function (callback) {
            $http.get('/web/api/users').success(function (users) {

                callback(users);
            });
        };


        this.getCoaches = function (callback) {

            this.getUsers(function (users) {

                callback(_.filter(users, function(user) {

                    return user.employee.position === 'COACH';
                }));
            });
        };
    });

