<template>
  <section>
    <div class="container">
      <!--single booking details-->
      <div class="request-details">
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Item Name</p>
          </div>
          <h3>{{ itemname }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Number of Items</p>
          </div>
          <h3>{{ noofitems }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Price</p>
          </div>
          <h3>{{ price }}</h3>
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
  props: ['itemname', 'noofitems', 'price'],
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
