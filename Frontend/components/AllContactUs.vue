<template>
  <div>
    <div v-if="getDetails===false" style="min-height: 100vh">
      <div class="row justify-content-between" style="text-align:center; margin-top: 40px">
        <div class="col-4">
          <h1>My Queries</h1>
        </div>
        <div class="col-4">
          <b-button size="lg" variant="dark" href="/contactus/askQuery">
            Ask Query
          </b-button>
        </div>
      </div>
      <ContactUsList
        v-for="query in queries"
        :key="query.queryID"
        :reply="query.reply"
        :query="query.query"
        @clicked="onClickListItem(query)"
      />
    </div>
    <div v-else>
      <button class="custom-btn btn-1" @click="goBacktoPage">
        <span>Back</span>
      </button>
      <ReplyDetails :reply="query" />
    </div>
  </div>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  props: ['customerid'],
  data () {
    return {
      getDetails: false,
      queries: [],
      query: {}
    }
  },
  mounted () {
    console.log(this.customerid)
    this.landingRequest()
  },
  methods: {
    landingRequest () {
      const router = this.$router
      myaxios
        .post(
          '/contactus/nullQuery',
          {
            customerID: this.customerid
          },
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
