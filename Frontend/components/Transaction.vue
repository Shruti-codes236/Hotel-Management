<template>
  <div>
    <button @click="paymentHandler">
      Pay
    </button>
  </div>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  data () {
    return {
      amount: '100'
    }
  },
  mounted () {
    const razorScript = document.createElement('script')
    razorScript.setAttribute('src', 'https://checkout.razorpay.com/v1/checkout.js')
    document.head.appendChild(razorScript)
  },
  methods: {
    paymentHandler () {
      console.log('payment started..' + this.amount)
      const router = this.$router
      myaxios.post(
        '/transaction',
        {
          amount: this.amount
        },
        {
          headers: {
            // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        }
      ).then((response) => {
        console.log(response.data)
        if (response.data.status === 'created') {
        // open payment gateway
          const options = {
            key: 'rzp_test_7dHk9zNMuGYDSV', // Enter the Key ID generated from the Dashboard
            amount: response.data.amount, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
            currency: 'INR',
            name: 'Le Lotus Grand',
            description: 'Test Transaction',
            image: '@/static/imgs/exterior-night.jpg',
            order_id: response.data.id,
            handler: function (response) {
              console.log(response.razorpay_payment_id)
              console.log(response.razorpay_order_id)
              console.log(response.razorpay_signature)
              console.log('Payment Succesful')
            },
            prefill: {
              name: '',
              email: '',
              contact: ''
            },
            notes: {
              address: 'Le Lotus Grand'
            },
            theme: {
              color: '#3399cc'
            }
          }
          // eslint-disable-next-line no-undef
          const rzp = new Razorpay(options)

          rzp.on('payment.failed', function (response) {
            console.log(response.error.code)
            console.log(response.error.description)
            console.log(response.error.source)
            console.log(response.error.step)
            console.log(response.error.reason)
            console.log(response.error.metadata.order_id)
            console.log(response.error.metadata.payment_id)
          })

          rzp.open()
        }
      }).catch((error) => {
        this.errorMessage = error.message
        console.error('There was an error!', error)
        alert('An Error has occurred!')
        router.push('/')
      })
    }
  }
}
</script>
