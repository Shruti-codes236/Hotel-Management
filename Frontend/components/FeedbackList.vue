<!-- <template>
  <section>
    <div class="container">
      <div class="request-details">
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Feedback ID</p>
          </div>
          <h3>{{ feedbackid }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Date</p>
          </div>
          <h3>{{ date }}</h3>
        </div>
        <div class="company">
          <div class="placeholder">
            <i class="fas fa-building" />
            <p>Time</p>
          </div>
          <h3>{{ time }}</h3>
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
</template> -->

<template>
  <div>
    <div class="card" style="margin: 100px 300px 50px; width: ;">
      <div class="card-body">
        <h5 class="card-title" style="font-size: 30px; font-weight: 600;">
          {{ review }} | {{ date }} | {{ time }}
        </h5>
        <p class="card-text" style="font-size: 24px;">
          {{ "Suggestion: " + suggestions }}
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
  props: ['suggestions', 'date', 'time', 'review'],
  mounted () {
    console.log(this.time)
  },
  methods: {
    goToDetails (event) {
      this.$emit('clicked')
    }
  }
}
</script>

<style scoped>
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
