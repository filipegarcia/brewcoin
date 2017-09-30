module.exports = {
  networks: {
    ropsten: {
      host: "localhost",
      port: 8545,
      network_id: 3, // Match any network id
      // from:
    },

    development: {
      host: "localhost",
      port: 8545,
      network_id: "*" // Match any network id
    }
  }
};
