var plantId;
var productId;

document.addEventListener("DOMContentLoaded", function () {
    var searchParams = new URLSearchParams(window.location.search);
    plantId = searchParams.get("id");

    fetch(`http://localhost:8080/plant/getPlantDetail/${plantId}`, {
        method: "POST",
    })
        .then((response) => response.json())
        .then((data) => {
            if (data.success === true) {
                createPlantDetail(data.data);
            } else {
                console.log("Failed to fetch product");
            }
        })
        .catch((error) => {
            console.log("Error fetching product: ", error);
        });

    var addButton = document.getElementById('add_to_cart');
    addButton.addEventListener('click', function(){
        fetch(`http://localhost:8080/cart/insert`, {
            method: 'POST',
            
        });
    })

});

function createPlantDetail(plantDetail) {

    console.log(plantDetail);

    var mainImage = document.getElementById("main_image");
    var ortherImage = document.getElementById("orther_image");
    var detailName = document.getElementById("detail_name");
    var detailSize = document.getElementById("detail_size");
    var detailPotType = document.getElementById("detail_potType");
    var detailBotanicalName = document.getElementById("detail_botanicalName");
    var detailCommonName = document.getElementById("detail_commonName");
    var detailDescription = document.getElementById("detail_description");

    mainImage.scr = `../static/images/products/${plantDetail.images[0]}`;

    ortherImage.innerHTML = "";
    plantDetail.images.forEach(function (element) {
        const elementImage = document.createElement("img");
        elementImage.scr = `../static/images/products/${element}`;
        elementImage.alt = "product";

        ortherImage.appendChild(elementImage);
    });

    detailName.innerHTML = `${plantDetail.displayName}`;
    detailBotanicalName.innerHTML = `<span>Botanical Name:</span> ${plantDetail.botanicalName}`;
    detailCommonName.innerHTML = `<span>Common Name:</span> ${plantDetail.commonName}`;
    detailDescription.innerHTML = `<span>Description:</span> ${plantDetail.description}`;

    detailSize.innerHTML = ``;
    plantDetail.sizeVariant.forEach(size => {
        var sizeItem = document.createElement("span");
        sizeItem.innerHTML = `${size.sizeName}`;
        sizeItem.setAttribute('data-id', size.id);
        detailSize.appendChild(sizeItem);
    });

    detailPotType.innerHTML = ``;
    plantDetail.potTypeVariant.forEach(potType => {
        var potTypeItem = document.createElement("span");
        potTypeItem.innerHTML = `${potType.typeName}`;
        potTypeItem.setAttribute('data-id', potType.id);
        detailPotType.appendChild(potTypeItem);
    });



    const potTypeSpans = document.querySelectorAll('.select-pot-type span');
    const sizeSpans = document.querySelectorAll('.select-size span');

    let potTypeId = null;
    let sizeId = null;

    if(plantDetail.potTypeVariant.length === 0){
        const potTypeOption = document.getElementById('potType_option');
        potTypeOption.style.display = 'none';
    } else{
        potTypeSpans[0].classList.add('selected');
        potTypeId = potTypeSpans[0].getAttribute('data-id');
    }
    
    sizeSpans[0].classList.add('selected');
    sizeId = sizeSpans[0].getAttribute('data-id');

    updatePriceAndStock(sizeId, potTypeId);

    potTypeSpans.forEach(span => {
        span.addEventListener('click', () => {
            potTypeSpans.forEach(s => s.classList.remove('selected'));
            span.classList.add('selected');
            potTypeId = span.getAttribute('data-id');
            updatePriceAndStock(sizeId, potTypeId);
        });
    });

    sizeSpans.forEach(span => {
        span.addEventListener('click', () => {
            sizeSpans.forEach(s => s.classList.remove('selected')); 
            span.classList.add('selected');
            sizeId = span.getAttribute('data-id');
            updatePriceAndStock(sizeId, potTypeId);
        });
    });

}

function updatePriceAndStock(sizeId, potTypeId){

    let requestData = {
        "plantId": parseInt(plantId, 10),
        "sizeId": parseInt(sizeId, 10),
        "potTypeId": parseInt(potTypeId, 10)
    };

    fetch("http://localhost:8080/product/getVariant", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(requestData),
    })
        .then(response => response.json())
        .then((data) => {
            if (data.success === true) {
                
                console.log(data.data);

                const detailStock = document.getElementById("detail_stock");
                const detailPrice = document.getElementById("productPrice");
                var buyButton = document.getElementById("buy_now");
                var addButton = document.getElementById("add_to_cart");
                var soldOutButton = document.getElementById("sold_out");
                if(data.data.available === true){
                    detailPrice.innerHTML = `$${data.data.price}`;
                    detailStock.innerHTML = `GreenRoom: <span>${data.data.stock}</span>`;

                    buyButton.style.display = 'block';
                    addButton.style.display = 'block';      
                    soldOutButton.style.display = 'none';
                } else{
                    detailPrice.innerHTML = `SOLD OUT`;
                    detailStock.innerHTML = `GreenRoom: <span>0</span>`;
                    

                    buyButton.style.display = 'none';
                    addButton.style.display = 'none';
                    soldOutButton.style.display = 'block';
                }
                
            } else {
                console.log("Failed to fetch product");
            }
        })
        .catch((error) => {
            console.log("Error fetching product: ", error);
        });
}

