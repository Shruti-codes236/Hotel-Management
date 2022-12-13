<template>
  <div>
    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      background="#ababab"
      img-width="1024"
      img-height="480"
      style="text-shadow: 1px 1px 2px #333;"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
      <!-- Text slides with image -->
      <b-carousel-slide
        caption="Welcome to hotel le lotus Grand!"
        text="Situated close to Kashi Vishwanath Temple"
        img-src="@/static/imgs/hotelimg.jpg"
      />

      <!-- Slides with custom text -->
      <b-carousel-slide img-src="@/static/imgs/oswald-elsaboath-7EDZ1fxhgJQ-unsplash.jpg">
        <!-- <h1>Hello world!</h1> -->
      </b-carousel-slide>
      <!-- Slides with image only -->
      <b-carousel-slide img-src="@/static/imgs/vojtech-bruzek-Yrxr3bsPdS0-unsplash.jpg" />

      <!-- Slides with img slot -->
    </b-carousel>
  </div>
</template>

<script>
export default {
  data () {
    return {
      slide: 0,
      sliding: null
    }
  },
  methods: {
    onSlideStart (slide) {
      this.sliding = true
    },
    onSlideEnd (slide) {
      this.sliding = false
    }
  }
}
</script>
