<template>
  <center>
    <div class="col-md-6 col-sm-6 ">
      <div class="chunk booking-card clearfix">
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <span class="profile-pic" />
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9 name-date">
            <div class="guest-name">
              {{ booking.bookingID }}
            </div>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="check-in">
              Check In Date
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="check-in-date">
              {{ booking.checkInDate }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="check-out">
              Check Out Date
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="check-out-date">
              {{ booking.checkOutDate }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Number Of Members
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ booking.countMember }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Number Of Single Rooms
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ booking.singleRoom }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Number Of Double Rooms
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ booking.doubleRoom }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Services chosen
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ services }}
            </span>
          </div>
        </div>

        <!-- <div class="row card-row total">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="earnings">
              Total Price
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="earnings-total">
              {{ booking.price }}
            </span>
          </div>
        </div> -->
      </div>
      <button class="custom-btn btn-1" style="margin-top:20px" @click="goToFeedback">
        <span>Give Feedback</span>
      </button>
    </div>
  </center>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  props: ['booking'],
  data () {
    return {
      services: ''
    }
  },
  mounted () {
    console.log(this.booking.bookingid)
    const router = this.$router
    myaxios
      .post(
        '/booked/services', // post mapping for all bookings
        {
          bookingID: this.booking.bookingID
        },
        {
          headers: {
          // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        }

      )
      .then((response) => {
        this.services = response.data
        console.log(JSON.stringify(this.services))
        const str = this.services
        this.services = str.slice(0, -2)
      }
      )
      .catch((error) => {
        this.errorMessage = error.message
        console.error('There was an error!', error)
        alert('An Error has occurred!')
        router.push('/')
      })
    // getmapping for the passed bookingID
  },
  methods: {
    goToFeedback () {
      this.$router.push({ name: 'feedbackForm', params: { bookingid: this.booking.bookingID } })
    }
  }

}
</script>

<style scoped>
@import "@/assets/booking/bookingDetails.css"
</style>
