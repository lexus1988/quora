/**
 * Created by wlewicki on 4/26/2017.
 */
'use strict';

angular.module('crudApp').factory('ProjectService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                getAllProjects: getAllProjects,
                loadAllProjects : loadAllProjects,
                createProject : createProject
            };

            return factory;

            function createProject(project) {
                console.log('Creating Project');
                var deferred = $q.defer();
                $http.post(urls.PROJECT_SERVICE_API, project)
                    .then(
                        function (response) {
                            loadAllProjects();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while creating Project : '+errResponse.data.errorMessage);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function loadAllProjects() {
                console.log('Fetching all projects');
                var deferred = $q.defer();
                $http.get(urls.PROJECT_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all projects');
                            $localStorage.projects = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading projects');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllProjects(){
                return $localStorage.projects;
            }

        }
    ]);