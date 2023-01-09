angular
    .module('account', [])
    .controller('accountController', function ($scope, $http) {
        const contextPath = 'http://localhost:8080/front/';
        let currentPageIndex = 1;

        $scope.loadDeclarations = function (page = 1) {
            currentPageIndex = page;
            $http({
                url: contextPath + '/declarations',
                method: 'GET',
                params: {
                    page: page,
                    numberPart: $scope.filter ? $scope.filter.numberPart : null
                }
            }).then(function (response) {
                console.log(response);
                $scope.declarationPage = response.data;
                $scope.generatePagesList($scope.declarationPage.totalPages);
            });
        }

        $scope.loadStatistic = function () {
            $http.get('http://localhost:8080/front/statistic')
                .then(function (response) {
                    $scope.statistic = response.data;
                });
        }

        $scope.generatePagesList = function (totalPages) {
            out = [];
            for (let i = 0; i < totalPages; i++) {
                out.push(i + 1);
            }
            $scope.pagesList = out;
        }

        $scope.download = function () {
            $http({
                method: 'GET',
                url: 'http://localhost:8080/front/export',
                responseType: 'arraybuffer'
            }).then(function (response) {
                console.log(response.data);
                var blob = new Blob([response.data], {type: 'application'});
                saveAs(blob, 'statistic.xlsx');
            })

        }

        function saveAs(blob, fileName) {
            var url = window.URL.createObjectURL(blob);
            var doc = document.createElement("a");
            doc.href = url;
            doc.download = fileName;
            doc.click();
            window.URL.revokeObjectURL(url);
        }


        $scope.refresh = function () {
            $scope.loadDeclarations()
            $scope.loadStatistic()
        }

        $scope.loadDeclarations()
        $scope.loadStatistic()

    });
