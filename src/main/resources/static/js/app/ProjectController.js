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
        self.createProject = createProject;
        self.submit = submit;

        function submit() {
            console.log('Submitting');
            if (self.project.id === undefined || self.project.id === null) {
                console.log('Saving New Project', self.project);
                createProject(self.project);
            } else {
                updateProject(self.project, self.project.id);
                console.log('project updated with id ', self.project.id);
            }
        }

        function createProject(project) {
            ProjectService.createProject(project)
                .then(
                function (response) {
                    console.log('Project created successfully');
                    self.successMessage = 'Project created successfully';
                    self.errorMessage='';
                    self.done = true;
                    self.user={};
                    $scope.myForm.$setPristine();
                },
                function (errResponse) {
                    console.error('Error while creating Project');
                    self.errorMessage = 'Error while creating Project: ' + errResponse.data.errorMessage;
                    self.successMessage='';
                }
            );
        }

        function getAllProjects(){
            return ProjectService.getAllProjects();
        }


    }


    ]);