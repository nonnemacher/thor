class Participant {
    constructor(email) {
        this.email = email;
    }
}
class ParticipantEvent {
    constructor(participant) {
        this.participant = participant;
    }    
}


var app = angular.module('app', ['ngResource']).controller('event', function ($scope, $resource) {
    // initiate scope attributes
    $scope.event = {};
    
    var $Event = $resource('/event/:id');
    var $Participant = $resource('/participant/:id', {id: '@id'}, {
        saveAll: {
            method: 'POST', isArray:true
        }
    });

    $scope.query = function () {
        $scope.events = $Event.query();
    };

    $scope.save = function () {
        $Event.save($scope.event, function () {
            $scope.query();
            $scope.event = {};
        });
    };

    $scope.addParticipants = function () {
        var participants = [];
        debugger;
        angular.forEach($scope.participants.split(','), function (email) {
            participants.push(new Participant(email));
        });

        $Participant.saveAll(participants, function (data) {
            var participantEvents = $scope.event.participantEvents || [];
            angular.forEach(data, function (participant) {
                participantEvents.push(new ParticipantEvent(participant));
            });
            $scope.event.participantEvents = participantEvents;
        });
    };

});