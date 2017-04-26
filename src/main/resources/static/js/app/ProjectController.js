/**
 * Created by wlewicki on 4/26/2017.
 */
'use strict';

angular.module('crudApp').controller('ProjectController',
    ['ProjectService', '$scope',  function( ProjectService, $scope) {

        var self = this;
        self.project = {};
        self.projects=[];


        self.getAllProjects = getAllProjects;


        function getAllProjects(){
            return ProjectService.getAllProjects();
        }


    }


    ]);