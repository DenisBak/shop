let form;
let map = new Map();

function initFormFields() {
    form = document.getElementById("createPurchase");
    let basket = document.getElementById('basket');
    let clientName = document.getElementById('clientName');

    fetch('http://localhost:8181/api/good/all', {
        method: 'GET'
    }).then(
        response => response.json()).then(goods => {
            for (good of goods) {
                map.set(good.name, good.price)
                basket.innerHTML += "<option value=" + good.name + ">" + good.name + " - " + good.price + "$</option>"
            }
        }
    );

    fetch('http://localhost:8181/api/client/all', {
        method: 'GET'
    }).then(
        response => response.json()).then(clients => {
            for (client of clients) {
                clientName.innerHTML += "<option value=" + client.name + ">" + client.lastname + " " + client.name + "</option>"
            }
        }
    );
}

function submitPurchaseCreate() {
    const formData = new FormData(form);
    const body = new Map;

    let count = 0;
    let amount = 0.0;
    let cart = [];
    let date = new Date()
    formData.getAll("basket").forEach(good => {
        cart[count] = good;
        amount += map.get(good)
        console.log(amount)
        count++;
    })

    body.set("name", formData.get("name"))
    body.set("clientName", formData.get("clientName"))
    body.set("basket", cart)
    body.set("count", count)
    body.set("amount", amount)
    body.set("date", date.toISOString().split("T")[0])

    try {
        fetch("http://localhost:8181/api/purchase/create", {
            method: "POST",
            headers: new Headers({'content-type': 'application/json'}),
            body: JSON.stringify(Object.fromEntries(body)),
        }).then(response => response.text()).then(txt => document.getElementById("response").innerHTML = txt);
    } catch (e) {
        console.error(e);
    }
}

function addEventListener() {
    form.addEventListener("submit", (event) => {
        event.preventDefault();
        submitPurchaseCreate();
    });
}

function getLastWeekPurchases() {
    const ul = document.createElement('ul');

    fetch('http://localhost:8181/api/purchase/weekly', {
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

    document.getElementById('lastWeekPurchases').appendChild(ul)
}