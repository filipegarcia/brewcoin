# Brew Coin Smart Contract

Purpose of this token is to enable resource sharing and crowdfund supply purchases between breweries and their suppliers.

## Token Details (test network ropsten)

* Contract Address *0xb9E2E0d9a2B8f720073CF5C2B64Af8C1C2Fb4ACa*
* Token Symbol *BREW*
* Token Name *Brew Coin*
* Decimals *18*
* Total Supply *1,000,000 (1M) BREW*

## Sample Transaction

Sample purchase of BREW coins by fictional "Small brewery"
https://ropsten.etherscan.io/tx/0xcdc4e28f99ed452cddebf6a45152e817e4a76699b0a7b38503f6871c1f419705


## Contract Code and Security

Contract is built on top of popular solidity framework OpenZeppelin
https://github.com/OpenZeppelin/zeppelin-solidity

```php
contract BrewCoin is StandardToken {
     string public constant name = "Brew Coin";
     string public constant symbol = "BREW";
     uint8 public constant decimals = 18;

     uint256 public INITIAL_SUPPLY = 1000000 * (10 ** 18);

     function BrewCoin() {
         balances[msg.sender] = INITIAL_SUPPLY;
         totalSupply = INITIAL_SUPPLY;
     }
}
```
