angular.module('market-front').controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/market/';

    $scope.loadProducts = function () {
        $http({
            url: contextPath + 'api/v1/products/cart',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.productsPage = response.data;
        });
    };

    $scope.delete = function (product) {
        $http({
            url: contextPath + 'api/v1/products/cart' + product.id,
            method: 'DELETE',
        }).then(function successCallback(response) {
            console.log(response);
            $scope.loadProducts(currentPageIndex);
        }, function failureCallback(response) {
            alert(response.data.messages);
        });
    };

    $scope.loadProducts();
});
