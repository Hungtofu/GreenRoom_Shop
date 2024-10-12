const numberDiv = document.getElementById('number');
const increaseButton = document.getElementById('increase');
const decreaseButton = document.getElementById('decrease');

let number = 1;

increaseButton.addEventListener('click', () => {
    number++;
    numberDiv.textContent = number;
});

decreaseButton.addEventListener('click', () => {
    if (number > 1) {
        number--;
        numberDiv.textContent = number;
    }
});
