let stompClient = null;

$(document).ready(function() {
    connect();
});

function connect() {
    let socket = new SockJS('/hello');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function() {
        console.log('Web Socket is connected');
        stompClient.subscribe('/topic/messages', function(message) {
            $("#message").text(message.body);
        });
    });
}

$(function() {
    $("form").on('submit', function(e) {
        e.preventDefault();
    });
    $("#send").click(function() {
        stompClient.send("/msg/hello", {}, $("#name").val());
    });
});