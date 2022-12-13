<template>
  <div>
    <section class="content">
      <div class="feedback-description">
        <h1 class="title">
          Have a question?
        </h1>
        <p class="subtitle">
          Leave a message and we will help!
        </p>
      </div>
      <form class="feedback-form" @submit.prevent>
        <input v-model="name" class="feedback-form__email" placeholder="Name" required="">
        <input v-model="emailID" class="feedback-form__email" placeholder="Email ID" required="">
        <input v-model="contactNumber" class="feedback-form__email" placeholder="Contact Number" required="">
        <textarea
          v-model="query"
          class="feedback-form__message"
          cols="30"
          name="text"
          placeholder="Query"
          required=""
          rows="5"
        />
        <button @click="sendQuery">
          Submit
        </button>
      </form>
    </section>
  </div>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  data () {
    return {
      name: '',
      contactNumber: '',
      query: '',
      emailID: ''
    }
  },
  methods: {
    sendQuery () {
      const router = this.$router
      console.log(this.name + ' ' + this.contactNumber + ' ' + this.query + ' ' + this.emailID)
      myaxios
        .post('/contactus',
          {
            name: this.name,
            contactNumber: this.contactNumber,
            query: this.query,
            emailID: this.emailID
          },
          {
            headers: {
            // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
              Authorization: `Bearer ${localStorage.getItem('token')}`
            }
          }
        )
        .then(function (response) {
          console.log(response.data)
          router.push('/dashboard')
        })
        .catch((error) => {
          this.errorMessage = error.message
          console.error('There was an error!', error)
          alert('An Error has occurred!')
          router.push('/')
        })
    }
  }
}
</script>

<style scoped>
  * {
  font-weight: 300;
  font-family: "Roboto", "Segoe Ui", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 29px;
  color: #5b6d91;
  margin: 0;
}

section {
  height: 100vh;
}

body {
  margin: 0;
  padding: 0;
  background-color: #ecf2f7;
}

button {
  font-size: 14px;
  background-color: darkslategrey;
  padding: 12px 26px;
  border-radius: 40px;
  width: auto;
  color: white;
  border: none;
  cursor: pointer;
  box-shadow: 0px 8px 8px 0px rgba(0, 0, 0, 0.08);
}
button:hover{
  background-color: black;
}

textarea,
input {
  border: none;
  background-image: none;
  background-color: #fff;
  box-shadow: none;
  font-size: 14px;
  padding: 16px;
  border-radius: 10px;
  border: 0px;
  resize: none;
  box-shadow: 0px 7px 7px 0px rgba(0, 0, 0, 0.04);
}

input:hover,
input:focus {
  color: #000;
}

.content {
  height: 100vh;
  padding-top: 30px;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  margin: 0 auto;
  display: flex;
  align-items: center;
  max-width: 980px;
  justify-content: center;
}
.content .feedback-description {
  max-width: 310px;
  padding-bottom: 72px;
}
.content .feedback-description .subtitle {
  font-size: 16px;
}
.content .feedback-form {
  min-width: 280px;
  padding-left: 64px;
  display: flex;
  flex-direction: column;
}
.content .feedback-form * {
  margin-bottom: 16px;
}
.content .feedback-form button {
  align-self: flex-end;
}

@media screen and (max-width: 674px) {
  .content {
    flex-direction: column;
    align-items: center;
  }
  .content .feedback-form {
    padding-left: 0;
  }

  button {
    width: 100%;
  }
}
</style>
