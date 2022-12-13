<template>
  <div>
    <NavBar />
    <div v-if="getDetails===false" style="min-height: 100vh">
      <div class="row justify-content-between" style="text-align:center; margin-top: 40px">
        <div class="col-4">
          <h1>My Bookings</h1>
        </div>
        <div class="col-4">
          <b-button size="lg" variant="dark" @click="bookingForm">
            Add Booking
          </b-button>
        </div>
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
      <BookingList
        v-for="booking in bookings"
        :key="booking.bookingID"
        :bookingid="booking.bookingID"
        :checkin="booking.checkInDate"
        :checkout="booking.checkOutDate"
        @clicked="onClickListItem(booking)"
      />
      <!-- <div v-for="booking in bookings" :key="booking.bookingID">
        {{ booking.bookingID }}
      </div> -->
    </div>
    <div v-else style="min-height: 100vh">
      <b-button size="lg" variant="dark" @click="goBacktoPage">
        <span>Back</span>
      </b-button>
      <!-- <button class="custom-btn btn-1" @click="goBacktoPage">
        <span>Back</span>
      </button> -->
      <BookingDetails :booking="booking" />
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
      getDetails: false,
      bookings: [],
      booking: {},
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
    // getmapping
    myaxios
      .get(
        '/customer/booking', // get mapping for all bookings
        {
          headers: {
          // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        }

      )
      .then((response) => {
        this.bookings = response.data
        console.log(JSON.stringify(this.bookings))
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
      this.booking = value
      console.log(this.id)
    },
    goBacktoPage () {
      this.getDetails = false
    },
    bookingForm () {
      this.$router.push('/bookingForm')
    }
  }

}
</script>

<style scoped>
    @import '@/assets/booking/bookingList.css'
</style>
