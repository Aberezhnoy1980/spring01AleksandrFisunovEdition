angular.module('testapp', []).controller('index1Controller', function ($scope, $http) {

    $http.get('http://localhost:8080/app/students/json/3')
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