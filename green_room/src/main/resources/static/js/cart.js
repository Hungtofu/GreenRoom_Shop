document.addEventListener('DOMContentLoaded', () => {
    const items = document.querySelectorAll('.item');
    const subtotalElement = document.getElementById('subtotal');

    function updateSubtotal() {
        let subtotal = 0;
        items.forEach(item => {
            const totalElement = item.querySelector('.total');
            const total = parseFloat(totalElement.textContent.replace('$', ''));
            subtotal += total;
        });
        subtotalElement.textContent = `$${subtotal.toFixed(2)}`;
    }

    items.forEach(item => {
        const increaseButton = item.querySelector('.increase');
        const decreaseButton = item.querySelector('.decrease');
        const numberDiv = item.querySelector('.number');
        const totalDiv = item.querySelector('.total');
        const pricePerItem = parseFloat(item.dataset.price);

        let number = parseInt(numberDiv.textContent);

        function updateTotal() {
            const total = (number * pricePerItem).toFixed(2);
            totalDiv.textContent = `$${total}`;
            updateSubtotal();
        }

        increaseButton.addEventListener('click', () => {
            number++;
            numberDiv.textContent = number;
            updateTotal();
        });

        decreaseButton.addEventListener('click', () => {
            if (number > 1) {
                number--;
                numberDiv.textContent = number;
                updateTotal();
            }
        });

        updateTotal(); // Initialize total
    });

    updateSubtotal(); // Initialize subtotal
});
