<template>
  <div>
    <div class="bgImg" />
    <div class="content" style="min-height: 100%">
      <div class="d-flex h-100 align-items-center justify-content-center">
        <div class="container">
          <div class="row">
            <div class="col-md-7 col-sm-6 ml-auto mr-auto">
              <div class="card1">
                <div class="card-body">
                  <form>
                    <div class="glowBox">
                      <h2 class="title">
                        Add Employee
                      </h2>
                    </div>
                  </form>
                  <div class="signUp">
                    <span class="req">
                      <input
                        v-model="fname"
                        type="text"
                        class="form"
                        placeholder="First Name"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="lname"
                        type="text"
                        class="form"
                        placeholder="Last Name"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="pEmail"
                        type="text"
                        class="form"
                        placeholder="Email"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="pswd"
                        type="password"
                        class="form"
                        placeholder="Password"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />

                    </span>
                    <h5 class="form-head">
                      <u>Permanent Address</u>
                    </h5>
                    <span>
                      <input
                        v-model="houseNo"
                        type="text"
                        class="form"
                        placeholder="House Number"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="city"
                        type="text"
                        class="form"
                        placeholder="City"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="state"
                        type="text"
                        class="form"
                        placeholder="State"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="country"
                        type="text"
                        class="form"
                        placeholder="Country"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="pinCode"
                        type="text"
                        class="form"
                        placeholder="Pincode"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <h5 class="form-head">
                      <u>Current Address</u>
                    </h5>
                    <span>
                      <input
                        v-model="currHouseNo"
                        type="text"
                        class="form"
                        placeholder="House Number"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="currCity"
                        type="text"
                        class="form"
                        placeholder="City"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="currState"
                        type="text"
                        class="form"
                        placeholder="State"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>

                    <span>
                      <input
                        v-model="currPinCode"
                        type="text"
                        class="form"
                        placeholder="Pincode"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <h5 class="form-head">
                      <u>Other Details</u>
                    </h5>
                    <span>
                      <input
                        v-model="gender"
                        type="text"
                        class="form"
                        placeholder="Gender"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="maritalStatus"
                        type="text"
                        class="form"
                        placeholder="Marital Status"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="panCard"
                        type="text"
                        class="form"
                        placeholder="Pan Card Number"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="accountNo"
                        type="text"
                        class="form"
                        placeholder="Account Number"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="IFSCCode"
                        type="text"
                        class="form"
                        placeholder="IFSC Code"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="bankName"
                        type="text"
                        class="form"
                        placeholder="Bank Name"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="deptName"
                        type="text"
                        class="form"
                        placeholder="Department Name"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                  </div>
                  <center>
                    <button class="custom-btn btn-1" @click="addEmp">
                      <span>Add</span>
                    </button>
                  </center>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  data () {
    return {
      fname: '',
      lname: '',
      pEmail: '',
      pswd: '',
      houseNo: '',
      state: '',
      city: '',
      country: '',
      pinCode: '',
      currHouseNo: '',
      currState: '',
      currCity: '',
      currPinCode: '',
      gender: '',
      maritalStatus: '',
      panCard: '',
      accountNo: '',
      IFSCCode: '',
      bankName: '',
      deptName: '',
      leavesAllowed: 0,
      salary: 0
    }
  },
  methods: {
    addEmp () {
      const router = this.$router
      myaxios.post('/admin/addEmployee', {
        fname: this.fname,
        lname: this.lname,
        pEmail: this.pEmail,
        pswd: this.pswd,
        houseNo: this.houseNo,
        state: this.state,
        city: this.city,
        country: this.country,
        pinCode: this.pinCode,
        currHouseNo: this.houseNo,
        currState: this.state,
        currCity: this.city,
        currPinCode: this.pinCode,
        gender: this.gender,
        maritalStatus: this.maritalStatus,
        panCard: this.panCard,
        accountNo: this.accountNo,
        IFSCCode: this.IFSCCode,
        bankName: this.bankName,
        deptName: this.deptName,
        leavesAllowed: this.leavesAllowed,
        salary: this.salary
      }).then(function (response) {
        console.log(response.data)
        router.push('/admin')
      }).catch((error) => {
        this.errorMessage = error.message
        console.error('There was an error!', error)
        alert('An Error has occurred!')
        router.push('/')
      })
    }
  }
}
</script>

  <style scoped>
  @import '@/assets/register/register.css';
  @import '@/assets/employee/addEmp.css';

  </style>
