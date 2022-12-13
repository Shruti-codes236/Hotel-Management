//subords ke props alag h isliye naya comp bnana pada
<template>
  <section>
    <div class="container">
      <!--single booking details-->
      <div class="request-details">
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>First Name</p>
          </div>
          <h3>{{ fname }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Last Name</p>
          </div>
          <h3>{{ lname }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Email</p>
          </div>
          <h3>{{ pemail }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Gender</p>
          </div>
          <h3>{{ gender }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Department</p>
          </div>
          <h3>{{ deptname }}</h3>
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
  props: ['fname', 'lname', 'pemail', 'gender', 'deptname'],
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
