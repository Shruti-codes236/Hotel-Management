<template>
  <div>
    <NavBar />
    <div v-if="getDetails===false" style="min-height: 100vh">
      <div class="row justify-content-between" style="text-align:center; margin-top: 40px">
        <div class="col-4">
          <h1>Services Available</h1>
        </div>
        <div class="col-4">
          <b-button size="lg" variant="dark" @click="serviceForm">
            Add Service
          </b-button>
        </div>
      </div>
      <ServiceList
        v-for="service in services"
        :key="service.serviceName"
        :sname="service.serviceName"
        :availability="service.availability"
        :price="service.price"
        :headedby="service.headedBy"
        @clicked="changeAvail(service)"
      />
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
      services: [],
      getDetails: false,
      avail: true,
      user: {},
      emp: {}
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
        if (!this.user.isEmp) {
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
        } else {
          alert('forbidden')
          this.$router.push('/forbidden')
        }
      })
      .catch((error) => {
        this.errorMessage = error.message
        console.error('There was an error!', error)
        alert('An Error has occurred!')
        router.push('/')
      })

    // getmapping
    myaxios
      .get(
        '/admin/service', // get mapping for all bookings
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
    changeAvail (value) {
      const router = this.$router
      myaxios
        .post(
          '/admin/alterAvail', // post mapping for all bookings
          {
            serviceName: value.serviceName,
            availability: value.availability,
            price: value.price,
            headedBy: value.headedBy
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
        }
        )
        .catch((error) => {
          this.errorMessage = error.message
          console.error('There was an error!', error)
          alert('An Error has occurred!')
          router.push('/')
        })
    },
    serviceForm () {
      this.$router.push('/serviceForm')
    }
  }

}

</script>

  <style scoped>
      @import '@/assets/booking/bookingList.css'
  </style>
