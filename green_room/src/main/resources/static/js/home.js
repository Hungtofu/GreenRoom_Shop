let current_index = 0;

function showSlide(index){
    const slides = document.querySelector('.slides');
    const totalSlides = document.querySelectorAll('.slide').length;
    if(index >= totalSlides){
        current_index = 0;
    } else if (index < 0){
        current_index = totalSlides - 1;
    } else {
        current_index = index
    }

    slides.style.transform = 'translateX(' + (-current_index * 100) + '%)';
}

function nextSlide(){
    showSlide(current_index+1);
}

function prevSlide(){
    showSlide(current_index-1);
}

// setInterval(()=>{
//     nextSlide();
// }, 5000);