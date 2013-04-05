// Login Form

$(function() {
    var button = $('#loginButton');
    var box = $('#loginBox');
    var form = $('#loginForm');
    button.removeAttr('href');
    button.mouseup(function(login) {
        box.toggle();
        button.toggleClass('active');
    });
    form.mouseup(function() { 
        return false;
    });
    $(this).mouseup(function(login) {
        if(!($(login.target).parent('#loginButton').length > 0)) {
            button.removeClass('active');
            box.hide();
        }
    });
});

$(document).ready(function(){
 	$('#login').click( function()
           {
           doLogin($('#email').val(),$('#password').val());
           }
        );
});     


var doLogin  = function(uName,pwd) {
	$.getJSON("./login.do?userName="+uName+"&password="+pwd,{}, 
	         	function (data) {
	         		if(data.status =='false'){
	         			$('#loginStatusMsg').html("Invalid ID");
	         		}
	         });
	         	 
}