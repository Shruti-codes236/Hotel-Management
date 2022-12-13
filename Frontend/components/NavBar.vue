<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="name" href="/">Le Lotus Grand</a>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon" />
      </button>

      <div id="navbarSupportedContent" class="collapse navbar-collapse">
        <ul class="navbar-nav mr-auto">
          <!-- <li class="nav-item active">
            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="about">Link</a>
          </li> -->
          <!-- <li class="nav-item dropdown">
            <a
              id="navbarDropdown"
              class="nav-link dropdown-toggle"
              href="#"
              role="button"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >
              Dropdown
            </a> -->
          <!-- <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <div class="dropdown-divider" />
                <a class="dropdown-item" href="#">Something else here</a>
              </div> -->
          <!-- </li> -->
          <!-- <li class="nav-item">
            <a class="nav-link disabled" href="#">Disabled</a>
          </li> -->
        </ul>
        <a class="nav-link my-2 my-lg-0" href="/">Home
        </a>
        <a class=" nav-link my-2 my-lg-0" href="/#about">About
        </a>
        <button v-if="isloggedIn" class="custom-btn btn-1" @click="dashboard">
          Profile
        </button>
        <button v-if="!isloggedIn" class="custom-btn btn-1" @click="register">
          SignUp
        </button>
        <button v-if="!isloggedIn" class="custom-btn btn-1" @click="login">
          LogIn
        </button>
        <button v-if="isloggedIn" class="custom-btn btn-1" @click="logout">
          <span>LogOut</span>
        </button>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  data () {
    return {
      activeDropdown: null,
      isloggedIn: false
    }
  },
  mounted () {
    const tkn = localStorage.getItem('token')
    if (tkn === null) {
      this.isloggedIn = false
    } else {
      this.isloggedIn = true
    }
  },
  methods: {
    logout () {
      localStorage.removeItem('token')
      this.$router.push('/login')
    },
    dashboard () {
      this.$router.push('/dashboard')
    },
    register () {
      this.$router.push('/register')
    },
    login () {
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>
    @import '@/assets/NavBar/navbar.css';
</style>
