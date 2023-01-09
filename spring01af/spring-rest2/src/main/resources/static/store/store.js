angular.module('market-front').controller('storeController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8189/market/';
    let currentPageIndex = 1;

    $scope.loadProducts = function (pageIndex = 1) {
        currentPageIndex = pageIndex;
        $http({
            url: contextPath + 'api/v1/products',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.productsPage = response.data;
            $scope.paginationArray = $scope.generatePagesIndexes(1, $scope.productsPage.totalPages);
        });
    };

    $scope.delete = function (product) {
        $http({
            url: contextPath + 'api/v1/products/' + product.id,
            method: 'DELETE',
        }).then(function successCallback(response) {
            console.log(response);
            $scope.loadProducts(currentPageIndex);
        }, function failureCallback(response) {
            alert(response.data.messages);
        });
    };

    $scope.addToCart = function (product) {
        $http.post(contextPath + 'api/v1/products/cart', product)
            .then(function successCallback(response) {
                alert('Product successfully added');
                $location.path('/cart');
            }, function failureCallback(response) {
                console.log(response);
                alert(response.data.messages);
            });
    };

    $scope.showInfo = function (product) {
        alert(product.title);
    };

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    };

    $scope.navToEditProductPage = function (productId) {
        $location.path('/edit_product/' + productId);
    };

    $scope.loadProducts();
});
