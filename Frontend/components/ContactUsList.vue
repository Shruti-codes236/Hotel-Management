<template>
  <div>
    <div class="card" style="margin: 100px 300px 50px; width: ;">
      <div class="card-body">
        <h5 class="card-title" style="font-size: 30px; font-weight: 600;">
          {{ "Q: " + query }}
        </h5>
        <p class="card-text" style="font-size: 24px;">
          A: <span style="color: grey">No Reply Yet</span>
        </p>
        <a
          href="#"
          class="btn btn-primary"
          style="font-size: 20px;"
          @click="goToDetails"
        >View Details</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['reply', 'query'],
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
