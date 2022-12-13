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
              {{ feedback.feedbackID }}
            </div>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="check-in">
              Review
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="check-in-date">
              {{ feedback.reviews }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="check-out">
              Suggestion
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="check-out-date">
              {{ feedback.suggestions }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Date
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ feedback.fDate }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Time
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ feedback.fTime }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Customer ID
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ feedback.bookingID }}
            </span>
          </div>
        </div>
      </div>
    </div>
  </center>
</template>

<script>
export default {
  props: ['feedback'],
  mounted () {
    console.log(this.feedback.feedbackID)
    // getmapping for the passed bookingID
  }

}
</script>

<style scoped>
@import "@/assets/booking/bookingDetails.css"
</style>
