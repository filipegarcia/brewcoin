pragma solidity ^0.4.4;

import "node_modules/zeppelin-solidity/contracts/math/SafeMath.sol";
import "node_modules/zeppelin-solidity/contracts/token/ERC20Basic.sol";
import "node_modules/zeppelin-solidity/contracts/token/BasicToken.sol";
import "node_modules/zeppelin-solidity/contracts/token/ERC20.sol";
import "node_modules/zeppelin-solidity/contracts/token/StandardToken.sol";

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