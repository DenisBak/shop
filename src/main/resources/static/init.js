function getPurchases() {
    const ul = document.createElement('ul');

    fetch('http://localhost:8181/api/purchase/all', {
        method: 'GET'
    }).then(
        response => response.json()).then(json => {
            for (const purchase of json) {
                const li = document.createElement('li');
                li.innerHTML = purchase.name + " - " + purchase.basket + ", for " + purchase.amount + "$, count of goods: "
                    + purchase.count + ", date - " + purchase.date
                ul.appendChild(li)
            }
        }
    );

    document.getElementById('allPurchases').appendChild(ul)
}