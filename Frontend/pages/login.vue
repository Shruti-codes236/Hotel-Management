<template>
  <div>
    <NavBar />
    <div class="bgImg" />
    <div class="content">
      <div class="d-flex h-100 align-items-center justify-content-center">
        <div class="container">
          <div class="row">
            <div class="col-md-7 col-sm-6 ml-auto mr-auto">
              <div class="card">
                <div class="card-body">
                  <form>
                    <div class="glowBox">
                      <h2 class="title">
                        Log In
                      </h2>
                    </div>
                  </form>
                  <div class="logIn">
                    <span>
                      <input
                        v-model="pEmail"
                        type="text"
                        class="form"
                        placeholder="Email"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                    <span>
                      <input
                        v-model="pswd"
                        type="password"
                        class="form"
                        placeholder="Password"
                        autocomplete="off"
                        style="cursor: auto;"
                      >
                      <span class="underline" />
                    </span>
                  </div>
                  <center class="but-grp">
                    <button class="custom-btn btn-1" @click="customerLogin">
                      <span>Log In</span>
                    </button>
                  </center>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <Footer />
  </div>
</template>
<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  data () {
    return {
      pEmail: '',
      pswd: ''
    }
  },
  methods: {
    customerLogin () {
      const router = this.$router
      myaxios.post('/login', {
        pEmail: this.pEmail,
        pswd: this.pswd
      }).then(function (response) {
        // console.log(response.data.token)
        localStorage.setItem('token', response.data.token)
        console.log(localStorage.getItem('token'))
        router.push('/dashboard')
        // console.log('local storage set')
      }).catch((error) => {
        this.errorMessage = error.message
        alert('Invalid Credentials')
      })
    }
  }
}
</script>

<style scoped>
    @import url(@/assets/login/login.css);
</style>
