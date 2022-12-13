<template>
  <section>
    <div class="container">
      <!--single booking details-->
      <div class="request-details">
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Service Name</p>
          </div>
          <h3>{{ sname }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Availability</p>
          </div>
          <h3>{{ availability }}</h3>
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
            <p>Headed By</p>
          </div>
          <h3>{{ headedby }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>#</p>
          </div>
          <button class="custom-btn btn-1" @click="changeAvail">
            <span>Change Availability</span>
          </button>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  props: ['sname', 'availability', 'price', 'headedby'],
  mounted () {
    console.log('t')
  },
  methods: {
    changeAvail (event) {
      this.$emit('clicked')
    }
  }
}
</script>

  <style scoped>
  @import '@/assets/booking/bookingList.css'
  </style>
