angular.module('frontapp', []).controller('indexController', function ($scope, $http) {
    $http.get('http://localhost:880/app/students/json/2')
        .then(function (response) {
            $scope.student = response.data;
        });

    $scope.counter = 0;

    $scope.btnMinusClick = function () {
        $scope.counter -= 1;
    }

    $scope.btnPlusClick = function () {
        $scope.counter += 1;
    }
});