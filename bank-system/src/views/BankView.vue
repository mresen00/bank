<template>
  <v-app-bar color="blue-darken-4">
    <template v-slot:image>
      <v-img
        gradient="to top right, rgba(19,84,122,.8), rgba(128,208,199,.8)"
      ></v-img>
    </template>

    <v-app-bar-title>Banking System</v-app-bar-title>

    <v-spacer></v-spacer>

    <v-menu v-if="$store.state.username != ''">
      <template v-slot:activator="{ props }">
        <v-btn icon v-bind="props"><v-icon>mdi-account</v-icon></v-btn>
      </template>

      <v-list>
        <v-list-item>
          <v-list-item-title class="ml-6 mb-1 mt-1">
            <p class="font-weight-bold">Hi, {{ $store.state.username }}!</p>
          </v-list-item-title>
          <v-list-item-title
            ><v-btn variant="text" color="red" @click="signOut">Sign out</v-btn>
          </v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </v-app-bar>

  <!-- TRANSACTION POP UP -->
  <v-dialog width="30%" v-model="transactionWindow">
    <v-card>
      <v-card-title>
        <v-text-field
          label="Amount"
          v-model="transactionAmount"
          prepend-icon="mdi-currency-usd"
        ></v-text-field>
      </v-card-title>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn
          text="Cancel"
          color="red"
          @click="transactionWindow = false"
        ></v-btn>
        <v-btn text="Confirm" color="green" @click="makeTransaction"></v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>

  <!-- ACCOUNTS -->
  <v-container v-if="$store.state.username != ''">
    <v-row>
      <v-col cols="6">
        <v-card :elevation="2" class="mt-3 mb-4 mx-auto">
          <v-card-title
            ><h4>Account Balance</h4>
            <h2>$ {{ accountBalance }}</h2></v-card-title
          >
          <!-- TRANSACTION BUTTONS -->
          <v-card-text
            ><v-btn
              @click="
                deposit = true;
                transactionWindow = true;
              "
              variant="text"
              color="blue"
              >Deposit</v-btn
            >
            |
            <v-btn
              @click="
                withdraw = true;
                transactionWindow = true;
              "
              variant="text"
              color="blue"
              >Withdraw</v-btn
            >
          </v-card-text>

          <div class="text-right">
            <v-btn
              @click="getTransactions(1)"
              class="mb-3 mr-2"
              variant="text"
              color="blue"
              >View Transactions ></v-btn
            >
          </div>
        </v-card>

        <v-card :elevation="2" class="mt-3 mb-4 mx-auto">
          <v-card-title>
            <v-row class="ml-1 mt-1 mb-2">
              <div class="mr-15">
                <h4>Credit Balance</h4>
                <h2>$ {{ creditBalance }}</h2>
              </div>
              <div>
                <h4>Credit Limit</h4>
                <h2>$ {{ creditLimit }}</h2>
              </div>
            </v-row>
          </v-card-title>
          <v-card-text>
            <v-btn
              @click="
                useCredit = true;
                transactionWindow = true;
              "
              variant="text"
              color="blue"
              >Use Credit</v-btn
            >
            |
            <v-btn
              @click="
                makePayment = true;
                transactionWindow = true;
              "
              variant="text"
              color="blue"
              >Make Payment</v-btn
            >
          </v-card-text>

          <div class="text-right">
            <v-btn
              @click="getCreditTrans(1)"
              class="mb-3 mr-2"
              variant="text"
              color="blue"
              >View Transactions ></v-btn
            >
          </div>
        </v-card>
      </v-col>

      <!-- TRANSACTION HISTORY -->
      <v-col cols="6"
        ><v-card
          v-show="transactionHistoryWindow"
          variant="flat"
          class="mt-3 ma-auto"
        >
          <v-card-title>Transaction History</v-card-title>
          <div v-for="(transaction, index) in transactionHistory" :key="index">
            <v-card
              :elevation="1"
              class="mt-3 mb-2 ml-3 mx-auto"
              height="100px"
              variant="tonal"
              color="blue-darken-2"
            >
              <v-card-title>
                <h3>
                  {{ transaction.transactionTimestamp }}
                </h3>
              </v-card-title>
              <v-card-text>
                <v-row class="mt-1 ml-1">
                  <p v-if="transaction.transactionType == 'deposit'">+</p>
                  <p v-else-if="transaction.transactionType == 'withdrawal'">-</p>
                  <p class="ml-1" style="font-size: 17px">
                    ${{ transaction.transactionAmount }}
                  </p>
                </v-row>
              </v-card-text>
            </v-card>
          </div>
        </v-card>
        <v-card
          v-show="CreditHistoryWindow"
          variant="flat"
          class="mt-3 ma-auto"
        >
          <v-card-title>Credit Transaction History</v-card-title>
          <div v-for="(transaction, index) in transactionCreditHistory" :key="index">
            <v-card
              :elevation="1"
              class="mt-3 mb-2 ml-3 mx-auto"
              height="100px"
              variant="tonal"
              color="blue-darken-2"
            >
              <v-card-title>
                <h3>
                  {{ transaction.transactionDate }}
                </h3>
              </v-card-title>
              <v-card-text>
                <v-row class="mt-1 ml-1">
                  <p v-if="transaction.transactionType == 'payment'">-</p>
                  <p v-else-if="transaction.transactionType == 'expense'">+</p>
                  <p class="ml-1" style="font-size: 17px">
                    ${{ transaction.transactionAmount }}
                  </p>
                </v-row>
              </v-card-text>
            </v-card>
          </div>
        </v-card><v-card
          v-show="CreditHistoryWindow"
          variant="flat"
          class="mt-3 ma-auto"
        >
          <v-card-title>Credit Transaction History</v-card-title>
          <div v-for="(transaction, index) in transactionCreditHistory" :key="index">
            <v-card
              :elevation="1"
              class="mt-3 mb-2 ml-3 mx-auto"
              height="100px"
              variant="tonal"
              color="blue-darken-2"
            >
              <v-card-title>
                <h3>
                  {{ transaction.transactionDate }}
                </h3>
              </v-card-title>
              <v-card-text>
                <v-row class="mt-1 ml-1">
                  <p v-if="transaction.transactionType == 'payment'">-</p>
                  <p v-else-if="transaction.transactionType == 'expense'">+</p>
                  <p class="ml-1" style="font-size: 17px">
                    ${{ transaction.transactionAmount }}
                  </p>
                </v-row>
              </v-card-text>
            </v-card>
          </div>
        </v-card>
        </v-col
      >
      <v-col cols="6"
        ></v-col
      >
    </v-row>
  </v-container>

  <!-- NO USER FOUND VIEW -->
  <div v-else-if="$store.state.username == ''">
    <p class="ml-3 mt-2 font-weight-bold">No user found.</p>
  </div>
</template>

<script>
import { defineComponent } from "vue";
//import transactionApi from "../services/transactionApi";
import axios from "axios";
// Components
export default defineComponent({
  name: "BankView",

  components: {},

  data: () => ({
    accountBalance: 1000,
    creditLimit: 1000,
    creditBalance: 0,
    transaction: "",
    transactionHistory: [],
    transactionCreditHistory: [],
    transactionAmount: 0,

    testData: [
      {
        transactionId: 1,
        transactionType: "Deposit",
        transactionAmount: 100,
        transactionTimestamp: "2023-07-23 10:00",
      },
      {
        transactionId: 2,
        transactionType: "Withdraw",
        transactionAmount: 200,
        transactionTimestamp: "2022-07-23 12:00",
      },
      {
        transactionId: 3,
        transactionType: "Deposit",
        transactionAmount: 600,
        transactionTimestamp: "2021-07-23 11:00",
      },
    ],

    transactionHistoryWindow: false,
    CreditHistoryWindow: false,
    transactionWindow: false,

    deposit: false,
    withdraw: false,
    useCredit: false,
    makePayment: false,
  }),

  methods: {
    parseFloatIfValid(str) {
        // Use a regular expression to check if the inputString contains numbers and a decimal point
        const regex = /^[0-9]*\.?[0-9]+$/;
        // If the inputString matches the regular expression, parse it to a float, otherwise return null
        return regex.test(str) ? parseFloat(str) : NaN;
    },
    signOut() {
      this.$router.back();
      this.$store.dispatch("setUsername", "");
    },
    //TRANSACTION METHOD HERE
    async makeTransaction() {
      if (this.deposit) {
        this.depositTransaction();
        this.deposit = false;
        this.transactionWindow = false;
      } else if (this.withdraw) {
        this.withdrawTransaction();
        this.withdraw = false;
        this.transactionWindow = false;
      } else if (this.useCredit) {
        this.useCreditTransaction();
        this.useCredit = false;
        this.transactionWindow = false;
      } else if (this.makePayment) {
        this.makePaymentTransaction();
        this.makePayment = false;
        this.transactionWindow = false;
      }
    },

    //API CALLS
    async depositTransaction() {
      try {
    // Assuming you have a variable to store the deposit amount, e.g., this.transactionAmount
    const depositAmount = this.parseFloatIfValid(this.transactionAmount);
    console.log(depositAmount);
    if (isNaN(depositAmount) || depositAmount <= 0) {
      // Handle invalid input (negative amount or non-numeric input)
      // You can show an error message or take appropriate action here.
      return;
    }
    
    // Make an API call to deposit the specified amount
    const response = await axios.post(
      "http://localhost:8080/api/v1/account/deposit/"+this.$store.state.username+"/"+depositAmount
    );
    console.log(response.data);
    this.fetchAccountAndCreditBalance();
    
    // Reset the transactionAmount input field
    this.transactionAmount = "";
  } catch (error) {
    console.error("Error making deposit:", error);
    // Handle the error, e.g., show an error message to the user.
  }
    },
    async withdrawTransaction() {
    try {
    // Assuming you have a variable to store the deposit amount, e.g., this.transactionAmount
    const depositAmount = this.parseFloatIfValid(this.transactionAmount);
    console.log(depositAmount);
    if (isNaN(depositAmount) || depositAmount <= 0) {
      // Handle invalid input (negative amount or non-numeric input)
      // You can show an error message or take appropriate action here.
      return;
    }
    
    // Make an API call to deposit the specified amount
    const response = await axios.post(
      "http://localhost:8080/api/v1/account/withdrawal/"+this.$store.state.username+"/"+depositAmount
    );
    console.log(response.data);
    this.fetchAccountAndCreditBalance();
    
    // Reset the transactionAmount input field
    this.transactionAmount = "";
  } catch (error) {
    console.error("Error making deposit:", error);
    // Handle the error, e.g., show an error message to the user.
  }
    },
    async useCreditTransaction() {
    try {
    // Assuming you have a variable to store the deposit amount, e.g., this.transactionAmount
    const depositAmount = this.parseFloatIfValid(this.transactionAmount);
    console.log(depositAmount);
    if (isNaN(depositAmount) || depositAmount <= 0) {
      // Handle invalid input (negative amount or non-numeric input)
      // You can show an error message or take appropriate action here.
      return;
    }
    
    // Make an API call to deposit the specified amount
    const response = await axios.post(
      "http://localhost:8080/api/v1/credit/creditExpense/"+this.$store.state.username+"/"+depositAmount
    );
    console.log(response.data);
    this.fetchAccountAndCreditBalance();
    
    // Reset the transactionAmount input field
    this.transactionAmount = "";
  } catch (error) {
    console.error("Error making deposit:", error);
    // Handle the error, e.g., show an error message to the user.
  }
    },
    async makePaymentTransaction() {
    try {
    // Assuming you have a variable to store the deposit amount, e.g., this.transactionAmount
    const depositAmount = this.parseFloatIfValid(this.transactionAmount);
    console.log(depositAmount);
    if (isNaN(depositAmount) || depositAmount <= 0) {
      // Handle invalid input (negative amount or non-numeric input)
      // You can show an error message or take appropriate action here.
      return;
    }
    
    // Make an API call to deposit the specified amount
    const response = await axios.post(
      "http://localhost:8080/api/v1/credit/creditPayment/"+this.$store.state.username+"/"+depositAmount
    );
    console.log(response.data);
    this.fetchAccountAndCreditBalance();
    
    // Reset the transactionAmount input field
    this.transactionAmount = "";
  } catch (error) {
    console.error("Error making deposit:", error);
    // Handle the error, e.g., show an error message to the user.
  }
    },
    
    async fetchAccountAndCreditBalance() {
      try {
        // Make API calls to fetch account and credit balances
        const accountResponse = await axios.get(
          "http://localhost:8080/api/v1/account/getBalance/" + this.$store.state.username
        );
        const creditResponse = await axios.get(
          "http://localhost:8080/api/v1/credit/getCreditAccount/" + this.$store.state.username
        );

        // Update the data properties with the fetched balances
        this.accountBalance = accountResponse.data.balance;
        this.creditBalance = creditResponse.data.currentBalance;
        this.creditLimit = creditResponse.data.creditLimit;
      } catch (error) {
        console.error("Error fetching balances:", error);
        // Handle the error, e.g., show an error message to the user.
      }
    },

    async getTransactions() {
      try {
        this.CreditHistoryWindow = false;
        if (this.transactionHistoryWindow == false) {
          // Make an API call to retrieve all transactions
          const response = await axios.get(
            "http://localhost:8080/api/v1/transaction/view/"+this.$store.state.username
          ); // Replace with your API endpoint

          // Assuming the response contains an array of transactions
          this.transactionHistory = response.data;
          this.transactionHistory.reverse();
          // You can now use this.transactions in your template to display the list of transactions
          this.transactionHistoryWindow = true;
        } else {
          this.transactionHistoryWindow = false;
        }
      } catch (error) {
        console.error("Error fetching transactions:", error);
      }
    },
    async getCreditTrans() {
      try {
        this.transactionHistoryWindow = false;
        if (this.CreditHistoryWindow == false) {
          // Make an API call to retrieve all transactions
          const response = await axios.get(
            "http://localhost:8080/api/v1/CreditLog/viewTrans/"+this.$store.state.username
          ); // Replace with your API endpoint
          

          // Assuming the response contains an array of transactions
          this.transactionCreditHistory = response.data;
          this.transactionCreditHistory.reverse();
          // You can now use this.transactions in your template to display the list of transactions
          this.CreditHistoryWindow = true;
        } else {
          this.CreditHistoryWindow = false;
        }
      } catch (error) {
        console.error("Error fetching transactions:", error);
      }
    }
  },
  mounted() {
    // Call the getTransactions method when the component is mounted
    
    this.fetchAccountAndCreditBalance();
  },
});
</script>
