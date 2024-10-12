document.addEventListener("DOMContentLoaded", function(){

    fetch('http://localhost:8080/plantType/getAll', {
        method: 'GET',
    })
    .then(response => response.json())
    .then(data => {
        if(data.success === true){
            createCategories(data.data);
        }else{
            console.log('Failed to fetch plant type');
        }
    })
    .catch(error => {
        console.log('Error fetching plant type: ', error);
    })


    var accountImage = document.getElementById('account_image');
    var myCart = document.getElementById('mycart_button');
    var login = document.getElementById('login_button');
    var setting = document.getElementById('setting_button');
    var logout = document.getElementById('logout_button');

    if(localStorage.getItem('token') != null){
        accountImage.style.display = 'none';
        myCart.style.display = 'none';
        setting.style.display = 'none';
        logout.style.display = 'none';
        login.style.display = 'block';
    } else {
        accountImage.style.display = 'block';
        myCart.style.display = 'block';
        setting.style.display = 'block';
        logout.style.display = 'block';
        login.style.display = 'none';
    }

});



function createCategories(plantTypes){

    const dropdownContent = document.getElementById('dropdown_content_categories');  
    dropdownContent.innerHTML = '';
    
    const allPlants = document.createElement('a');
    allPlants.href = `../templates/products.html?category=-2`;
    allPlants.textContent = 'All plants';
    dropdownContent.appendChild(allPlants); 

    const newArrials = document.createElement('a');
    newArrials.href = `../templates/products.html?category=-1`;
    newArrials.textContent = 'New arrivals';
    dropdownContent.appendChild(newArrials); 

    const rarePlants = document.createElement('a');
    rarePlants.href = `../templates/products.html?category=0`;
    rarePlants.textContent = 'Rare plants';
    dropdownContent.appendChild(rarePlants); 

    plantTypes.forEach(plantType => {
        const category = document.createElement('a');
        const typeNameFormatted = plantType.typeName.replace(/ /g, '-').toLowerCase();
        category.href = `../templates/products.html?category=${plantType.id}`; 
        category.textContent = plantType.typeName;
        dropdownContent.appendChild(category);
    });

}
