<template>
  <div>
    <center>
      <h3 style="margin-top: 50px">
        HOTEL BILL
      </h3>
    </center>
    <table
      class="table1"
      style="margin-top: 50px"
    >
      <tr>
        <th colspan="3">
          Invoice #{{ genBill.billID }}
        </th>
        <th>{{ genBill.bDate }}</th>
      </tr>
      <tr id="whiteBG">
        <td colspan="2">
          <h3>Pay To:</h3>
          Le Lotus Grand Hotel<br>
          Varanasi,<br>
          Uttar Pradesh, India- 221001
        </td>
        <td colspan="2">
          <h3>Customer:</h3>
          {{ genBill.fname + genBill.lname }}<br>
        </td>
      </tr>
      <tr>
        <th>
          Name-Description
        </th>
        <th>
          Qty.
        </th>
        <th>
          MRP
        </th>
        <th>
          Amount
        </th>
      </tr>
      <tr id="whiteBG">
        <td>
          Single Rooms
        </td>
        <td>
          {{ genBill.singleRoom }}
        </td>
        <td>
          {{ genBill.singlePrice }}
        </td>
        <td>
          {{ genBill.singlePrice * genBill.singleRoom }}
        </td>
      </tr>
      <tr id="whiteBG">
        <td>
          Double Rooms
        </td>
        <td>
          {{ genBill.doubleRoom }}
        </td>
        <td>
          {{ genBill.doublePrice }}
        </td>
        <td>
          {{ genBill.doubleRoom * genBill.doublePrice }}
        </td>
      </tr>
      <tr id="whiteBG">
        <td>
          Services
        </td>
        <td>
          --
        </td>
        <td>
          --
        </td>
        <td>
          {{ genBill.servicePrice }}
        </td>
      </tr>
      <tr>
        <td colspan="3">
          GRANDTOTAL
        </td>
        <td id="whiteBG">
          {{ genBill.amount }}
        </td>
      </tr>
    </table>
    <center>
      <button class="custom-btn btn-1" style="margin-top:50px" @click="pay">
        <span>{{ "Pay &#8377;   " + genBill.amount }}</span>
      </button>
    </center>
  </div>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  data () {
    return {
      genBill: {},
      user: {}
    }
  },
  mounted () {
    const tkn = localStorage.getItem('token')
    if (tkn === null) {
      alert('User not logged in')
      this.$router.push('/login')
    }
    const router = this.$router
    myaxios
      .get(
        '/dashboard', // get mapping for all userEmployee subords
        {
          headers: {
            // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        }

      )
      .then((response) => {
        this.user = response.data
        console.log(JSON.stringify(this.user))
        if (this.user.isEmp) {
          alert('forbidden')
          this.$router.push('/forbidden')
        }
      }
      )
      .catch((error) => {
        this.errorMessage = error.message
        console.error('There was an error!', error)
        alert('An Error has occurred!')
        router.push('/')
      })
    this.genBill = this.$route.params.genBill
    console.log(this.genBill)
  },
  methods: {
    pay () {
      const router = this.$router
      const razorScript = document.createElement('script')
      razorScript.setAttribute('src', 'https://checkout.razorpay.com/v1/checkout.js')
      document.head.appendChild(razorScript)
      console.log('payment started..' + this.amount)
      myaxios.post(
        '/transaction',
        {
          amount: this.genBill.amount
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
              alert('Payment Successful!!')
              router.push('/dashboard')
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

<style scoped>
@import '@/assets/bill/bill.css'
</style>
