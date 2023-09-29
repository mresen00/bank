const transactionApi = {
  async GetTransactions() {
    fetch("http://localhost:8080/api/v1/transaction/get")
    .then((res) => res.text())
    .then((data) => {
        console.log(data);
        return data;
    });
  },

};


export default transactionApi;
