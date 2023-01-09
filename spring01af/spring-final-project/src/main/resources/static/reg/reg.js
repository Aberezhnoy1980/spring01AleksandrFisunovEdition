angular.module('market-front').controller('regController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8190/market/';

    $scope.tryToRegistration = function () {
        if ($scope.new_user == null) {
            alert('Form not filled');
            return;
        }
        $http.post(contextPath + 'api/v1/reg', $scope.new_user)
            .then(function successCallback(response) {
                $scope.new_user = null;
                alert('User successfully created');
                $location.path('/welcome');
            }, function failureCallback(response) {
                console.log(response);
                alert(response.data.messages);
            });
    };
});
