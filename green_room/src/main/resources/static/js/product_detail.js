document.querySelectorAll('.other-image img').forEach(img => {
    img.addEventListener('click', function() {
        document.querySelector('.main-image img').src = this.src;
    });
});

document.addEventListener('DOMContentLoaded', () => {
    const spans = document.querySelectorAll('.select-size span');
    spans[0].classList.add('selected');
    spans.forEach(span => {
        span.addEventListener('click', () => {
            // Remove the 'selected' class from all spans
            spans.forEach(s => s.classList.remove('selected'));
            // Add the 'selected' class to the clicked span
            span.classList.add('selected');
        });
    });
});

document.addEventListener('DOMContentLoaded', () => {
    const spans = document.querySelectorAll('.select-pot-type span');
    spans[0].classList.add('selected');
    spans.forEach(span => {
        span.addEventListener('click', () => {
            // Remove the 'selected' class from all spans
            spans.forEach(s => s.classList.remove('selected'));
            // Add the 'selected' class to the clicked span
            span.classList.add('selected');
        });
    });
});