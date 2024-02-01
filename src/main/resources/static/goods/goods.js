function getLastMonthMostPopularGood() {
    const h3 = document.createElement('h3');

    fetch('http://localhost:8181/api/good/monthly/best', {
        method: 'GET'
    }).then(
        response => response.json()).then(good => {
            h3.innerHTML = good.name + " - " + good.price + "$"
        }
    );

    document.getElementById('popularMonthGood').appendChild(h3)
}

function getMostSellGoodAmongEighteen() {
    const h3 = document.createElement('h3');

    fetch('http://localhost:8181/api/good/eighteen/best', {
        method: 'GET'
    }).then(
        response => response.json()).then(good => {
            h3.innerHTML = good.name + " - " + good.price + "$"
        }
    );

    document.getElementById('eighteenMostSell').appendChild(h3)
}