<template>
  <div>
    <div v-if="getDetails===false" style="height: 100vh">
      <div class="row justify-content-between" style="text-align:center; margin-top: 40px">
        <div class="col-4">
          <h1>My Replies</h1>
        </div>
      </div>
      <ReplyList
        v-for="reply in replies"
        :key="reply.queryID"
        :reply="reply.reply"
        :query="reply.query"
        @clicked="onClickListItem(reply)"
      />
    </div>
    <div v-else>
      <button class="custom-btn btn-1" @click="goBacktoPage">
        <span>Back</span>
      </button>
      <ReplyDetails :reply="reply" />
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
      replies: [],
      reply: {}
    }
  },
  created () {
    console.log(this.customerid)
    this.landingRequest()
  },
  methods: {
    landingRequest () {
      const router = this.$router
      myaxios
        .post(
          '/contactus/repliedQuery',
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
          this.replies = response.data
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
      this.reply = value
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
