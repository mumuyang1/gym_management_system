'use strict';

angular.module('gym_management_systemApp')
    .controller('SchedulesCtrl',function($scope,SchedulesService,CoursesService){

        function getSchedules(){
            SchedulesService.getSchedules(function(schedules){

                $scope.schedules = schedules;
            });
        }

        getSchedules();

        CoursesService.getCourses(function(courses){

            $scope.courses = courses;
        });

        $scope.addSchedule = function(schedule){

            console.log(schedule.date);

            SchedulesService.addSchedule(schedule,function(result){

                if(result == "dateIsNotAvailable"){

                    window.alert("该教练时间冲突，请重新安排时间😊");
                }else{

                    getSchedules();
                }
            });
        };
    });