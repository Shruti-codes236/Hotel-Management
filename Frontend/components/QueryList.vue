<!-- <template>
  <section>
    <div class="container">
      <div class="request-details">
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Name</p>
          </div>
          <h3>{{ name }}</h3>
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
            <p>Query</p>
          </div>
          <h3>{{ query }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p />
          </div>
          <button class="custom-btn btn-1" @click="goToDetails">
            <span>Reply</span>
          </button>
        </div>
      </div>
    </div>
  </section>
</template> -->
<template>
  <div>
    <div class="card" style="margin: 100px 300px 50px; width: ;">
      <div class="card-body">
        <h5 class="card-title" style="font-size: 30px; font-weight: 600;">
          {{ name }} | {{ emailid }}
        </h5>
        <p class="card-text" style="font-size: 24px;">
          {{ query }}
        </p>
        <a
          href="#"
          class="btn btn-primary"
          style="font-size: 20px;"
          @click="goToDetails"
        >Reply</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['name', 'query', 'emailid'],
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
/* @import '@/assets/booking/bookingList.css' */
.card:hover{
  transition: all 0.3s ease-in-out;
scale: 1.1;
}
.card-text{
  display: block;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;

}

</style>
