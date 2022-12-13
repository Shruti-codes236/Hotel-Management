<template>
  <section>
    <div class="container">
      <!--single booking details-->
      <div class="request-details">
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Employee ID</p>
          </div>
          <h3>{{ employeeid }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Name</p>
          </div>
          <h3>{{ fname + " " + lname }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Email ID</p>
          </div>
          <h3>{{ emailid }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p />
          </div>
          <button class="custom-btn btn-1" @click="goToDetails">
            <span>View Details</span>
          </button>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  props: ['employeeid', 'emailid', 'fname', 'lname'],
  mounted () {
    console.log('mounted')
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
