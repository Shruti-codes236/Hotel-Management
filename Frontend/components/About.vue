<template>
  <div>
    <!-- <NavBar /> -->
    <section id="about">
      <div class="container">
        <header class="section-header aos-init">
          <h2 style="font-size: 48px; margin-top: 40px; font-weight: bold; text-align: center;">
            About Us
          </h2>
          <br>
          <p style="font-size: 21px;">
            Establised in 2000, Le Lotus aims to provide customers with the most luxurious and comfortable stay in Varanasi to
            the customers
          </p>
        </header>
        <div class="row about-cols">
          <div class="col-md-4">
            <div class="about-col">
              <div class="img">
                <img
                  src="@/static/imgs/demo3.jpg"
                  alt=""
                  class="img-fluid"
                >
                <div class="icon">
                  <i class="fas fa-tachometer-alt" />
                </div>
              </div>
              <h2 class="title">
                Our Mission
              </h2>
              <p>
                We want to spread our business throughtout the world by providing luxurious, comfortable and affordable stay to our
                guests. We want to become the worlds' biggest chain of hotels in the next decade. <br> <br> <br> <br>
              </p>
            </div>
          </div>
          <div class="col-md-4">
            <div class="about-col">
              <div class="img">
                <img
                  src="@/static/imgs/demo2.jpg"
                  alt=""
                  class="img-fluid"
                >
                <div class="icon">
                  <i class="far fa-list-alt" />
                </div>
              </div>
              <h2 class="title">
                Our Plan
              </h2>
              <p>
                Firstly we will be spreading our business in metro cities by the end of this year. Then we will focus on maitaining
                those hotels by keeping our customers happy so that we can become their first choice of stay whenever they plan a
                trip. Then by the end of this decade we will expand our business to countries like England. <br> <br>
              </p>
            </div>
          </div>
          <div class="col-md-4">
            <div class="about-col">
              <div class="img">
                <img
                  src="@/static/imgs/demo1.jpg"
                  alt=""
                  class="img-fluid"
                >
                <div class="icon">
                  <i class="far fa-eye" />
                </div>
              </div>
              <h2 class="title">
                Our Vision
              </h2>
              <p>
                We want to be your first choice whenever you plan to visit Varansi. Our long-term vision is to be the company of
                choice for guests, owners and talent. Whenever a guest plans a trip, or an investor or owner is thinking of a
                partner, or whenever someone is looking for a career in the hospitality industry, they will all think of Le Lotus
                Grand Hotel first.
              </p>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- <Footer /> -->
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
* {
    font-family: "Poppins", sans-serif;
}

a:hover {
    text-decoration: none;
}

#about {
    background: url("@/static/imgs/201684636.jpg") center top no-repeat fixed;
    background-size: cover;
    padding: 29px 0 40px 0;
    position: relative;
}

.section-header h3 {
    font-size: 32px;
    color: #111;
    text-transform: uppercase;
    text-align: center;
    font-weight: 700;
    position: relative;
    padding-bottom: 15px;
}

.section-header h3::before {
    content: '';
    position: absolute;
    display: block;
    width: 120px;
    height: 1px;
    background: #ddd;
    bottom: 1px;
    left: calc(50% - 60px);
}

.section-header h3::after {
    content: '';
    position: absolute;
    display: block;
    width: 40px;
    height: 3px;
    background: #575a7b;
    bottom: 0;
    left: calc(50% - 20px);
}

.section-header p {
    text-align: center;
    padding-bottom: 30px;
    color: #333;
}

#about::before {
    content: '';
    position: absolute;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    background: rgb(255 255 255 / 48%);
    z-index: 9;
}

#about .container {
    position: relative;
    z-index: 10;
}

#about .about-col {
    background: #fff;
    border-radius: 0 0 4px 4px;
    box-shadow: 0px 2px 12px rgba(0, 0, 0, 0.08);
    margin-bottom: 20px;
}

#about .about-col .img {
    position: relative;
}

#about .about-col .img img {
    border-radius: 4px 4px 0 0;
}

#about .about-col .icon {
    width: 64px;
    height: 64px;
    padding-top: 8px;
    text-align: center;
    position: absolute;
    background-color: #575a7b;
    border-radius: 50%;
    text-align: center;
    border: 4px solid #fff;
    left: calc(50% - 32px);
    bottom: -30px;
    transition: 0.3s;
}

#about .about-col i {
    font-size: 24px;
    line-height: 1.5;
    color: #fff;
    transition: 0.3s;
}

#about .about-col:hover .icon {
    background-color: #fff;
}

#about .about-col:hover i {
    color: #575a7b;
}

#about .about-col h2 {
    color: #000;
    text-align: center;
    font-weight: 700;
    font-size: 20px;
    padding: 0;
    margin: 40px 0 12px 0;
}

#about .about-col h2 a {
    color: #000;
}

#about .about-col p {
    font-size: 14px;
    line-height: 24px;
    color: #333;
    margin-bottom: 0;
    padding: 0 20px 20px 20px;
}

.btn-sm-default-web {
    background: #0c2b4b;
    display: inline-block;
    text-transform: uppercase;
    padding: 5px 30px;
    color: #ffffff;
    letter-spacing: 1px;
}
</style>
