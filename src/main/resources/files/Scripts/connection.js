/**
 * Esta funcion trae los datos de una tabla HTML para pasarlos a una matriz en JS y mostrarlos en la pagina
 */
function getData() {
    let vector_result = {};
    var word_share_traded = document.getElementById("word_share_traded").value;
    let time_series = "" ;
    document.getElementById("Time_Series_Daily").checked ? time_series = "TIME_SERIES_DAILY" : "";
    document.getElementById("Time_Series_Weekly").checked ? time_series = "TIME_SERIES_WEEKLY" : ""
    document.getElementById("Time_Series_Monthly").checked ? time_series = "TIME_SERIES_MONTHLY" : ""
    //https://fast-hollows-06971.herokuapp.com/
    //console.log('https://www.alphavantage.co/query?function='+time_series+'&symbol='+word_share_traded+'&apikey=demo')
    fetch('https://www.alphavantage.co/query?function='+time_series+'&symbol='+word_share_traded+'&apikey=demo')
        .then(results => results.json()).then(data => vector_result = data).then(data => {
        var jsonStr = JSON.stringify(data, null, 4);
        const table_elements = document.querySelector('#table_elements')
        delete data ['Meta Data'];
        table_elements.innerHTML = jsonStr;
    })
}



