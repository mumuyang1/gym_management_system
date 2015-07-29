'use strict';

angular.module('gym_management_systemApp')
    .controller('CoursesCtrl', function ($scope, $http, CourseService) {


        CourseService.getCourses(function (courses) {
            $scope.courses = courses;
        });

        //$scope.deleteCourse = function(id){
        //
        //    console.log("点击delete" + id);
        //    $http.delete('/web/api/courses/'+id)
        //        .success(function(){
        //
        //            $http.get('/web/api/courses').success(function (courses) {
        //
        //                $scope.courses = courses;
        //            });
        //
        //            console.log("删除成功");
        //    });
        //}

    });
