angular.module('market-front', []).controller('indexController', function ($scope, $http) {
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

        $scope.createNewProduct = function () {
            $http.post(contextPath + 'api/v1/products', $scope.new_product)
                .then(function successCallback(response) {
                    $scope.loadProducts(currentPageIndex);
                    $scope.new_product = null;
                }, function failureCallback(response) {
                    alert(response.data.message);
                });
        };

        $scope.updateProduct = function () {
            $http.post(contextPath + 'api/v1/products', $scope.updated_product)
                .then(function successCallback(response) {
                    console.log($scope.updated_product);
                    $scope.loadProducts(currentPageIndex);
                    $scope.updated_product = null;
                }, function failureCallback(response) {
                    alert(response.data.message);
                });
        };

        // wrong GET delete
        $scope.delete = function (product) {
            $http({
                url: contextPath + 'api/v1/products/delete/' + product.id,
                method: 'GET',
            }).then(function successCallback(response) {
                console.log(response);
                $scope.loadProducts(currentPageIndex);
            }, function failureCallback(response) {
                alert(response.data.message);
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
        }

        $scope.loadProducts();
    }
);
