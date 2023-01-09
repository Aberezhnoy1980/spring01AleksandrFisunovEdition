angular.module('users', []).controller('userController', function ($scope, $http) {
        const contextPath = 'http://localhost:8189/market/';
        let currentPageIndex = 1;

        $scope.loadUsers = function (index = 1) {
            currentPageIndex = index;
            $http({
                url: contextPath + 'api/v1/users',
                method: 'GET',
                params: {
                    minAge: this.minAge,
                    maxAge: this.maxAge,
                    male: this.male,
                    u: index
                }
            }).then(function (response) {
                console.log(response);
                $scope.usersPage = response.data;
                $scope.paginationArray = $scope.generatePagesIndexes(1, $scope.usersPage.totalPages);
            });
        };

        $scope.createNewUser = function () {
            $http.post(contextPath + 'api/v1/users', $scope.new_user)
                .then(function successCallback(response) {
                    $scope.loadUsers(currentPageIndex);
                    $scope.new_user = null;
                }, function failureCallback(response) {
                    alert(response.data.message);
                });
        };

        // wrong GET delete
        $scope.delete = function (user) {
            $http({
                url: contextPath + 'api/v1/users/' + user.id,
                method: 'DELETE',
            }).then(function successCallback(response) {
                console.log(response);
                $scope.loadUsers(currentPageIndex);
            }, function failureCallback(response) {
                alert(response.data.message);
            });
        };

        $scope.showInfo = function (user) {
            alert(user.name);
        };

        $scope.generatePagesIndexes = function (startPage, endPage) {
            let arr = [];
            for (let i = startPage; i < endPage + 1; i++) {
                arr.push(i);
            }
            return arr;
        }

        $scope.loadUsers();
    }
);
