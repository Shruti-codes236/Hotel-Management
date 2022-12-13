<template>
  <div class="container emp-profile">
    <form method="post">
      <div class="row">
        <div class="col-md-4">
          <div class="profile-img">
            <img src="@/static/imgs/360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg" alt="">
          </div>
        </div>
        <div class="col-md-6">
          <div class="profile-head">
            <h5>
              {{ user.fname + " " + user.lname }}
            </h5>
            <ul id="myTab" class="nav nav-tabs" role="tablist">
              <li class="nav-item">
                <a
                  id="home-tab"
                  class="nav-link active"
                  data-toggle="tab"
                  href="#home"
                  role="tab"
                  aria-controls="home"
                  aria-selected="true"
                >About</a>
              </li>
            </ul>
          </div>
        </div>
        <div v-if="!noidea" class="col-md-2">
          <nuxt-link to="/editProfile">
            <input
              type="submit"
              class="profile-edit-btn"
              name="btnAddMore"
              value="Edit Profile"
            >
          </nuxt-link>
        </div>
      </div>
      <div class="row">
        <div class="col-md-4">
          <div class="profile-work">
            <p>Options</p>
            <div v-if="noidea">
              <div v-if="isAdmin">
                <nuxt-link to="/admin">
                  <button type="button" class="btn btn-primary btn-block">
                    Admin
                  </button>
                </nuxt-link>
              </div>
              <!-- /employee/subordinates -->
              <nuxt-link to="/subord">
                <button type="button" class="btn btn-primary btn-block" style="margin-top:20px">
                  Subordinates
                </button>
              </nuxt-link>
            </div>
            <div v-else>
              <button type="button" class="btn btn-primary btn-block" @click="navigateContactUs">
                ContactUs
              </button>
              <button type="button" class="btn btn-primary btn-block" @click="navigateBookings">
                Booking
              </button>
              <button type="button" class="btn btn-primary btn-block" @click="navigateReplies">
                Replies
              </button>
            </div>
          </div>
        </div>
        <div class="col-md-8">
          <div id="myTabContent" class="tab-content profile-tab">
            <div class="tab-pane fade show active" role="tabpanel" aria-labelledby="home-tab">
              <div class="row">
                <div class="col-md-6">
                  <label>Name</label>
                </div>
                <div class="col-md-6">
                  <p>{{ user.fname + " " + user.lname }} </p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Email</label>
                </div>
                <div class="col-md-6">
                  <p>{{ user.pEmail }}</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Address</label>
                </div>
                <div class="col-md-6">
                  <p>{{ user.houseNo + ", "+ user.city + ", " + user.state }}</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Country</label>
                </div>
                <div class="col-md-6">
                  <p>{{ user.country }}</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Pin Code</label>
                </div>
                <div class="col-md-6">
                  <p>{{ user.pinCode }}</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Gender</label>
                </div>
                <div class="col-md-6">
                  <p>{{ user.gender }}</p>
                </div>
              </div>
              <div
                v-if="noidea"
                class="tab-pane fade show active"
                role="tabpanel"
                aria-labelledby="home-tab"
              >
                <div class="row">
                  <div class="col-md-6">
                    <label>Current Address</label>
                  </div>
                  <div class="col-md-6">
                    <p>{{ emp.currHouseNo + ", "+ emp.currCity + ", " + emp.currState + ", " + emp.currPinCode }}</p>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-6">
                    <label>Marital Status</label>
                  </div>
                  <div class="col-md-6">
                    <p>{{ emp.maritalStatus }}</p>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-6">
                    <label>Department Name</label>
                  </div>
                  <div class="col-md-6">
                    <p>{{ emp.deptName }}</p>
                  </div>
                </div>
              </div>

              <div
                v-else
                class="tab-pane fade show active"
                role="tabpanel"
                aria-labelledby="home-tab"
              >
                <div class="row">
                  <div class="col-md-6">
                    <label>Aadhar Number</label>
                  </div>
                  <div class="col-md-6">
                    <p>{{ cust.aadharCardNumber }}</p>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-6">
                    <label>Alternate Email Address</label>
                  </div>
                  <div class="col-md-6">
                    <p>{{ cust.alternateEmailAddress }}</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  data () {
    return {
      noidea: true,
      isAdmin: false,
      emp: {},
      cust: {},
      user: {}
    }
  },
  mounted () {
    console.log('mounted')
    myaxios
      .get(
        '/dashboard',
        {
          headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        }
      )
      .then((response) => {
        this.user = response.data
        console.log(this.user)
        console.log(this.user.isEmp)
        if (this.user.isEmp) { this.getEmployee() } else { this.getCustomer() }
        this.noidea = this.user.isEmp
      }
      )
      .catch((error) => {
        this.errorMessage = error.message
        console.error('There was an error!', error)
        alert('User does not exist!')
        this.logout()
      })
    // if (this.noidea) { this.getEmployee() } else { this.getCustomer() }
  },
  methods: {
    getEmployee () {
      const router = this.$router
      myaxios
        .get(
          '/dashboard/employee',
          {
            headers: {
            // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
              Authorization: `Bearer ${localStorage.getItem('token')}`
            }
          }
        )
        .then((response) => {
          this.emp = response.data
          if (this.emp.superID == null) {
            this.isAdmin = true
          }
        })
        .catch((error) => {
          this.errorMessage = error.message
          console.error('There was an error!', error)
          alert('An Error has occurred!')
          router.push('/')
        })
    },

    getCustomer () {
      const router = this.$router
      myaxios
        .get(
          '/dashboard/customer',
          {
            headers: {
              Authorization: `Bearer ${localStorage.getItem('token')}`
            }
          }
        )
        .then(response => (this.cust = response.data))
        .catch((error) => {
          this.errorMessage = error.message
          console.error('There was an error!', error)
          alert('An Error has occurred!')
          router.push('/')
        })
    },
    navigateContactUs () {
      this.$router.push({ name: 'contactus', params: { customerid: this.cust.customerID } })
    },
    navigateBookings () {
      this.$router.push('/bookings')
    },
    navigateReplies () {
      // console.log(this.cust.customerID)
      this.$router.push({ name: 'reply', params: { customerid: this.cust.customerID } })
    },
    logout () {
      localStorage.removeItem('token')
      this.$router.push('/login')
    }
  }
}
</script>

<style>
</style>
