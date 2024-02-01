function getBestBuyer() {
    const h3 = document.createElement('h3');

    fetch('http://localhost:8181/api/client/halfyearly/best', {
        method: 'GET'
    }).then(
        response => response.json()).then(client => {
            h3.innerHTML = client.lastname + " " + client.name
        }
    );

    document.getElementById('bestBuyer').appendChild(h3)
}