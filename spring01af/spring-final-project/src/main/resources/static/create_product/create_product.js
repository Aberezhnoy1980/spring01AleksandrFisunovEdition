
angular.module('market-front').controller('createProductController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8190/market/';

    $scope.createProduct = function () {
        if ($scope.new_product == null) {
            alert('Form not filled');
            return;
        }
        $http.post(contextPath + 'api/v1/products', $scope.new_product)
            .then(function successCallback(response) {
                $scope.new_product = null;
                alert('Product successfully created');
                $location.path('/store');
            }, function failureCallback(response) {
                console.log(response);
                alert(response.data.messages);
            });
    };
});
