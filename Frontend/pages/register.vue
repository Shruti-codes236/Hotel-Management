<template>
  <div>
    <NavBar />
    <div class="bgImg" />
    <div class="content">
      <div class="d-flex h-100 align-items-center justify-content-center">
        <div class="container">
          <div v-if="exists" class="row alert alert-danger">
            This Email already exists!!!
          </div>
          <div class="row">
            <div class="col-md-7 col-sm-6 ml-auto mr-auto">
              <div class="card">
                <div class="card-body">
                  <form>
                    <div class="glowBox">
                      <h2 class="title">
                        Sign Up
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
                        v-model="alternateEmailAddress"
                        type="text"
                        class="form"
                        placeholder="Alternate Email Address"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="aadharCardNumber"
                        type="text"
                        class="form"
                        placeholder="Aadhar Card Number"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                  </div>
                  <center>
                    <button class="custom-btn btn-1" @click="register">
                      <span>Sign Up</span>
                    </button>
                  </center>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <Footer />
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
      gender: '',
      alternateEmailAddress: '',
      aadharCardNumber: ''
    }
  },
  methods: {
    register () {
      let exists = Boolean(0)
      const router = this.$router
      myaxios.post('/register', {
        fname: this.fname,
        lname: this.lname,
        pEmail: this.pEmail,
        pswd: this.pswd,
        houseNo: this.houseNo,
        state: this.state,
        city: this.city,
        country: this.country,
        pinCode: this.pinCode,
        gender: this.gender,
        alternateEmailaddress: this.alternateEmailaddress,
        aadharCardNumber: this.aadharCardNumber
      }).then(function (response) {
        console.log(response.data)
        console.log(response.data.localeCompare('fail'))
        const i = response.data.localeCompare('fail')
        if (i === 0) {
          exists = true
          alert('User already exists!')
          console.log(exists)
        }
        router.push('/login')
      }).catch((error) => {
        this.errorMessage = error.message
        console.error('There was an error!', error)
        alert('Invalid Input!')
        // router.push('/')
      })
    }
  }
}
</script>

<style scoped>
@import '@/assets/register/register.css';
</style>
