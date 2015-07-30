'use strict';

angular.module('gym_management_systemApp')
    .service('SchedulesService',function($http){

        this.getSchedules = function(callback){

            $http.get('/web/api/schedules')
                .success(function(shcedules){
                    callback(shcedules)
                });
        };

        this.addSchedule = function(schedule,callback){

            $http.post('/web/api/schedules',schedule)
                .success(function(data){
                    callback(data);
            });
        };

    });