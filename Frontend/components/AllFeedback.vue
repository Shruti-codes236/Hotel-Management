<template>
  <div>
    <div v-if="getDetails===false">
      <div class="row justify-content-between" style="text-align:center; margin-top: 40px">
        <div class="col-4">
          <h1>Feedbacks</h1>
        </div>
      </div>
      <!-- <FeedbackList /> -->
      <FeedbackList
        v-for="feedback in feedbacks"
        :key="feedback.feedbackID"
        :suggestions="feedback.suggestions"
        :date="feedback.fDate"
        :time="feedback.fTime"
        :review="feedback.reviews"
        @clicked="onClickListItem(feedback)"
      />
    </div>
    <div v-else>
      <b-button size="lg" variant="dark" @click="goBacktoPage">
        <span>Back</span>
      </b-button>
      <FeedbackDetails :feedback="feedback" />
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
      feedbacks: [],
      feedback: {}
    }
  },
  mounted () {
    const router = this.$router
    // getmapping
    myaxios
      .get(
        '/admin/allFeedback', // get mapping for all feedback
        {
          headers: {
          // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        }

      )
      .then((response) => {
        this.feedbacks = response.data
        console.log(JSON.stringify(this.feedbacks))
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
      this.feedback = value
      console.log(this.feedback)
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
