var BrewCoin = artifacts.require("./BrewCoin.sol");

module.exports = function(deployer) {
  console.log(deployer.provider);
  deployer.deploy(BrewCoin);
};
