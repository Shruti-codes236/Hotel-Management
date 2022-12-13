<template>
  <section>
    <div class="container">
      <!--single booking details-->
      <div class="request-details">
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Booking ID</p>
          </div>
          <h3>{{ bookingid }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Check In Date</p>
          </div>
          <h3>{{ checkin }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Check Out Date</p>
          </div>
          <h3>{{ checkout }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p />
          </div>
          <button class="custom-btn btn-1" @click="goToDetails">
            <span>ViewDetails</span>
          </button>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  props: ['bookingid', 'checkin', 'checkout'],
  mounted () {
    console.log('t')
  },
  methods: {
    goToDetails (event) {
      this.$emit('clicked')
    }
  }
}
</script>

<style scoped>
@import '@/assets/booking/bookingList.css'
</style>
