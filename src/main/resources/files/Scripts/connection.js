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
    fetch('https://www.alphavantage.co/query?function='+time_series+'&symbol='+word_share_traded+'&apikey=demo')
        .then(results => results.json()).then(data => vector_result = data).then(data => {
            const table_elements = document.querySelector('#table_elements')
            table_elements.innerHTML = ""; delete data ['Meta Data'];
            for (let i in data) {
                for (let j in data[i]) {
                    const row = document.createElement("tr");
                    const cell = document.createElement("th");
                    table_elements.appendChild(row);
                    cell.innerHTML = j;
                    row.appendChild(cell);
                    for (let k in data[i][j]) {
                        const cellText = document.createElement("td");
                        cellText.innerHTML = data[i][j][k];
                        row.appendChild(cellText);
                    }
                }
            }
        }).catch(error => console.log(error))
}