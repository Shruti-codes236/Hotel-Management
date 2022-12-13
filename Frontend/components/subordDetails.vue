<template>
  <center>
    <div class="col-md-6 col-sm-6 ">
      <div class="chunk booking-card clearfix">
        <!-- <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <span class="profile-pic" />
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9 name-date">
            <div class="guest-name">
              {{ booking.bookingID }}
            </div>
          </div>
        </div> -->
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="check-in">
              First Name
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="check-in-date">
              {{ subord.fname }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-5 col-xs-4 card-catergory">
            <span class="check-in">
              Last Name
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="check-in-date">
              {{ subord.lname }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="check-out">
              Email
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="check-out-date">
              {{ subord.pEmail }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Gender
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ subord.gender }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Permanent Address
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ subord.houseNo + " "+ subord.city+ " "+subord.state+ " "+subord.country+ " "+subord.pincode }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Current Address
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ subord.currHouseNo + " "+ subord.currCity+ " "+subord.currState+ " "+subord.currPincode }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Salary
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ subord.salary }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Department Name
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ subord.deptName }}
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
    </div>
  </center>
</template>

<script>
export default {
  props: ['subord'],
  mounted () {
    console.log(this.subord)
    // getmapping for the passed bookingID
  }

}
</script>

  <style scoped>
  @import "@/assets/booking/bookingDetails.css"
  </style>
