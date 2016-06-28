$(document).ready(function () {

    var user, creator, date, device, location, temperature, newId;

    function showError(error) {
        var message = "An error occurred";
        if (error.message) {
            message = error.message;
        } else if (error.errors) {
            var errors = error.errors;
            message = "";
            Object.keys(errors).forEach(function (k) {
                message += k + ": " + errors[k] + "\n";
            });
        }

        alert(message);
    }

    getTheDate();
    loadReadings();
    detectUser();

    $('#reading-form').submit(function () {
        //    function handleForm() {
        //Get the data from the form.
        creator = $('#userName').val();
        date = $('#date').val();
        device = $('#device').val();
        location = $('#location').val();
        temperature = $('#temperature').val();

        // Clear the form elements.
        $('#userName').val(user.username);
        $('#date').val(date);
        $('#device').val('');
        $('#location').val('');
        $('#temperature').val('');

        addReading({
            user: creator
            , date: date
            , device: device
            , location: location
            , temperature: temperature
        });

        showReading({
            user: creator
            , date: date
            , device: device
            , location: location
            , temperature: temperature
        }, false);
        console.log("ayoeoo");
        return false;
    });

    function addReading(reading) {
        dpd.readings.post({
            "date": reading.date
            , "device": reading.device
            , "location": JSON.stringify(reading.location)
            , "temperature": reading.temperature
            , "user": reading.user
        }, function (result, err) {
            if (err) {
                return console.log(err);
            } else {
                newId = result.id;
            }
            console.log(result, result.id);
        });
    }

    function showReading(reading, bool) {
        // If printing database values, show retrieved ID.
        readingId = bool ? reading.id : newId;

        $('<div class="reading">')
            .append('<div class="metadata"><span class="user">Recorded by: ' + reading.user + '</span><span class="right">Date: ' + reading.date + '</span><span> on device \'' + reading.device + '\'</span></div>')
            .append('<p>Reading <span class="id">' + readingId + '</span> was taken at coordinate <span class="location">' + reading.location + '</span> with ambient temperature ' + '<span class="temperature">' + reading.temperature + ' ºC</span></p>')
            .appendTo('#readings');
    }

    function detectUser() {
        dpd.users.me(function (result) {
            if (result) {
                user = result;
                $('#userName').val(user.username);
            } else {
                $('#userName').val("Anonymous");
            }
        });
    }

    function getTheDate() {
        date = new Date().format("dd-mm-yyyy");
        $('#date').val(date);
    }

    function loadReadings() {
        dpd.readings.get(function (readings, error) { //Use dpd.js to access the API
            $('#readings').empty(); //Empty the list
            readings.forEach(function (reading) { //Loop through the result
                showReading(reading, true); //Add it to the DOM.
            });
        });
    }

    // To do: derive device by sniffing user agent.

});