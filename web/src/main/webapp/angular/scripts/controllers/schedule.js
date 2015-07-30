'use strict';

angular.module('gym_management_systemApp')
    .controller('ScheduleCtrl',function($scope,ScheduleService){

        function getSchedules(){
            ScheduleService.getSchedules(function(schedules){

                $scope.schedules = schedules;
            });
        }

        getSchedules();

    });