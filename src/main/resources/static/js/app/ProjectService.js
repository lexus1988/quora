/**
 * Created by wlewicki on 4/26/2017.
 */
'use strict';

angular.module('crudApp').factory('ProjectService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                getAllProjects: getAllProjects,
                loadAllProjects : loadAllProjects
            };

            return factory;

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