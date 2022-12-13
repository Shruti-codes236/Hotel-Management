<template>
  <div>
    <NavBar />
    <div class="bgImg" />
    <div class="content">
      <div class="d-flex h-100 align-items-center justify-content-center">
        <div class="container">
          <div class="row">
            <div class="col-md-7 col-sm-6 ml-auto mr-auto">
              <div class="card">
                <div class="card-body">
                  <form>
                    <div class="glowBox">
                      <h2 class="title">
                        Edit Profile
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
                        disabled
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
                      <span>Edit</span>
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
      houseNo: '',
      state: '',
      city: '',
      country: '',
      pinCode: '',
      alternateEmailAddress: '',
      aadharCardNumber: '',
      user: {}
    }
  },
  mounted () {
    const tkn = localStorage.getItem('token')
    if (tkn === null) {
      alert('User not logged in')
      this.$router.push('/login')
    }
    const router = this.$router
    myaxios
      .get(
        '/dashboard', // get mapping for all userEmployee subords
        {
          headers: {
            // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        }

      )
      .then((response) => {
        this.user = response.data
        console.log(JSON.stringify(this.user))
        if (this.user.isEmp) {
          alert('forbidden')
          this.$router.push('/forbidden')
        }
      }
      )
      .catch((error) => {
        this.errorMessage = error.message
        console.error('There was an error!', error)
        alert('An Error has occurred!')
        router.push('/')
      })
    myaxios
      .get(
        '/edit-profile',
        // get mapping for userCustomer,
        {
          headers: {
            // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        }
      )
      .then((response) => {
        console.log('mounted')

        this.fname = response.data.fname
        this.lname = response.data.lname
        this.pEmail = response.data.pEmail
        this.houseNo = response.data.houseNo
        this.state = response.data.state
        this.city = response.data.city
        this.country = response.data.country
        this.pinCode = response.data.pinCode
        this.alternateEmailAddress = response.data.alternateEmailAddress
        this.aadharCardNumber = response.data.aadharCardNumber
      }
      )
      .catch((error) => {
        this.errorMessage = error.message
        console.error('There was an error!', error)
        alert('An Error has occurred!')
        router.push('/')
      })
  },
  methods: {
    register () {
      const router = this.$router
      myaxios.post('/edit-profile', {
        fname: this.fname,
        lname: this.lname,
        pEmail: this.pEmail,
        houseNo: this.houseNo,
        state: this.state,
        city: this.city,
        country: this.country,
        pinCode: this.pinCode,
        alternateEmailAddress: this.alternateEmailAddress,
        aadharCardNumber: this.aadharCardNumber
      },
      {
        headers: {
          // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
          Authorization: `Bearer ${localStorage.getItem('token')}`
        }
      }).then(function (response) {
        console.log(response.data)
        router.push('/dashboard')
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
  </style>
