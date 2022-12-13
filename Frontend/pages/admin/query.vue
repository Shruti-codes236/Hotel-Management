<template>
  <div>
    <NavBar />
    <div v-if="getDetails===false" style="height: 100vh">
      <div class="row justify-content-between" style="text-align:center; margin-top: 40px">
        <div class="col-4">
          <h1>Customer Queries</h1>
        </div>
      </div>
      <!-- <QueryList /> -->
      <QueryList
        v-for="query in queries"
        :key="query.queryID"
        :name="query.name"
        :query="query.query"
        :emailid="query.emailID"
        @clicked="onClickListItem(query)"
      />
    </div>
    <div v-else>
      <button class="custom-btn btn-1" @click="goBacktoPage">
        <span>Back</span>
      </button>
      <ReplyQuery :query="query" />
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
      queries: [],
      query: {},
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

    this.landingRequest()
  },
  methods: {
    landingRequest () {
      const router = this.$router
      myaxios
        .get(
          '/admin/allQuery',
          {
            headers: {
              Authorization: `Bearer ${localStorage.getItem('token')}`
            }
          }

        )
        .then((response) => {
          this.queries = response.data
          console.log(JSON.stringify(this.queries))
        }
        )
        .catch((error) => {
          this.errorMessage = error.message
          console.error('There was an error!', error)
          alert('An Error has occurred!')
          router.push('/')
        })
    },
    onClickListItem (value) {
      this.getDetails = true
      this.query = value
    },
    goBacktoPage () {
      this.landingRequest()
      this.getDetails = false
    }
  }

}
</script>

<style scoped>
    @import '@/assets/booking/bookingList.css'
</style>
