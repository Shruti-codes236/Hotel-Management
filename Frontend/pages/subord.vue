<template>
  <div>
    <NavBar />
    <div v-if="getDetails===false">
      <div class="row justify-content-between" style="text-align:center; margin-top: 40px">
        <div class="col-4">
          <h1>My Subordinates</h1>
        </div>
        <!-- <div class="col-4">
          <b-button size="lg" variant="dark" href="/bookingForm">
            Add Booking
          </b-button>
        </div> -->
      </div>

      <!-- <div class="page">
          <div class="buttons">
            <a class="btn add-new" href="/booking-form">Add New Booking</a>
          </div>
        </div>
        <h1 style="text-align:center">
          My Bookings
        </h1> -->
      <!-- <BookingList /> -->
      <subordList
        v-for="subord in subords"
        :key="subord.empID"
        :fname="subord.fname"
        :lname="subord.lname"
        :pemail="subord.pEmail"
        :gender="subord.gender"
        :deptname="subord.deptName"
        @clicked="onClickListItem(subord)"
      />
    </div>
    <div v-else>
      <b-button size="lg" variant="dark" @click="goBacktoPage">
        <span>Back</span>
      </b-button>
      <!-- <button class="custom-btn btn-1" @click="goBacktoPage">
          <span>Back</span>
        </button> -->
      <subordDetails :subord="subord" />
    </div>
  </div>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  data () {
    return {
      getDetails: false,
      subords: [],
      subord: {},
      user: {}
    }
  },
  mounted () {
    const tkn = localStorage.getItem('token')
    if (tkn === null) {
      alert('User not logged in')
      this.$router.push('login')
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
        if (!this.user.isEmp) { this.$router.push('forbidden') }
      }
      )
      .catch((error) => {
        this.errorMessage = error.message
        console.error('There was an error!', error)
        alert('An Error has occurred!')
        router.push('/')
      })
    // getmapping
    myaxios
      .get(
        '/dashboard/employee/subord', // get mapping for all userEmployee subords
        {
          headers: {
            // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        }

      )
      .then((response) => {
        this.subords = response.data
        console.log(JSON.stringify(this.subords))
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
    onClickListItem (value) {
      this.getDetails = true
      this.subord = value
      console.log(this.id)
    },
    goBacktoPage () {
      this.getDetails = false
    }
  }

}
</script>

  <style scoped>
      @import '@/assets/booking/bookingList.css'
  </style>
