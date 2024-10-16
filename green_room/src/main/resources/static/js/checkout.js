var localpicker = new LocalPicker({
  province: "ls_province",
  district: "ls_district",
  ward: "ls_ward",
});

var options = {
    /*
      HTML Selector. You can pass value of name, id or class. 
      It will automatically detect exist elements for you.
      Example: 'myIdOrClass','#myId', '.myClass', 'myName'
      */
      province: 'ls_province',	
      district: 'ls_district',	
      ward: 'ls_ward',			
                
      /*
      Define value for option tag. Valid option: id|name           
      */
      getValueBy: 'id',           
      
      //Placeholder text
      provinceText: 'Chọn tỉnh / thành phố',
      districtText: 'Chọn quận / huyện',
      districtNoText: 'Địa phương này không có quận / huyện',
      wardText: 'Chọn phường / xã',
      wardNoText: 'Địa phương này không có phường / xã',
      
      // Default value if no location exist
      emptyValue: " ",
      
      // Hide option where no local exist
      hideEmptyValueOption: true,
      
      // Hide place-holder option (first option)
      hidePlaceHolderOption: true,
      
      /*
      Include local level on option text as prefix
      Example: true = Quận Bình Thạnh | false = Bình Thạnh
      */
      provincePrefix: false,
      districtPrefix: true,
      wardPrefix: true,
      
      /*
      Include local level in option tag's attribute
      */
      levelAsAttribute: true,
      levelAttributeName: "data-level",
};

document.addEventListener('DOMContentLoaded', function () {
  const creditCardRadio = document.getElementById('credit-card');
  const momoRadio = document.getElementById('momo');
  const creditCardInfo = document.querySelector('.credit-card-info');
  const momoInfo = document.querySelector('.momo-info');
  const momoGroup = document.getElementById('momo-group')

  // Function to update the visibility of the payment method info
  function updatePaymentInfo() {
      if (creditCardRadio.checked) {
          creditCardInfo.style.display = 'block';
          momoInfo.style.display = 'none';
          momoGroup.style.borderRadius = '0 0 5px 5px';
      } else if (momoRadio.checked) {
          creditCardInfo.style.display = 'none';
          momoInfo.style.display = 'block';

          momoGroup.style.borderRadius = '0';
      }
  }

  // Add event listeners to the radio buttons
  creditCardRadio.addEventListener('change', updatePaymentInfo);
  momoRadio.addEventListener('change', updatePaymentInfo);

  // Initialize the visibility on page load
  updatePaymentInfo();
});
