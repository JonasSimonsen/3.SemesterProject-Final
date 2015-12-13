'use strict';

angular.module('myApp.view1', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view1', {
                    templateUrl: 'view1/view1.html',
                    controller: 'View1Ctrl'
                });
            }])
        .controller('View1Ctrl', function ($http, $scope) {

            $scope.searchClicked = false;
         
            $scope.bookingFlightId = "";
            $scope.bookingNumOfSeats = "";
            
//            $scope.bookingUserName = "";
//            $scope.bookingUrl = "";
            
            $scope.bookingResName = "";
            $scope.bookingFlightId = "";
            $scope.bookingResPhone = "";
            $scope.bookingResEmail = "";
            $scope.bookingPassengers = [];

            $scope.travelInfo = function (flightId, numOfSeats) {
//                $scope.bookingURL = url;
                $scope.bookingFlightId = flightId;
                $scope.bookingNumOfSeats = numOfSeats;
                    console.log("bookingId: " + $scope.bookingFlightId)
                    console.log("seats: " + $scope.bookingNumOfSeats)
                    console.log($scope.bookingURL);
            };
            $scope.numOfTickets = function (num) {
                var arrayForNgRepeat = [];
                for (var i = 0, max = num; i < max; i++) {
                    arrayForNgRepeat.push(i);
                }
                return arrayForNgRepeat;
            };
            $scope.createPasObjects = function () {
                for (var i = 0; i < $scope.bookingNumOfSeats; i++) {
                    var passenger = {};
                    passenger.firstName = $scope.bookingPasFirstname;
                    passenger.lastName = $scope.bookingPasLastname
                    $scope.bookingPassengers.push(passenger);
                }
            };
            $scope.bookTickets = function () {
//                $scope.createPasObjects();
                var data = {
                    airlineURL: "http://angularairline-plaul.rhcloud.com/api/",
                    UserName: "user",
                    flightID: $scope.bookingFlightId,
                    numberOfSeats: $scope.bookingNumOfSeats,
                    ReserveeName: $scope.bookingResName,
                    ReservePhone: $scope.bookingResPhone,
                    ReserveeEmail: $scope.bookingResEmail,
                    Passengers: [{firstName: "asd", lastName: "asd"}]
                };
                var JsonData = JSON.stringify(data);
                var request = {
                    method: 'POST',
                    url: "api/reservation",
                    responseType: 'json',
                    data: JsonData
                };
                    console.log("Data fra booking: " + JsonData);
                $http(request)
                        .success(function (data) {
                                console.log("data: " + data);
                        })
                        .error(function (response) {
                                console.log("Fejl i POST - booking!");
                        });
            };
            $scope.search = function () {
                var baseUrl = 'api/flightinfo/';
                var year = $scope.myDate.getFullYear();
                var month = $scope.myDate.getMonth();
                var day = $scope.myDate.getDate();
                $scope.date = new Date(year, month, day, 1);
                var formatDate = $scope.date.toISOString();
                if ($scope.destination !== "null")
                {
                    var attributes = $scope.origin + "/" + $scope.destination + "/" + formatDate + "/" + $scope.numberOfSeats;
                } else
                {
                    var attributes = $scope.origin + "/" + formatDate + "/" + $scope.numberOfSeats;
                }
                var url = baseUrl + attributes;
                $http.get(url).then(function successCallBack(res) {
                    $scope.data = res.data;
                }, function errorCallBack(res) {
                    alert("LORT");
                });
            };
        });

        