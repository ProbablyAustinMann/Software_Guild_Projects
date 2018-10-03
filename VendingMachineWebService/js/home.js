//home.js
//var dict = new Object();
var money = 0;
var quarters = 0;
var dimes = 0;
var nickels = 0;
var initialItemQuantity;
var newQuantity;
var itemPrice;
var idChoice;
var itemChoice;
var moneyFloat;
var priceFloat;
var newMoneyFloat;

$(document).ready(function(){
  loadInventory();


  $('#addDollar').click(function() {
     money = money + (100);
    $( "#moneyInputBox" ).val(money / 100);
  });

  $('#addQuarter').click(function() {
     money = money + (25);
    $( "#moneyInputBox" ).val(money / 100);
  });

  $('#addDime').click(function() {
     money = money + (10);
    $( "#moneyInputBox" ).val(money / 100);
  });

  $('#addNickel').click(function() {
     money = money + (5);
    $( "#moneyInputBox" ).val(money / 100);
  });

  $('#returnChangeButton').click(function() {
    returnChange();
    $('#changeBox').append($('#changeBox').val(quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels."));
    clearMoney();
  });

  $('#makePurchaseButton').click(function() {
  //  convertToFloat();
    vendSnack();
    //clearMoney();
  });


});

function loadInventory() {
  clearInventoryList();
    var contentRows = $('#buttons');

  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/items',
    success: function(itemArray) {
      $.each(itemArray, function(index, item) {

        var id = item.id;
        var name = item.name;
        var price = item.price;
        var quantity = item.quantity;

        row = '<div class="col-md-4" id="button'+ id +'">';
        row += '<button type="button" class="btn btn-block btn-info" style="margin-bottom: 30px" value="' + item.id +'">';
        row += '<p>' + id + '</p>';
        row += '<p value="'+ item.name +'" id="itemNameTag">' + name + '</p>';
        row += '<p value="'+ item.price +'" id="itemPriceTag">' + price + '</p>';
        row += '<p>' + quantity + '</p>';
        row += '</button>';
        row += '</div>';

        //dict [id] = [name, price, quantity];

        contentRows.append(row);
      });
        $('.btn').click(function() {
          idChoice = $('#itemBox').val($(this).val());
          //initialItemQuanity = $(this).children()[3].innerHTML;
          itemPrice = $(this).children()[2].innerHTML;
          //itemChoice = $(this).children()[1].innerHTML;
        });
    },
    error: function() {
      $('#errorMessages')
      .append($('<li>')
      .attr({class: 'list-group-item list-group-item-danger'})
      .text('Error calling web service. Please try again later.'));

    }
  });
}

function clearInventoryList() {
  $('#buttons').empty();
  }

function returnChange() {
    quarters = Math.floor(money / 25);
    var quarterRemainder = ((money) % (25));
    dimes = Math.floor(quarterRemainder / 10);
    var dimeReaminder = ((money) % (10));
    nickels = Math.floor(dimeReaminder / 5);
  }

  function clearMoney() {
    money = 0;
  }

  function convertToFloat() {
    moneyFloat = parseFloat(money / 100);
    priceFloat = parseFloat(itemPrice);
  }

  function vendItem() {
    convertToFloat();
    if (moneyFloat >= priceFloat) {
      $('#messageBox').append($('#messageBox').val(itemChoice + ' popped out! Thank you!'));
      clearMoney();
      clearInventoryList();
      loadInventory();
      newMoneyFloat = (moneyFloat * 100) - (priceFloat * 100);
      console.log(newMoneyFloat);
      quarters = Math.floor(newMoneyFloat / 25);
      var quarterRemainder = ((newMoneyFloat) % (25));
      dimes = Math.floor(quarterRemainder / 10);
      var dimeReaminder = ((newMoneyFloat) % (10));
      nickels = Math.floor(dimeReaminder / 5);
      $('#changeBox').append($('#changeBox').val(quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels."));
    } else {
      $('#messageBox').append($('#messageBox').val('You dont have enough money! Please add $' + (itemPrice - (money / 100))));
    }
  }

  function vendSnack() {
    //clearInventoryList();
  var contentRows = $('#changeBox');
  moneyFloat = $("#moneyInputBox").val();
  idChoice = $("#itemBox").val();
  priceFloat = parseFloat(itemPrice);
    $.ajax({
      type: 'GET',

      url: 'http://localhost:8080/money/' + moneyFloat + '/item/' + idChoice,
      success: function() {

          //convertToFloat();
          //if (moneyFloat >= priceFloat) {
            $('#messageBox').append($('#messageBox').val('Thank you!'));
            clearMoney();
            clearInventoryList();
            loadInventory();
            newMoneyFloat = (moneyFloat * 100) - (priceFloat * 100);
            //console.log(newMoneyFloat);
            quarters = Math.floor(newMoneyFloat / 25);
            var quarterRemainder = ((newMoneyFloat) % (25));
            dimes = Math.floor(quarterRemainder / 10);
            var dimeReaminder = ((newMoneyFloat) % (10));
            nickels = Math.floor(dimeReaminder / 5);
            $('#changeBox').append($('#changeBox').val(quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels."));
          //}
          //else {
          //  $('#messageBox').append($('#messageBox').val('You dont have enough money! Please add $' + (itemPrice - (money / 100))));
          //}

      },
      error: function() {
        $('#messageBox')
        .append($('#messageBox')
        //.attr({class: 'list-group-item list-group-item-danger'})
        .val('Error!'));

      }
    });
  }
