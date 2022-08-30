/**
 * Esta funcion trae los datos mediante la API
 */
function getData() {
    let result = {};
    var word_share_traded = document.getElementById("word_share_traded").value;
    let time_series = "TIME_SERIES_DAILY" ;
    console.log("ICIIIIIIIIIIIIIIIIIIIII")
    //https://fast-hollows-06971.herokuapp.com/
    console.log("https://www.alphavantage.co/?queryfunction=TIME_SERIES_DAILY&symbol="+word_share_traded+"&apikey=demo")
    //https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol='+symbol+'&apikey=demo
    fetch('https://www.alphavantage.co/query?function='+time_series+'&symbol='+word_share_traded+'&apikey=demo')
        .then(res => res.json())
        .then(matriz_data => result = matriz_data)
        .then(matriz_data => {
            console.log("AUTREEEEEE")
            console.log(matriz_data)
            //
        })
        .catch(error => console.log(error))
}