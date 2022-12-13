
<template>
  <div id="booking" class="section">
    <div class="section-center">
      <div class="container">
        <div class="row">
          <div class="booking-form">
            <div class="form-header">
              <h1>Add Service</h1>
            </div>
            <form>
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <input v-model="serviceName" class="form-control" type="text" required placeholder="Service Name">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <input
                      v-model="headedBy"
                      class="form-control"
                      type="text"
                      placeholder="Dept Head"
                      required
                    >
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-3" />
                <div class="col-md-6">
                  <div class="form-group">
                    <label class="fieldLabel">Price</label>
                    <input
                      v-model="price"
                      class="form-control"
                      type="number"
                      placeholder="Price"
                      required
                    >
                  </div>
                </div>
                <div class="col-md-3" />
              </div>
              <div class="row">
                <div class="col-md-5" />
                <div class="col-md-6">
                  <div class="form-group">
                    <label class="fieldLabel">Availability</label>
                    <input v-model="availability" type="checkbox" required>
                  </div>
                </div>
                <div class="col-md-5" />
              </div>
              <div class="form-btn">
                <button
                  type="button"
                  class="submit-btn"
                  @click="addService"
                >
                  Add Service
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!-- <a target="_blank" href="https://gosnippets.com" class="white-mode">MORE</a> -->
  </div>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  data () {
    return {
      serviceName: '',
      availability: true,
      price: 0,
      headedBy: ''

    }
  },
  mounted () {
    const tkn = localStorage.getItem('token')
    if (tkn === null) {
      alert('User not logged in')
      this.$router.push('login')
    }
  },
  methods: {
    addService () {
      const router = this.$router
      myaxios.post('/admin/addService', {
        serviceName: this.serviceName,
        availability: this.availability,
        price: this.price,
        headedBy: this.headedBy
        // numMembers: this.numMembers
      },
      {
        headers: {
          // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
          Authorization: `Bearer ${localStorage.getItem('token')}`
        }
      }).then((response) => {
        console.log(response.data)
        router.push('/admin/service')

        // if (response.data) { this.$router.push('index') }
      }).catch((error) => {
        this.errorMessage = error.message
        console.error('There was an error!', error)
        alert('An Error has occurred!')
        router.push('/')
      })
      // console.log('hello')
      // console.log(this.checkIn)
      // console.log(this.checkOut)
      // console.log(this.singleOcc)
      // console.log(this.doubleOcc)
      // console.log('checking')
    }
  }
}
</script>

  <style scoped>
      @import '@/assets/booking/booking-form.css';
  </style>
