document.addEventListener("DOMContentLoaded", function(){

    var searchParams = new URLSearchParams(window.location.search);
    categoryId = searchParams.get("category");

    console.log(categoryId);

    if(categoryId == null){
        fetch('http://localhost:8080/plant/getPlantList', {
            method: 'GET'
        })
        .then(response => response.json())
        .then(data => {
            if(data.success === true){
                createPlantList(data.data);
            }else{
                console.log('Failed to fetch product');
            }
        })
        .catch(error => {
            console.log('Error fetching product: ', error);
        })
    } else {

        var api = `http://localhost:8080/plant/category/${categoryId}`;

        fetch(api, {
            method: 'POST'
        })
        .then(response => response.json())
        .then(data => {
            if(data.success === true){
                createPlantList(data.data);
            }else{
                console.log('Failed to fetch product');
            }
        })
        .catch(error => {
            console.log('Error fetching product: ', error);
        })

    }
    

});

function createPlantList(plantList){
    
    const productGrid = document.getElementById('products_grid');
    productGrid.innerHTML = ``;
    plantList.forEach(plant => {
        
        const productItem = document.createElement('div');
        productItem.classList.add('product-item');
        productItem.innerHTML = `
        <a href="../templates/product_detail.html?id=${plant.id}">
        <img src="../static/images/products/${plant.displayImage}" alt="" />
        <p class="price">$${plant.priceFrom}</p>
        <p class="name">${plant.displayName}</p>
        </a>`;
        
        productGrid.appendChild(productItem);

    });
}