const priceSlider = document.getElementById("price-slider");
const priceMin = document.getElementById("price-min");
const priceMax = document.getElementById("price-max");

noUiSlider.create(priceSlider, {
    start: [100, 900],
    connect: true,
    range: {
        'min': 0,
        'max': 1000
    },
    format: {
        to: function (value) {
            return Math.round(value);
        },
        from: function (value) {
            return Number(value);
        }
    }
});

priceSlider.noUiSlider.on("update", function (values, handle) {
    if (handle === 0) {
        priceMin.innerHTML = "$" + values[0];
    } else {
        priceMax.innerHTML = "$" + values[1];
    }
});

document.addEventListener('DOMContentLoaded', function() {
    const checkboxes = document.querySelectorAll('.plant-size');
    
    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function() {
            if (this.checked) {
                checkboxes.forEach(cb => {
                    if (cb !== this) {
                        cb.checked = false;
                    }
                });
            }
        });
    });
});