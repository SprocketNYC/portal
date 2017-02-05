var app = angular.module("demoApplication", []);
app.controller("demoController", function($scope, $http) {
	$scope.tstatus = "[READY]";
	$scope.results = "";
	$scope.working = false;
	$scope.timestamp = function() {
		if ((performance) && (performance.now)) {
			return performance.now();
		}
		;
		if (!Date.now) {
			return new Date().getTime();
		}
		return Date.now();
	};
	$scope.statusREADY = function(path, response) {
		var dt = ($scope.timestamp() - $scope.tstarts);
		$scope.tstatus = "[READY] " + path + " " + dt.toFixed(2) + ".ms";
		$scope.results = JSON.stringify(response.data, null, 2);
		$scope.working = false;
	};
	$scope.statusERROR = function(path, response) {
		var dt = ($scope.timestamp() - $scope.tstarts);
		$scope.tstatus = "[ERROR] " + path + " " + dt.toFixed(2) + ".ms";
		if (response.status < 0) {
			$scope.results = " NO NETWORK";
		} else {
			$scope.results = " CODE[" + response.status + "]: " + response.statusText;
		}
		$scope.working = false;
	};
	$scope.doServiceGET = function(path) {
		$scope.working = true;
		$scope.tstatus = "[WAITING]";
		$scope.results = "";
		$scope.tstarts = $scope.timestamp();
		$http.get("services" + path).then(function(response) {
			$scope.statusREADY(path, response);
		}, function(response) {
			$scope.statusERROR(path, response);
		});
	};
	$scope.doServicePOST = function(path, data) {
		$scope.working = true;
		$scope.tstatus = "[WAITING]";
		$scope.results = "";
		$scope.tstarts = $scope.timestamp();
		$http.post("services" + path, data).then(function(response) {
			$scope.statusREADY(path, response);
		}, function(response) {
			$scope.statusERROR(path, response);
		});
	};
	$scope.doServiceGET('/demo/users/finduser');
});