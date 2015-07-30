'use strict'

angular.module('gym_management_systemApp')
    .service('ScheduleService',function($http){

        this.getSchedules = function(callback){

            $http.get('/web/api/schedules')
                .success(function(shcedules){
                    callback(shcedules)
                });
        }
    });