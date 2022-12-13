<template>
  <div class="page-content" style="height: 68vh">
    <div class="card">
      <div class="card-1">
        <div class="content">
          <h2 class="title">
            Employees
          </h2>
          <p class="copy">
            Manage employees and their salaries
          </p>
          <button class="btn" @click="manageEmployee">
            Manage
          </button>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-2">
        <div class="content">
          <h2 class="title">
            Customer Queries
          </h2>
          <p class="copy">
            Review Customer Feedback and reply Customer Queries
          </p>
          <button class="btn" @click="manageFeedback">
            View Feedback
          </button>
          <button class="btn" @click="manageQuery">
            Reply Query
          </button>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-3">
        <div class="content">
          <h2 class="title">
            Services
          </h2>
          <p class="copy">
            Manage and review Department and Services
          </p>
          <button class="btn" @click="manageServices">
            Manage Service
          </button>
          <button class="btn" @click="manageItem">
            Manage Item
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    manageServices () {
      this.$router.push('/admin/service')
    },
    manageEmployee () {
      this.$router.push('/admin/employee')
    },
    manageFeedback () {
      this.$router.push('/admin/feedback')
    },
    manageQuery () {
      this.$router.push('/admin/query')
    },
    manageItem () {
      this.$router.push('/admin/items')
    }
  }
}
</script>

<style scoped>
body {
  /* display: -ms-grid;
  display: grid; */
  place-items: center;
}
.page-content {
  display: -ms-grid;
  place-items: center;
  display: grid;
  grid-gap: 2rem;
  /* padding: 1rem; */
  padding-bottom: 14rem;
  max-width: 1024px;
  margin: 0 auto;
  height:100%;
  font-family: 'Rubik', sans-serif;
  margin-top: 80px;
}

@media (min-width: 600px) {
  .page-content {
    -ms-grid-columns: (1fr)[2];
        grid-template-columns: repeat(3, 1fr);
  }
}

@media (min-width: 300px) {
  .page-content {
    -ms-grid-columns: (1fr)[3];
        grid-template-columns: repeat(3, 1fr);
  }
}

.card {
  position: relative;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: end;
      -ms-flex-align: end;
          align-items: flex-end;
  overflow: hidden;
    width: 100%;
  text-align: center;
  color: black;
  background-color: whitesmoke;
  -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1), 0 2px 2px rgba(0, 0, 0, 0.1), 0 4px 4px rgba(0, 0, 0, 0.1), 0 8px 8px rgba(0, 0, 0, 0.1), 0 16px 16px rgba(0, 0, 0, 0.1);
          box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1), 0 2px 2px rgba(0, 0, 0, 0.1), 0 4px 4px rgba(0, 0, 0, 0.1), 0 8px 8px rgba(0, 0, 0, 0.1), 0 16px 16px rgba(0, 0, 0, 0.1);
}
.card-1{
  background-image: url("static/imgs/hotel.png");
  background-size: 320px 350px;
  position: relative;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: end;
      -ms-flex-align: end;
          align-items: flex-end;
  overflow: hidden;
  width: 100%;
  height:100%;
  text-align: center;
  color: white;
  background-color: whitesmoke;
  -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1), 0 2px 2px rgba(0, 0, 0, 0.1), 0 4px 4px rgba(0, 0, 0, 0.1), 0 8px 8px rgba(0, 0, 0, 0.1), 0 16px 16px rgba(0, 0, 0, 0.1);
          box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1), 0 2px 2px rgba(0, 0, 0, 0.1), 0 4px 4px rgba(0, 0, 0, 0.1), 0 8px 8px rgba(0, 0, 0, 0.1), 0 16px 16px rgba(0, 0, 0, 0.1);
}
.card-2 {
  background-image: url("static/imgs/feedback1.webp");
  background-size: 320px 400px;
  position: relative;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: end;
  -ms-flex-align: end;
  align-items: flex-end;
  overflow: hidden;
  width: 100%;
  height: 100%;
  text-align: center;
  color: white;
  background-color: whitesmoke;
  -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1), 0 2px 2px rgba(0, 0, 0, 0.1), 0 4px 4px rgba(0, 0, 0, 0.1), 0 8px 8px rgba(0, 0, 0, 0.1), 0 16px 16px rgba(0, 0, 0, 0.1);
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1), 0 2px 2px rgba(0, 0, 0, 0.1), 0 4px 4px rgba(0, 0, 0, 0.1), 0 8px 8px rgba(0, 0, 0, 0.1), 0 16px 16px rgba(0, 0, 0, 0.1);
}
.card-3 {
  background-image: url("static/imgs/services.jpeg");
  background-size: 320px 400px;
  background-position-x: 20;
  background-position-x: 100;
  position: relative;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: end;
  -ms-flex-align: end;
  align-items: flex-end;
  overflow: hidden;
  width: 100%;
  height: 100%;
  text-align: center;
  color: white;
  background-color: whitesmoke;
  -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1), 0 2px 2px rgba(0, 0, 0, 0.1), 0 4px 4px rgba(0, 0, 0, 0.1), 0 8px 8px rgba(0, 0, 0, 0.1), 0 16px 16px rgba(0, 0, 0, 0.1);
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1), 0 2px 2px rgba(0, 0, 0, 0.1), 0 4px 4px rgba(0, 0, 0, 0.1), 0 8px 8px rgba(0, 0, 0, 0.1), 0 16px 16px rgba(0, 0, 0, 0.1);
}

@media (min-width: 300px) {
  .card {
    height: 350px;
  }
}

.card:before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 110%;
  background-size: cover;
  background-position: 0 0;
  -webkit-transition: -webkit-transform calc(0.7s * 1.5) cubic-bezier(0.19, 1, 0.22, 1);
  transition: -webkit-transform calc(0.7s * 1.5) cubic-bezier(0.19, 1, 0.22, 1);
  transition: transform calc(0.7s * 1.5) cubic-bezier(0.19, 1, 0.22, 1);
  transition: transform calc(0.7s * 1.5) cubic-bezier(0.19, 1, 0.22, 1), -webkit-transform calc(0.7s * 1.5) cubic-bezier(0.19, 1, 0.22, 1);
  pointer-events: none;
  /* background-image: url("https://images.pexels.com/photos/189349/pexels-photo-189349.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"); */
  /* background-image: url("https://media.istockphoto.com/vectors/shopping-basket-with-tubes-vector-id682190248?k=20&m=682190248&s=612x612&w=0&h=EPuJMqY_7vD04zQKZdTKnmZl4agrF_3vQKacUiRKH74="); */
  /* background-image: url("https://www.pinclipart.com/picdir/middle/132-1322224_whats-cooking-grocery-bag-of-food-clipart.png"); */
}

.card:after {
  content: '';
  display: block;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 200%;
  pointer-events: none;
  background-image: webkit-gradient(linear, left top, left bottom, from(rgba(0, 0, 0, 0)), color-stop(11.7%, rgba(0, 0, 0, 0.009)), color-stop(22.1%, rgba(0, 0, 0, 0.034)), color-stop(31.2%, rgba(0, 0, 0, 0.072)), color-stop(39.4%, rgba(0, 0, 0, 0.123)), color-stop(46.6%, rgba(0, 0, 0, 0.182)), color-stop(53.1%, rgba(0, 0, 0, 0.249)), color-stop(58.9%, rgba(0, 0, 0, 0.32)), color-stop(64.3%, rgba(0, 0, 0, 0.394)), color-stop(69.3%, rgba(0, 0, 0, 0.468)), color-stop(74.1%, rgba(0, 0, 0, 0.54)), color-stop(78.8%, rgba(0, 0, 0, 0.607)), color-stop(83.6%, rgba(0, 0, 0, 0.668)), color-stop(88.7%, rgba(0, 0, 0, 0.721)), color-stop(94.1%, rgba(0, 0, 0, 0.762)), to(rgba(0, 0, 0, 0.79)));
  background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0) 0%, rgba(0, 0, 0, 0.009) 11.7%, rgba(0, 0, 0, 0.034) 22.1%, rgba(0, 0, 0, 0.072) 31.2%, rgba(0, 0, 0, 0.123) 39.4%, rgba(0, 0, 0, 0.182) 46.6%, rgba(0, 0, 0, 0.249) 53.1%, rgba(0, 0, 0, 0.32) 58.9%, rgba(0, 0, 0, 0.394) 64.3%, rgba(0, 0, 0, 0.468) 69.3%, rgba(0, 0, 0, 0.54) 74.1%, rgba(0, 0, 0, 0.607) 78.8%, rgba(0, 0, 0, 0.668) 83.6%, rgba(0, 0, 0, 0.721) 88.7%, rgba(0, 0, 0, 0.762) 94.1%, rgba(0, 0, 0, 0.79) 100%);
  -webkit-transform: translateY(-50%);
          transform: translateY(-50%);
  -webkit-transition: -webkit-transform calc(0.7s * 2) cubic-bezier(0.19, 1, 0.22, 1);
  transition: -webkit-transform calc(0.7s * 2) cubic-bezier(0.19, 1, 0.22, 1);
  transition: transform calc(0.7s * 2) cubic-bezier(0.19, 1, 0.22, 1);
  transition: transform calc(0.7s * 2) cubic-bezier(0.19, 1, 0.22, 1), -webkit-transform calc(0.7s * 2) cubic-bezier(0.19, 1, 0.22, 1);
}

.content {
  position: relative;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
      -ms-flex-direction: column;
          flex-direction: column;
  -webkit-box-align: center;
      -ms-flex-align: center;
          align-items: center;
  width: 100%;
  padding: 1rem;
  -webkit-transition: -webkit-transform 0.7s cubic-bezier(0.19, 1, 0.22, 1);
  transition: -webkit-transform 0.7s cubic-bezier(0.19, 1, 0.22, 1);
  transition: transform 0.7s cubic-bezier(0.19, 1, 0.22, 1);
  transition: transform 0.7s cubic-bezier(0.19, 1, 0.22, 1), -webkit-transform 0.7s cubic-bezier(0.19, 1, 0.22, 1);
  z-index: 1;
}

.content > * + * {
  margin-top: 1rem;
}

.title {
  font-size: 22px;
  font-weight: bold;
  line-height: 26px;
}

.copy {
  font-family: 'Cardo', serif;
  font-size: 16px;
  font-style: italic;
  line-height: 22px;
}

.btn {
  cursor: pointer;
  margin-top: 20px;
  padding: 12px 25px;
  font-size: 14px;
  font-weight: bold;
  letter-spacing: 0.025rem;
  text-transform: uppercase;
  color: white;
  background-color: black;
  border: none;
}

.btn:hover {
  background-color: brown;
}

.btn:focus {
  outline: 1px dashed brown;
  outline-offset: 3px;
}

@media (hover: hover) and (min-width: 600px) {
  .card:after {
    -webkit-transform: translateY(0);
            transform: translateY(0);
  }
  .content {
    -webkit-transform: translateY(calc(100% - 90px));
            transform: translateY(calc(100% - 90px));
  }
  .content > *:not(.title) {
    opacity: 0;
    -webkit-transform: translateY(1rem);
            transform: translateY(1rem);
    -webkit-transition: opacity 0.7s cubic-bezier(0.19, 1, 0.22, 1), -webkit-transform 0.7s cubic-bezier(0.19, 1, 0.22, 1);
    transition: opacity 0.7s cubic-bezier(0.19, 1, 0.22, 1), -webkit-transform 0.7s cubic-bezier(0.19, 1, 0.22, 1);
    transition: transform 0.7s cubic-bezier(0.19, 1, 0.22, 1), opacity 0.7s cubic-bezier(0.19, 1, 0.22, 1);
    transition: transform 0.7s cubic-bezier(0.19, 1, 0.22, 1), opacity 0.7s cubic-bezier(0.19, 1, 0.22, 1), -webkit-transform 0.7s cubic-bezier(0.19, 1, 0.22, 1);
  }
  .card:hover,
  .card:focus-within {
    -webkit-box-align: center;
        -ms-flex-align: center;
            align-items: center;
  }
  .card:hover:before,
  .card:focus-within:before {
    -webkit-transform: translateY(-4%);
            transform: translateY(-4%);
  }
  .card:hover:after,
  .card:focus-within:after {
    -webkit-transform: translateY(-50%);
            transform: translateY(-50%);
  }
  .card:hover .content,
  .card:focus-within .content {
    -webkit-transform: translateY(0);
            transform: translateY(0);
  }
  .card:hover .content > *:not(.title),
  .card:focus-within .content > *:not(.title) {
    opacity: 1;
    -webkit-transform: translateY(0);
            transform: translateY(0);
    -webkit-transition-delay: calc(0.7s / 8);
            transition-delay: calc(0.7s / 8);
  }
  .card:focus-within:before, .card:focus-within:after,
  .card:focus-within .content,
  .card:focus-within .content > *:not(.title) {
    -webkit-transition-duration: 0s;
            transition-duration: 0s;
  }
}
</style>
