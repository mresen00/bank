<template>
  <v-container fluid>
    <v-snackbar color="red" v-model="error" :timeout="2000">
      Invalid
    </v-snackbar>
    <v-snackbar color="green" v-model="succ" :timeout="2000">
      Registration Successful
    </v-snackbar>
    <v-row justify="center">
      <v-card class="mt-5" width="50%">
        <v-tabs v-model="tab" color="green" align-tabs="center" @click="clear">
          <v-tab value="tab-1">Login</v-tab>
          <v-tab value="tab-2">Register</v-tab>
        </v-tabs>
        <v-card-text>
          <v-window v-model="tab">
            <v-window-item class="mt-2 mb-2" :key="1" :value="'tab-1'">
              <v-text-field
                v-model="username"
                label="Username"
                clearable
                variant="outlined"
                @keydown.enter="auth"
              ></v-text-field>

              <v-text-field
                v-model="password"
                label="Password"
                type="password"
                clearable
                variant="outlined"
                @keydown.enter="auth"
              ></v-text-field>

              <v-btn
                @click="auth"
                width="100%"
                color="green"
                text="Log In"
              ></v-btn>
            </v-window-item>
            <v-window-item class="mt-2 mb-2" :key="2" :value="'tab-2'">
              <v-text-field
                v-model="email"
                label="Email"
                clearable
                variant="outlined"
              ></v-text-field>
              <v-text-field
                v-model="username"
                label="Username"
                clearable
                variant="outlined"
              ></v-text-field>

              <v-text-field
                v-model="password"
                label="Password"
                type="password"
                clearable
                variant="outlined"
              ></v-text-field>

              <v-row class="mb-3" justify="center">
                <v-btn-toggle
                  color="green-lighten-4"
                  v-model="accountType"
                  rounded="0"
                  group
                >
                  <v-btn value="consumer"> Consumer </v-btn>

                  <v-btn value="store"> Store </v-btn>

                  <v-btn value="factory"> Factory </v-btn>
                </v-btn-toggle>
              </v-row>
              <v-btn
                width="100%"
                color="green"
                text="Sign Up"
                @click="register"
              ></v-btn>
            </v-window-item>
          </v-window>
        </v-card-text>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  name: "LoginView",
  data: () => ({
    tab: null,
    username: "",
    password: "",
    email: "",
    succ: false,
    error: false,

    accountType: "",
  }),
  methods: {
    validateFields() {
      // Check if username, password, and email are not blank
      if (!this.username || !this.password || !this.email || !this.accountType) {
        this.error = true;
        return false; // Fields are not valid
      }
      this.error = false; // Reset error flag if fields are valid
      return true; // Fields are valid
    },
    validateFields2() {
      // Check if username and password are not blank
      if (!this.username || !this.password) {
        this.error = true;
        console.log("check");
        return false; // Fields are not valid
      }
      this.error = false; // Reset error flag if fields are valid
      return true; // Fields are valid
    },
    async register() {
      if (!this.validateFields()) {
        return; // Exit if fields are not valid
      }
      console.log("checker:", this.password);
      try {
        const response = await axios.post(
          "http://localhost:8080/api/v1/customer/register",
          {
            customer_email: this.email,
            customer_username: this.username,
            customer_password: this.password,
            customer_first_name: "john",
            customer_last_name: "smith",userType:this.accountType
          }
        );
        // Handle the successful registration here (e.g., show a success message).
        console.log("Registration successful:", response.data);
        this.succ = true;
        this.clear();
        // You can also redirect the user to a login page or perform other actions.
      } catch (error) {
        // Handle registration errors here (e.g., show an error message).
        console.error("Registration error:", error);

        // Set the error property to show an error message in your component.
        this.error = true;
      }
    },
    async auth() {
      if (!this.validateFields2()) {
        return; // Exit if fields are not valid
      }
      console.log("check:", this.password);
      try {
        const response = await axios.post(
          "http://localhost:8080/api/v1/customer/auth",
          {
            customer_email: "empty",
            customer_username: this.username,
            customer_password: this.password,
            customer_first_name: "empty",
            customer_last_name: "empty",
          }
        );

        console.log("Response:", response.data);

        if (response.data === true) {
          this.$store.dispatch("setUsername", this.username);
          this.$router.push("bank");
        } else {
          this.error = true;
          this.clear();
        }
      } catch (error) {
        console.error("Response:", error);
        this.error = true;
        this.clear();
      }
    },
    clear() {
      this.username = "";
      this.password = "";
      this.email = "";
      this.account = "";
    },
    required(v) {
      return !!v || "Required";
    },
  },
};
</script>

<style></style>
