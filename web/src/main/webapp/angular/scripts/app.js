'use strict';

angular.module('gym_management_systemApp', [
        'ngRoute'
    ])

    .config(function ($routeProvider) {
        $routeProvider
            .when('/users', {
                templateUrl: './views/employeesManagement.html',
                controller: 'UsersCtrl'
            })

            .when('/courses', {
                templateUrl: './views/courseManagement.html',
                controller: 'CoursesCtrl'
            })

            .when('/schedules', {
                templateUrl: './views/scheduleManagement.html',
                controller: 'ScheduleCtrl'
            })
            //.when('/pay', {
            //    templateUrl: 'views/pay.html',
            //    controller: 'PayCtrl'
            //})
            //.when('/productManage', {
            //    templateUrl: 'views/productManage.html',
            //    controller: 'ProductManageCtrl'
            //})
            //.when('/categoryManage', {
            //    templateUrl: 'views/categoryManage.html',
            //    controller: 'CategoryManageCtrl'
            //})
            .otherwise({
                redirectTo: '/'
            });
    });