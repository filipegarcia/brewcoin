var BrewCoin = artifacts.require("./BrewCoin.sol");

contract('BrewCoin', function(accounts) {
  it("Deploy and issue coin", function() {
    BrewCoin.deployed().then(function(instance) {
        return instance.getBalance.call(accounts[0]);
    }).then(function(balance) {
      assert.equal(balance.valueOf(), 1000000 * Math.pow(10, 18), "Initial supply doesn't match 1M BREW COINS");
    });

    return true;
  });
});