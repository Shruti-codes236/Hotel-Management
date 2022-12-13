<template>
  <div>
    <NavBar />
    <AllReplies :customerid="customerID" />
    <Footer />
  </div>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  data () {
    return {
      customerID: '',
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
  },
  created () {
    this.customerID = this.$route.params.customerid
    console.log(this.customerID)
  }
}
</script>
