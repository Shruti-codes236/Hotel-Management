<template>
  <div>
    <section class="content">
      <div class="feedback-description">
        <h1 class="title">
          {{ query.name }}
        </h1>
        <p class="subtitle">
          {{ query.emailID }}
        </p>
      </div>
      <form class="feedback-form" @submit.prevent>
        <input class="feedback-form__email" :placeholder="query.query" disabled>
        <textarea
          v-model="reply"
          class="feedback-form__message"
          cols="30"
          name="text"
          placeholder="Reply"
          required=""
          rows="5"
        />
        <button @click="replyQuery">
          Reply
        </button>
      </form>
    </section>
  </div>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  props: ['query'],
  data () {
    return {
      reply: ''
    }
  },
  mounted () {
    console.log(this.query)
  },
  methods: {
    replyQuery () {
      const router = this.$router
      myaxios
        .post(
          '/admin/addReply',
          {
            queryID: this.query.queryID,
            reply: this.reply
          },
          {
            headers: {
              Authorization: `Bearer ${localStorage.getItem('token')}`
            }
          }
        )
        .then(function (response) {
          console.log(response.data)
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
