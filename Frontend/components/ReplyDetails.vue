<template>
  <center style="min-height: 69vh">
    <div class="col-md-6 col-sm-6">
      <div class="chunk booking-card clearfix">
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <span class="profile-pic" />
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9 name-date">
            <div class="guest-name">
              Query Details
            </div>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="check-in">
              Name
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="check-in-date">
              {{ reply.name }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="check-out">
              Contact Number
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="check-out-date">
              {{ reply.contactNumber }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Email ID
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ reply.emailID }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Query Date
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ reply.date }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Query Time
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ reply.time }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Query
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ reply.query }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Reply
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ reply.reply }}
            </span>
          </div>
        </div>
      </div>
    </div>
  </center>
</template>

<script>
export default {
  props: ['reply'],
  mounted () {
    console.log(JSON.stringify(this.reply))
    // getmapping for the passed bookingID
  }
}
</script>

<style>
@import "@/assets/booking/bookingDetails.css"
</style>
